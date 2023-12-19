/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg2022130044;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ramdani
 */
public class SplashController implements Initializable {

    private BorderPane borderPane;
    private AnchorPane pane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private AnchorPane apane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new splashScreen().start();
    }   
    
    class splashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(3000);
                
                Platform.runLater(new Runnable () {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                
                apane.getScene().getWindow().hide();
                    }
                });
                
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
