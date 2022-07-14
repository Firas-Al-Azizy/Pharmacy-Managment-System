package loginapp;

import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel=new LoginModel();
    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginstatus;


    public void initialize(URL url, ResourceBundle rb)
    {
        if (this.loginModel.isDataConnected())
        {
            this.dbstatus.setText("Connected to Database");
        }
        else
        {
            this.dbstatus.setText("Not Connected to Database");
        }

        this.combobox.setItems(FXCollections.observableArrayList(option.values()));

    }

    @FXML
    public void Login(ActionEvent event)
    {

        try {
            if(this.loginModel.isLogin(this.username.getText(),this.password.getText(),((option)this.combobox.getValue()).toString())){
                Stage stage =(Stage)this.loginButton.getScene().getWindow();
                stage.close();
                switch (((option) this.combobox.getValue()).toString())
                {
                    case "Admin":
                        //adminLogin();

                        Parent LoginForm=FXMLLoader.load(getClass().getResource("/Admin/AdminAdminstration.fxml"));

                        Scene loginScene=new Scene(LoginForm);

                        //this line gets the Stage info
                        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

                        window.setScene(loginScene);
                        window.show();

                        break;
                    case "User":
                        userLogin();
                        break;
                    case "Manager":
                        managerLogin();
                        break;
                }

            }





            else {
                this.loginstatus.setText("Wrong Credentails");
                 }
            }
        catch (Exception localException)
        {
         //localException.printStackTrace();
        }

    }

    public void userLogin()
    {
        try {
            Stage userStage=new Stage();
            FXMLLoader userloader =new FXMLLoader();
            Pane root = (Pane)userloader.load(getClass().getResource("/User/UserDashboard.fxml").openStream());

            //UserController userController =(UserController) userloader.getController();

            Scene scene=new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("User Dashboard");
            userStage.setResizable(false);
            userStage.show();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    public void adminLogin()
    {
        try {
            Stage adminStage=new Stage();
            FXMLLoader Adminloader =new FXMLLoader();
            Pane Adminroot=(Pane)Adminloader.load(getClass().getResource("/Admin/Customer.fxml").openStream());
            AdminController adminController=(AdminController)Adminloader.getController();
            Scene scene=new Scene(Adminroot);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");
            adminStage.setResizable(false);
            adminStage.show();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }



    public void managerLogin()
    {
        try {
            Stage managerStage=new Stage();
            FXMLLoader managerloader =new FXMLLoader();
            Pane root = (Pane)managerloader.load(getClass().getResource("/Manager/ManagerDashboard.fxml").openStream());

            //ManagerController managerController =(ManagerController) managerloader.getController();

            Scene scene=new Scene(root);
            managerStage.setScene(scene);
            managerStage.setTitle("Manager Dashboard");
            managerStage.setResizable(false);
            managerStage.show();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
}
