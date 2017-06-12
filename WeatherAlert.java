package weatheralert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author Jason
 */



public class WeatherAlert extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:"+File.separator+"Users"+File.separator+"Jason"+File.separator+"workspace"+File.separator+"weatherAlert"+File.separator+"src"+File.separator+"weatheralert"+File.separator+"gui.fxml";
        FileInputStream fxmlStream = null;
		try {
			fxmlStream = new FileInputStream(fxmlDocPath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        // Create the Pane and all Details
        GridPane root = null;
		try {
			root = (GridPane) loader.load(fxmlStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Alert.getJSON("https://api.weather.gov/alerts/NWS-IDP-PROD-2402446-2257179");

		Alert.GetJsonNode("https://api.weather.gov/alerts/active/");
        Scene scene = new Scene(root);


        primaryStage.setTitle("Weather Alert");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
