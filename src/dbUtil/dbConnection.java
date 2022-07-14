package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConnection {

    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static Connection con;

    private static final String SQCONN="jdbc:mysql://localhost:3306/pharmacy2019001?autoReconnect=true&useSSL=false";

    public static Connection getConnection() throws SQLException{
        try {

            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(SQCONN,USERNAME,PASSWORD);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}


