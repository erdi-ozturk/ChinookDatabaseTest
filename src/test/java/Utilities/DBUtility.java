package Utilities;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

    public static Connection connection;
    public static Statement statement;

    public static void DBConnectionOpen(){
        String jdbcUrl = "jdbc:sqlite:Chinook_Sqlite.sqlite";
        try {
            Class.forName("org.sqlite.JDBC");
            connection=DriverManager.getConnection(jdbcUrl);
            statement=connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<ArrayList<String>> getListData(String sql){
        DBConnectionOpen();
        ArrayList<ArrayList<String>> table=new ArrayList<>();
        try {
            ResultSet rs=statement.executeQuery(sql);
            ResultSetMetaData metaData=rs.getMetaData();
            while (rs.next()){
                ArrayList<String> row=new ArrayList<>();
                for (int i = 1; i <=metaData.getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                table.add(row);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            DBConnectionClose();
        }

        return table;
    }

    private static void DBConnectionClose() {
        try {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
