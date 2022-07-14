package Suppliers;

import Admin.Customer;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {



    @FXML
    private TextField SupID;
    @FXML
    private TextField SupName;
    @FXML
    private TextField SupAddress;

    @FXML
    private TextField SupPhoneNo;


    @FXML
    private TableView<SupplierData> suppliertable;

    @FXML
    private TableColumn<SupplierData, Integer> SupIDcolumn;

    @FXML
    private TableColumn<SupplierData,String>SupNamecolumn;

    @FXML
    private TableColumn<SupplierData, String> SupAddresscolumn;


    @FXML
    private TableColumn<SupplierData, Integer> SupPhoneNocolumn;

    @FXML
    Label doneM;

    //this method is to let me be connected to my db when i open this form
    private dbConnection dc;
    private ObservableList<SupplierData> data;

    private String sql="select * from supplier ";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dc=new dbConnection();
    }


    @FXML
    public void BackToAdministrationForm(ActionEvent event)throws IOException
    {
        Parent LoginForm= FXMLLoader.load(getClass().getResource("/Admin/AdminAdminstration.fxml"));
        Scene loginScene=new Scene(LoginForm);
        //this line gets the Stage info
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }


    @FXML
    private void loadSupplierData(ActionEvent event) throws SQLException
    {
        try {
            Connection conn= dbConnection.getConnection();
            this.data= FXCollections.observableArrayList();

            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next())
            {
                this.data.add(new SupplierData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //now we want to display our data on the table

        this.SupIDcolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,Integer>("sup_id"));
        this.SupNamecolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,String>("sup_name"));
        this.SupAddresscolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,String>("sup_address"));
        this.SupPhoneNocolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,Integer>("sup_phone"));

        this.suppliertable.setItems(null);
        this.suppliertable.setItems(this.data);

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
                this.data.add(new SupplierData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        this.SupIDcolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,Integer>("sup_id"));
        this.SupNamecolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,String>("sup_name"));
        this.SupAddresscolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,String>("sup_address"));
        this.SupPhoneNocolumn.setCellValueFactory(new PropertyValueFactory<SupplierData,Integer>("sup_phone"));



        this.suppliertable.setItems(null);
        this.suppliertable.setItems(this.data);
    }




    @FXML
    private void addSupplier(ActionEvent event)
    {
        String SqlInsert="INSERT INTO supplier (sup_name,sup_address,sup_phone) VALUES (?, ?, ?);";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlInsert);

            st.setString(1,this.SupName.getText());
            st.setString(2,this.SupAddress.getText());
            st.setInt(3,Integer.parseInt(this.SupPhoneNo.getText()));
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
    private void UpdateSupplier(ActionEvent event)
    {

        String SqlUpdate="update supplier set sup_name=?, sup_address=?,sup_phone=? where sup_id=?";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlUpdate);

            st.setString(1,this.SupName.getText());
            st.setString(2,this.SupAddress.getText());
            st.setInt(3,Integer.parseInt(this.SupPhoneNo.getText()));
            st.setInt(4, Integer.parseInt(this.SupID.getText()));

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
    private void DeleteSupplier(ActionEvent event) {


        try {
            String sqlDelete = "delete from supplier where sup_id=?";
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(sqlDelete);
            st.setString(1,SupID.getText());
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
            SupplierData data=(SupplierData) suppliertable.getSelectionModel().getSelectedItem();
            String sql2="select * from supplier where sup_id=?";
            PreparedStatement st=conn.prepareStatement(sql2);
            st.setInt(1,data.getSup_id());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                SupID.setText(rs.getString("sup_id"));
                SupName.setText(rs.getString("sup_name"));
                SupAddress.setText(rs.getString("sup_address"));
                SupPhoneNo.setText(rs.getString("sup_phone"));
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
        this.SupID.setText("");
        this.SupName.setText("");
        this.SupAddress.setText("");
        this.SupPhoneNo.setText("");
    }

}
