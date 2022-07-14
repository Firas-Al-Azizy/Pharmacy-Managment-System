package Manager;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManagerController implements Initializable {


    @FXML
    private TextField CusID;
    @FXML
    private TextField CusName;
    @FXML
    private TextField CusNumber;


    @FXML
    private TableView<Customer>customertable;

    @FXML
    private TableColumn<Customer, Integer> CusIDcolumn;

    @FXML
    private TableColumn<Customer,String>CusNamecolumn;

    @FXML
    private TableColumn<Customer, Float> CusNumbercolumn;

    @FXML
    Label doneM;

    //this method is to let me be connected to my db when i open this form
    private dbConnection dc;
    private ObservableList<Customer>data;



    private String sql="select * from customer ";
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.dc=new dbConnection();
    }

    @FXML
    private void loadCustomerData(ActionEvent event) throws SQLException
    {
        try {
            Connection conn= dbConnection.getConnection();
            this.data= FXCollections.observableArrayList();

            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next())
            {
                //this.data.add(new Drugs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                this.data.add(new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //now we want to display our data on the table

        this.CusIDcolumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("cus_id"));
        this.CusNamecolumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("cus_name"));
        this.CusNumbercolumn.setCellValueFactory(new PropertyValueFactory<Customer,Float>("cus_num"));


        this.customertable.setItems(null);
        this.customertable.setItems(this.data);

    }


    public void refreshTable()
    {
        data.clear();
        try {
            Connection conn=dbConnection.getConnection();
            this.data= FXCollections.observableArrayList();
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next())
            {
                this.data.add(new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        this.CusIDcolumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("cus_id"));
        this.CusNamecolumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("cus_name"));
        this.CusNumbercolumn.setCellValueFactory(new PropertyValueFactory<Customer,Float>("cus_num"));



        this.customertable.setItems(null);
        this.customertable.setItems(this.data);
    }




    @FXML
    private void addCustomer(ActionEvent event)
    {
        String SqlInsert="INSERT INTO customer (cus_name,cus_number) VALUES (?, ?);";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlInsert);

            st.setString(1,this.CusName.getText());
            st.setString(2,this.CusNumber.getText());
            st.execute();
            doneM.setText("Added Successfully ^-^");
            doneM.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshTable();
    }


    @FXML
    private void UpdateCustomer(ActionEvent event)
    {

        String SqlUpdate="update customer set cus_name=?, cus_number=? where cus_id=?";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlUpdate);

            st.setString(1,this.CusName.getText());
            st.setInt(2,Integer.parseInt(this.CusNumber.getText()));
            st.setInt(3, Integer.parseInt(this.CusID.getText()));

            //st.execute();
            st.executeUpdate();
            doneM.setText("Updated Successfully ^-^");
            doneM.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshTable();
    }

    @FXML
    private void DeleteCustomer(ActionEvent event) {


        try {
            String sqlDelete = "delete from customer where cus_id=?";
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(sqlDelete);
            st.setString(1,CusID.getText());
            st.executeUpdate();
            doneM.setText("Deleted Successfully ^-^");
            doneM.setVisible(true);
            st.close();


        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        refreshTable();
    }


    @FXML
    private void loaddatatofields(MouseEvent event) throws SQLException
    {
        try {
            Connection conn=dbConnection.getConnection();
            Customer data=(Customer) customertable.getSelectionModel().getSelectedItem();
            String sql2="select * from customer where cus_id=?";
            PreparedStatement st=conn.prepareStatement(sql2);
            st.setInt(1,data.getCus_id());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                CusID.setText(rs.getString("cus_id"));
                CusName.setText(rs.getString("cus_name"));
                CusNumber.setText(rs.getString("cus_number"));
            }
            st.close();
            rs.close();
        }catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
   }





    //now we want to clear the form after one insert date
    @FXML
    private void clearFields(ActionEvent event)
    {
        this.CusID.setText("");
        this.CusName.setText("");
        this.CusNumber.setText("");
    }

}


