package loginapp;

import dbUtil.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    Connection connection;

    public LoginModel(){

        try {
            this.connection= dbConnection.getConnection();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        if (this.connection==null)
        {
            System.exit(1);
        }
    }


    public boolean isDataConnected()
    {
        return this.connection !=null;
    }

    public boolean isLogin(String user, String pass, String opt) throws Exception
    {
        PreparedStatement pr=null;
        ResultSet rs=null;
        String sql ="SELECT emp_fname,emp_pass,emp_position FROM employee where emp_fname = ? and emp_pass = ? and emp_position = ?";

        try {
            pr =this.connection.prepareStatement(sql);
            pr.setString(1,user);
            pr.setString(2,pass);
            pr.setString(3,opt);

            rs=pr.executeQuery();

            boolean bool1;
            if (rs.next()){
                return true;
            }
            else
            return false;
        }
        catch (SQLException ex)
        {
            return false;
        }

        finally {
            {
                try {
                    pr.close();
                    rs.close();
                }catch (Exception ex)
                {

                }

            }
        }
    }
}
