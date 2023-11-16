# Chinook Database Test

This Java project contains TestNG tests for interacting with the Chinook Database. The project utilizes Maven for dependency management and build automation.

## Project Structure

- **ChinookTest.java:** TestNG test methods for various database queries.
- **DBUtility.java:** Utility class for handling database connections and queries.

## Technologies Used

- Java
- TestNG
- SQLite

## Prerequisites

Before running the tests, ensure you have the following:

1. **Java Development Kit (JDK):** Installed on your machine.
2. **Maven:** Installed on your machine.
3. **IDE:** Use your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

## Running the Tests
Open the project in your preferred IDE.
Ensure the `Chinook_Sqlite.sqlite` file is in the project directory.
Run the `ChinookTest` class with TestNG.

## Database Connection

The database connection is established using the `DBUtility` class. The SQLite database file is named `Chinook_Sqlite.sqlite`. Make sure this file is present in the project directory.

## Maven Dependencies

The project dependencies are managed using Maven. Here are the key dependencies:

```xml
<dependencies>
    <!-- TestNG for test execution -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.1.0</version>
        <scope>test</scope>
    </dependency>

    <!-- SQLite JDBC driver -->
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.34.0</version> <!-- Check for the latest version -->
    </dependency>
</dependencies>
```

Table of Contents
## Description
Tests
1. getSpecificArtistAllAlbumSongs()
2. mergeAllArtistAlbumSong()
3. mergeTracksAndMediaTypes()
4. mergeTracksAndGenre()
5. getAllCustomersInfo()
6. customersByCountry()
7. customersByCity()
8. getCustomersEmail()
9. customerInvoice()
10. totalPurchasedByCustomer()
11. mergeTrackAndPlayList()
12. mostListensArtist()

## Tests
1. getSpecificArtistAllAlbumSongs()
This test retrieves all songs from albums of a specific artist (e.g., AC/DC).

2. mergeAllArtistAlbumSong()
This test merges information about artists, albums, and songs from the Chinook Database.

3. mergeTracksAndMediaTypes()
This test merges track names with their corresponding media types.

4. mergeTracksAndGenre()
This test merges track names with their associated genres.

5. getAllCustomersInfo()
This test retrieves information about all customers in the Chinook Database.

6. customersByCountry()
This test provides a count of customers grouped by country.

7. customersByCity()
This test provides a count of customers grouped by city.

8. getCustomersEmail()
This test retrieves the email addresses of all customers.

9. customerInvoice()
This test merges invoice information with customer details.

10. totalPurchasedByCustomer()
This test calculates the total sales and sale count for each customer.

11. mergeTrackAndPlayList()
This test merges track information with playlist details.

12. mostListensArtist()
This test identifies the artist with the highest total listens based on invoice line quantities.

Feel free to update the descriptions and add more details as needed.
