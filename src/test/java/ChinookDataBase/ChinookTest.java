package ChinookDataBase;

import Utilities.DBUtility;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class ChinookTest extends DBUtility {
    @Test
    public void getSpecificArtistAllAlbumSongs(){

        String sql = "SELECT Artist.Name AS ArtistName, Album.Title AS AlbumTitle, Track.Name AS TrackName" +
                "                     FROM Album" +
                "                     JOIN Artist ON Album.ArtistId = Artist.ArtistId" +
                "                     JOIN Track ON Album.AlbumId = Track.AlbumId" +
                "                     WHERE Artist.Name = 'AC/DC'" +
                "                     ORDER BY Artist.ArtistId, Album.Title, Track.Name;";

        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row : result){
            String artistName = row.get(0);
            String albumTitle = row.get(1);
            String trackName = row.get(2);

            System.out.println("Artist: " + artistName + ", Album: " + albumTitle + ", Track: "+trackName);
        }
    }

    @Test
    public void mergeAllArtistAlbumSong(){
        String sql="SELECT Artist.Name AS ArtistName, Album.Title AS AlbumTitle, Track.Name AS TrackName " +
                "FROM Album "+
                "JOIN Artist ON Album.ArtistId = Artist.ArtistId "+
                "JOIN Track ON Album.AlbumId = Track.AlbumId "+
                "ORDER BY Artist.ArtistId, Album.Title,Track.Name";
        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row : result){
            String artistName=row.get(0);
            String albumTitle=row.get(1);
            String trackName=row.get(2);

            System.out.println("Artist: "+ artistName + ", Album: "+ albumTitle+" , Track:"+trackName);
        }

    }
    @Test
    public void mergeTracksAndMediaTypes(){
        String sql="SELECT Track.Name AS TrackName, MediaType.Name AS MediaType "+
                "FROM Track "+
                "JOIN MediaType ON Track.MediaTypeId=MediaType.MediaTypeId "+
                "ORDER BY Track.Name";

        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row :result){
            String trackName=row.get(0);
            String mediaType=row.get(1);

            System.out.println("Track Name :"+ trackName+ " ---->" +" Media Type : "+mediaType);
        }
    }

    @Test
    public void mergeTracksAndGenre(){
        String sql="SELECT Track.Name AS TrackName, Genre.Name AS GenreName "+
                "FROM Track "+
                "JOIN Genre ON Track.GenreId=Genre.GenreId "+
                "ORDER By Track.Name DESC";

        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row : result){
            String trackName=row.get(0);
            String genre=row.get(1);

            System.out.println("Track Name :"+ trackName+ " ---->" +" Media Type : "+genre);
        }
    }
    @Test
    public void getAllCustomersInfo(){
        String sql="SELECT * FROM Customer";

        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row : result){
            String customerID=row.get(0);
            String firstName=row.get(1);
            String lastName=row.get(2);
            String company=row.get(3);
            String address=row.get(4);
            String city=row.get(5);
            String state=row.get(6);
            String country=row.get(7);
            String postalCode=row.get(8);
            String phone=row.get(9);
            String fax=row.get(10);
            String email=row.get(11);

            System.out.println(customerID+"-"+ firstName+" "+lastName+" Company Name : "+" ("+company+") "+" Address: "+address+
                    " City: "+city+ " State: "+state+" Country: "+country+" postalCode: "+postalCode+" phone: "+phone+
                    " Fax: "+ fax+" email: "+email);
        }
    }
    @Test
    public void customersByCountry(){

        String sql="SELECT Country, count(*) AS CustomerCount "+
                "FROM Customer "+
                "GROUP BY Country "+
                "ORDER BY CustomerCount DESC";

        ArrayList<ArrayList<String>>result=getListData(sql);
        for (ArrayList<String> row : result){
            String country=row.get(0);
            String customerCount=row.get(1);

            System.out.println("Country: "+country+" customerCount:"+customerCount);
        }
    }

    @Test
    public void customersByCity(){

        String sql="SELECT City, count(*) AS CustomerCount "+
                "FROM Customer "+
                "GROUP BY City "+
                "ORDER BY CustomerCount DESC";

        ArrayList<ArrayList<String>>result=getListData(sql);
        for (ArrayList<String> row : result){
            String country=row.get(0);
            String customerCount=row.get(1);

            System.out.println("Country: "+country+" customerCount:"+customerCount);
        }
    }
    @Test
    public void getCustomersEmail(){
        String sql="SELECT Email AS Email "+
                "FROM Customer";
        ArrayList<ArrayList<String>>result=getListData(sql);
        for (ArrayList<String> row : result){
            String email=row.get(0);
            System.out.println(email);
        }
    }
    @Test
    public void customerInvoice(){
        //Most Purchased Customer List, Merge Other Table with ids
        String sql="SELECT Invoice.InvoiceId, Invoice.InvoiceDate, InvoiceLine.TrackId,InvoiceLine.UnitPrice, Customer.CustomerId, Customer.FirstName, Customer.LastName "+
                "FROM Invoice "+
                "JOIN InvoiceLine ON Invoice.InvoiceId=InvoiceLine.InvoiceId "+
                "JOIN Customer ON Invoice.CustomerId=Customer.CustomerId "+
                "ORDER BY Customer.CustomerId DESC";
        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String>row : result){
            String invoiceId=row.get(0);
            String invoiceDate=row.get(1);
            String trackId=row.get(2);
            String unitPrice=row.get(3);
            String customerId=row.get(4);
            String firstName=row.get(5);
            String lastName=row.get(6);

            System.out.println(invoiceId+" "+invoiceDate+ " "+trackId+" "+unitPrice+" "+customerId+" "+firstName+" "+lastName);
        }
    }

    @Test
    public void totalPurchasedByCustomer(){
        //Most Purchased Customer List, Merge Other Table with ids
        String sql="SELECT Customer.CustomerId, Customer.FirstName, Customer.LastName, COUNT(Invoice.InvoiceId) AS SaleCount, SUM(Invoice.Total) AS TotalSales "+
                "FROM Customer "+
                "JOIN Invoice ON Customer.CustomerId=Invoice.CustomerID "+
                "GROUP BY Customer.CustomerID";
        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String>row : result){
            String customerID=row.get(0);
            String firstName=row.get(1);
            String lastName=row.get(2);
            String saleCount=row.get(3);
            String totalSales=row.get(4);


            System.out.println("CustomerID= "+customerID+" FirstName= "+firstName+ " LastName= "+lastName+" SalesCount= "+saleCount+" TotalSales= "+totalSales);
        }
    }
    @Test
    public void mergeTrackAndPlayList(){
        String sql="SELECT Track.TrackId, Track.Name, Playlist.PlaylistId, Playlist.Name "+
                "FROM PlaylistTrack "+
                "JOIN Track ON Track.TrackId=PlaylistTrack.TrackId "+
                "JOIN Playlist ON PlaylistTrack.PlaylistId=Playlist.PlaylistId";
        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row:result){
            String trackId=row.get(0);
            String trackName=row.get(1);
            String playListId=row.get(2);
            String playListName=row.get(3);
            System.out.println("--"+trackId+"--"+trackName+"--"+playListId+"--"+playListName);
        }
    }
    @Test
    public void mostListensArtist(){
        String sql="SELECT Artist.Name AS ArtistName, SUM(InvoiceLine.Quantity) AS TotalListens "+
                "FROM Artist "+
                "JOIN Album ON Artist.ArtistId = Album.ArtistId "+
                "JOIN Track ON Album.AlbumId = Track.AlbumId "+
                "JOIN InvoiceLine ON Track.TrackId = InvoiceLine.TrackId "+
                "GROUP BY Artist.ArtistId "+
                "ORDER BY TotalListens DESC";

        ArrayList<ArrayList<String>> result=getListData(sql);
        for (ArrayList<String> row:result){
            String artistName=row.get(0);
            String totalListens=row.get(1);
            System.out.println("--"+artistName+"--"+totalListens);
        }
    }
}
