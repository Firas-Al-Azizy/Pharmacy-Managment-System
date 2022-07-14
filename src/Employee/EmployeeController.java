package Employee;




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
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.String;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    @FXML
    private TextField empID;
   @FXML
   private TextField empFName;
    @FXML
    private TextField empLName;

    @FXML
    private TextField empPassword;
    @FXML
    private DatePicker empDOB;

    @FXML
    private TextField empSalary;

    @FXML
    private TextField empPhoneNo;
    @FXML
    private ComboBox<String> empType;

    @FXML
    private ComboBox<String> empSexType;





    @FXML
    private TableView<Employee> employeetable;

    @FXML
    private TableColumn<Employee, String> empIDcolumn;

    @FXML
    private TableColumn<Employee,String>empFNamecolumn;


    @FXML
    private TableColumn<Employee,String>empLNamecolumn;


    @FXML
    private TableColumn<Employee,String>empPasswordcolumn;


    @FXML
    private TableColumn<Employee,String>empDOBcolumn;

    @FXML
    private TableColumn<Employee, String> EmpSalaryculomn;


    @FXML
    private TableColumn<Employee, String> EmpPhoneNocolumn;


    @FXML
    private TableColumn<Employee, String> EmpSexcolumn;


    @FXML
    private TableColumn<Employee, String> EmpPositioncolumn;



    @FXML
    Label doneM;

    //this method is to let me be connected to my db when i open this form
    private dbConnection dc;
    private ObservableList<Employee> data;



    private String sql="select * from employee ";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dc=new dbConnection();

        ObservableList<String> SexType= FXCollections.observableArrayList("Male","Female");
        empSexType.setItems(SexType);


        ObservableList<String> EmployeeType= FXCollections.observableArrayList("Admin","Manager","User");
        empType.setItems(EmployeeType);




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
    private void addEmployee(ActionEvent event)
    {
        String SqlInsert="INSERT INTO employee (emp_fname, emp_lname,emp_pass,emp_dob,emp_salary,emp_phone,emp_sex,emp_position) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlInsert);

            st.setString(1,this.empFName.getText());
            st.setString(2,this.empLName.getText());
            st.setString(3,this.empPassword.getText());
            st.setString(4,((TextField)empDOB.getEditor()).getText());
            st.setString(5,this.empSalary.getText());
            st.setString(6,this.empPhoneNo.getText());
            st.setString(7,this.empSexType.getSelectionModel().getSelectedItem());
            st.setString(8,this.empType.getSelectionModel().getSelectedItem());

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
    private void UpdateEmployee(ActionEvent event)
    {

        String SqlUpdate="update employee set  emp_id=?, emp_fname=?, emp_lname=?,emp_pass=?, emp_dob=?,emp_salary=?, emp_phone=?,emp_sex=?,emp_position=?where emp_id='"+empID.getText()+"' ";
        try {

            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(SqlUpdate);

            st.setString(1,this.empID.getText());
            st.setString(2,this.empFName.getText());
            st.setString(3,this.empLName.getText());
            st.setString(4,this.empPassword.getText());
            st.setString(5,((TextField)empDOB.getEditor()).getText());
            st.setString(6,this.empSalary.getText());
            st.setString(7,this.empPhoneNo.getText());
            st.setString(8,this.empSexType.getSelectionModel().getSelectedItem());
            st.setString(9,this.empType.getSelectionModel().getSelectedItem());


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
    private void DeleteEmployee(ActionEvent event) {


        try {
            String sqlDelete = "delete from employee where emp_id=?";
            Connection conn=dbConnection.getConnection();
            PreparedStatement st=conn.prepareStatement(sqlDelete);
            st.setString(1,empID.getText());
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


    public void refreshTable()
    {
        data.clear();
        try {
            Connection conn=dbConnection.getConnection();
            this.data= FXCollections.observableArrayList();
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next())
            {
                this.data.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }
        this.empIDcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_id"));
        this.empFNamecolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_fname"));
        this.empLNamecolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_lname"));
        this.empPasswordcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_pass"));
        this.empDOBcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_dob"));
        this.EmpSalaryculomn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_sal"));
        this.EmpPhoneNocolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_phone"));
        this.EmpSexcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_sex"));

        this.EmpPositioncolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_position"));

        this.employeetable.setItems(null);
        this.employeetable.setItems(this.data);

    }







    @FXML
    private void loadEmployeeData(ActionEvent event) throws SQLException
    {
        try {
            Connection conn= dbConnection.getConnection();
            this.data= FXCollections.observableArrayList();

            ResultSet rs=conn.createStatement().executeQuery(sql);
            while (rs.next())
            {

                this.data.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }
        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //now we want to display our data on the table
        this.empIDcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_id"));
        this.empFNamecolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_fname"));
        this.empLNamecolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_lname"));
        this.empPasswordcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_pass"));
        this.empDOBcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_dob"));
        this.EmpSalaryculomn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_sal"));
        this.EmpPhoneNocolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_phone"));
        this.EmpSexcolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_sex"));
        this.EmpPositioncolumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_position"));
        this.employeetable.setItems(null);
        this.employeetable.setItems(this.data);
    }


    @FXML
    private void loaddatatofields(MouseEvent event) throws SQLException {
        try {
            Connection conn = dbConnection.getConnection();
            Employee data = (Employee) employeetable.getSelectionModel().getSelectedItem();
            String sql2 = "select * from employee where emp_id=?";
            PreparedStatement st = conn.prepareStatement(sql2);
            st.setString(1, data.getEmp_id());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                empID.setText(rs.getString("emp_id"));
                empFName.setText(rs.getString("emp_fname"));
                empLName.setText(rs.getString("emp_lname"));
                empPassword.setText(rs.getString("emp_pass"));
                ((TextField) empDOB.getEditor()).setText(rs.getString("emp_dob"));


                empSalary.setText(rs.getString("emp_salary"));

                empPhoneNo.setText(rs.getString("emp_phone"));
                empSexType.setValue(rs.getString("emp_sex"));
                empType.setValue(rs.getString("emp_position"));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }



 @FXML
    private void clearFields(ActionEvent event)
    {
        this.empID.setText("");
        this.empFName.setText("");
        this.empLName.setText("");

        this.empPassword.setText("");

        this.empDOB.getEditor().setText("");
        this.empSalary.setText("");

        this.empPhoneNo.setText("");
        this.empSexType.setValue(null);
        this.empType.setValue(null);
        this.doneM.setText("");
    }

}
