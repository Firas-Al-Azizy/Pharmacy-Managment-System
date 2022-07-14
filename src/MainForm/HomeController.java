package MainForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {




    @FXML
    public void switchbetweenscenes(ActionEvent event)throws IOException
    {



        Parent LoginForm=FXMLLoader.load(getClass().getResource("/loginapp/login.fxml"));

        Scene loginScene=new Scene(LoginForm);

        //this line gets the Stage info
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginScene);
        window.show();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
