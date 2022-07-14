package Drugs;

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class DrugController implements Initializable {



    @FXML
    private TextField DoseID;
    @FXML
    private TextField DoseQuantity;

    @FXML
    private TableView<DoseData> dosetable;

    @FXML
    private TableColumn<DoseData, Integer> DoseIDcolumn;

    @FXML
    private TableColumn<DoseData,String>DoseQuantitycolumn;


    @FXML
    private TextField For_id;
    @FXML
    private TextField For_name;
    @FXML
    private TableView<FormData> formtable;

    @FXML
    private TableColumn<FormData, Integer> FormIDcolumn;

    @FXML
    private TableColumn<FormData,String>FormNamecolumn;

    @FXML
    private TextField SecID;
    @FXML
    private TextField SecName;
    @FXML
    private TableView<SectionData> sectiontable;

    @FXML
    private TableColumn<SectionData, Integer> SecIDcolumn;

    @FXML
    private TableColumn<SectionData,String>SecNamecolumn;

    @FXML
 private ComboBox seccombobox;
    @FXML
    Label doneS;

    @FXML
    Label doneD;
    @FXML
    Label doneF;

    //this method is to let me be connected to my db when i open this form
    private dbConnection dc;
    private ObservableList<DrugData> Drugdata;
    private ObservableList<DoseData> Dosedata;
    private ObservableList<FormData> Formdata;
    private ObservableList<SectionData> Sectiondata;
    private ObservableList<SectionData> Sectiondata2;
    final ObservableList options=FXCollections.observableArrayList();




    private String sqlDrug="select * from products ";
    private String sqlDose="select * from dose ";
    private String sqlForm="select * from form ";
    private String sqlSection="select * from section ";







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
    private void addDose(ActionEvent event)
    {
        String SqlInsert="INSERT INTO dose (dos_qty) VALUES (?);";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlInsert);

            st.setString(1,this.DoseQuantity.getText());
            st.execute();
            doneD.setText("Added Successfully ^-^");
            doneD.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshDoseTable();
    }

    @FXML
    private void addForm(ActionEvent event)
    {
        String SqlFormInsert="INSERT INTO form (for_name) VALUES (?);";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlFormInsert);

            st.setString(1,this.For_name.getText());
            st.execute();
            doneF.setText("Added Successfully ^-^");
            doneF.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshFormTable();
    }
    @FXML
    private void addSection(ActionEvent event)
    {
        String SqlSectionInsert="INSERT INTO section (sec_name) VALUES (?);";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlSectionInsert);

            st.setString(1,this.SecName.getText());
            st.execute();
            doneS.setText("Added Successfully ^-^");
            doneS.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshSectionTable();
    }


    @FXML
    private void UpdateDose(ActionEvent event)
    {

        String SqlUpdate="update dose set dos_qty=? where dos_id=?";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlUpdate);
            st.setString(1,this.DoseQuantity.getText());
            st.setInt(2, Integer.parseInt(this.DoseID.getText()));
            //st.execute();
            st.executeUpdate();
            doneD.setText("Updated Successfully ^-^");
            doneD.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshDoseTable();
    }


    @FXML
    private void UpdateForm(ActionEvent event)
    {

        String SqlFormUpdate="update form set for_name=? where for_id=?";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlFormUpdate);
            st.setString(1,this.For_name.getText());
            st.setInt(2, Integer.parseInt(this.For_id.getText()));
            //st.execute();
            st.executeUpdate();
            doneF.setText("Updated Successfully ^-^");
            doneF.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshFormTable();
    }


    @FXML
    private void UpdateSection(ActionEvent event)
    {

        String SqlUpdate="update section set sec_name=? where sec_id=?";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlUpdate);
            st.setString(1,this.SecName.getText());
            st.setInt(2, Integer.parseInt(this.SecID.getText()));
            //st.execute();
            st.executeUpdate();
            doneS.setText("Updated Successfully ^-^");
            doneS.setVisible(true);
            st.close();

        }catch (SQLException ex)

        {
            ex.printStackTrace();
        }
        refreshSectionTable();
    }


    @FXML
    private void DeleteDose(ActionEvent event) {
        try {
            String sqlDelete = "delete from dose where dos_id=?";
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(sqlDelete);
            st.setString(1,DoseID.getText());
            st.executeUpdate();
            doneD.setText("Deleted Successfully ^-^");
            doneD.setVisible(true);
            st.close();
            }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        refreshDoseTable();
    }


    @FXML
    private void DeleteForm(ActionEvent event) {
        try {
            String sqlFormDelete = "delete from form where for_id=?";
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(sqlFormDelete);
            st.setString(1,For_id.getText());
            st.executeUpdate();
            doneF.setText("Deleted Successfully ^-^");
            doneF.setVisible(true);
            st.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        refreshFormTable();
    }

    @FXML
    private void DeleteSection(ActionEvent event) {
        try {
            String sqlSectionDelete = "delete from section where sec_id=?";
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(sqlSectionDelete);
            st.setString(1,SecID.getText());
            st.executeUpdate();
            doneS.setText("Deleted Successfully ^-^");
            doneS.setVisible(true);
            st.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        refreshSectionTable();
    }










    @FXML
    private void loadDoseData(ActionEvent event) throws SQLException
    {
        try {
            Connection conn= dbConnection.getConnection();
            this.Dosedata= FXCollections.observableArrayList();

            ResultSet rs=conn.createStatement().executeQuery(sqlDose);
            while (rs.next())
            {
                this.Dosedata.add(new DoseData(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //now we want to display our data on the table

        this.DoseIDcolumn.setCellValueFactory(new PropertyValueFactory<DoseData,Integer>("dos_id"));
        this.DoseQuantitycolumn.setCellValueFactory(new PropertyValueFactory<DoseData,String>("dos_quantity"));

        this.dosetable.setItems(null);
        this.dosetable.setItems(this.Dosedata);

    }


    @FXML
    private void loadFormData(ActionEvent event) throws SQLException
    {
        try {
            Connection conn= dbConnection.getConnection();
            this.Formdata= FXCollections.observableArrayList();

            ResultSet rs=conn.createStatement().executeQuery(sqlForm);
            while (rs.next())
            {
                this.Formdata.add(new FormData(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //now we want to display our data on the table

        this.FormIDcolumn.setCellValueFactory(new PropertyValueFactory<FormData,Integer>("for_id"));
        this.FormNamecolumn.setCellValueFactory(new PropertyValueFactory<FormData,String>("for_name"));

        this.formtable.setItems(null);
        this.formtable.setItems(this.Formdata);

    }


    @FXML
    public void FillCombobox() throws SQLException {
        try {
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement("select sec_name from section");
            ResultSet rs=st.executeQuery();

            while (rs.next())
            {
                String name=rs.getString("sec_name");
                seccombobox.getItems().add(name);

                //seccombobox.getItems().addAll(rs.getString("sec_name"));

            }
            st.close();
            rs.close();
        }catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

    }




    @FXML
    private void loadSectionData(ActionEvent event) throws SQLException
    {
        try {
            Connection conn= dbConnection.getConnection();
            this.Sectiondata= FXCollections.observableArrayList();

            ResultSet rs=conn.createStatement().executeQuery(sqlSection);
            while (rs.next())
            {
                this.Sectiondata.add(new SectionData(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //now we want to display our data on the table

        this.SecIDcolumn.setCellValueFactory(new PropertyValueFactory<SectionData,Integer>("sec_id"));
        this.SecNamecolumn.setCellValueFactory(new PropertyValueFactory<SectionData,String>("sec_name"));

        this.sectiontable.setItems(null);
        this.sectiontable.setItems(this.Sectiondata);

    }


    public void refreshDoseTable()
    {
        Dosedata.clear();
        try {
            Connection conn=dbConnection.getConnection();
            this.Dosedata= FXCollections.observableArrayList();
            ResultSet rs=conn.createStatement().executeQuery(sqlDose);
            while (rs.next())
            {
                this.Dosedata.add(new DoseData(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        this.DoseIDcolumn.setCellValueFactory(new PropertyValueFactory<DoseData,Integer>("dos_id"));
        this.DoseQuantitycolumn.setCellValueFactory(new PropertyValueFactory<DoseData,String>("dos_quantity"));

        this.dosetable.setItems(null);
        this.dosetable.setItems(this.Dosedata);
    }

    public void refreshFormTable()
    {
        Formdata.clear();
        try {
            Connection conn=dbConnection.getConnection();
            this.Formdata= FXCollections.observableArrayList();
            ResultSet rs=conn.createStatement().executeQuery(sqlForm);
            while (rs.next())
            {
                this.Formdata.add(new FormData(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        this.FormIDcolumn.setCellValueFactory(new PropertyValueFactory<FormData,Integer>("for_id"));
        this.FormNamecolumn.setCellValueFactory(new PropertyValueFactory<FormData,String>("for_name"));



        this.formtable.setItems(null);
        this.formtable.setItems(this.Formdata);
    }


    public void refreshSectionTable()
    {
        Sectiondata.clear();
        try {
            Connection conn=dbConnection.getConnection();
            this.Sectiondata= FXCollections.observableArrayList();
            ResultSet rs=conn.createStatement().executeQuery(sqlSection);
            while (rs.next())
            {
                this.Sectiondata.add(new SectionData(rs.getInt(1),rs.getString(2)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        this.SecIDcolumn.setCellValueFactory(new PropertyValueFactory<SectionData,Integer>("sec_id"));
        this.SecNamecolumn.setCellValueFactory(new PropertyValueFactory<SectionData,String>("sec_name"));

        this.sectiontable.setItems(null);
        this.sectiontable.setItems(this.Sectiondata);
    }


    @FXML
    private void loadDosedatatofields(MouseEvent event) throws SQLException
    {
        try {
            Connection conn=dbConnection.getConnection();
            DoseData data=(DoseData) dosetable.getSelectionModel().getSelectedItem();
            String sql2="select * from dose where dos_id=?";
            PreparedStatement st=conn.prepareStatement(sql2);
            st.setInt(1,data.getDos_id());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                DoseID.setText(rs.getString("dos_id"));
                DoseQuantity.setText(rs.getString("dos_qty"));

            }
            st.close();
            rs.close();
        }catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }


    @FXML
    private void loadFormdatatofields(MouseEvent event) throws SQLException
    {
        try {
            Connection conn=dbConnection.getConnection();
            FormData data=(FormData) formtable.getSelectionModel().getSelectedItem();
            String sql2="select * from form where for_id=?";
            PreparedStatement st=conn.prepareStatement(sql2);
            st.setInt(1,data.getFor_id());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                For_id.setText(rs.getString("for_id"));
                For_name.setText(rs.getString("for_name"));

            }
            st.close();
            rs.close();
        }catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }


    @FXML
    private void loadSectiondatatofields(MouseEvent event) throws SQLException
    {
        try {
            Connection conn=dbConnection.getConnection();
            SectionData data=(SectionData) sectiontable.getSelectionModel().getSelectedItem();
            String sql2="select * from section where sec_id=?";
            PreparedStatement st=conn.prepareStatement(sql2);
            st.setInt(1,data.getSec_id());
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                SecID.setText(rs.getString("sec_id"));
                SecName.setText(rs.getString("sec_name"));

            }
            st.close();
            rs.close();
        }catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }



    //now we want to clear the form after one insert date
    @FXML
    private void clearDoseFields(ActionEvent event)
    {
        this.DoseID.setText("");
        this.DoseQuantity.setText("");
        this.doneD.setText("");

    }
    @FXML
    private void clearFormFields(ActionEvent event)
    {
        this.For_id.setText("");
        this.For_name.setText("");
        this.doneF.setText("");

    }


    @FXML
    private void clearSectionFields(ActionEvent event)
    {
        this.SecID.setText("");
        this.SecName.setText("");
        this.doneS.setText("");

    }

}
