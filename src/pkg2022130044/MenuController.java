/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg2022130044;

import java.awt.Color;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static pkg2022130044.FXMLDocumentController.dtharga;

/**
 * FXML Controller class
 *
 * @author Ramdani
 */
public class MenuController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @FXML
    private Button btnpengaturan;
    @FXML
    private Button btnmulai;
    @FXML
    private Button btngambar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       dtharga.setMieGoyang(11000);
       dtharga.setMieDisko(10000);
       dtharga.setMieManja(9000);
       dtharga.setTeriyaki(13000);
       dtharga.setBlackPaper(13000);
       dtharga.setSambalMatah(13000);
       dtharga.setSweet(13000);
       dtharga.setSpicy(13000);
        
    }    

    @FXML
    private void pengaturanklik(ActionEvent event) throws IOException {
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_ubahharga.fxml"));    
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.show();        
        } catch (IOException e){   e.printStackTrace();   }
    }

    @FXML
    private void mulaiklik(ActionEvent event) throws IOException {
      
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void gambarklik(ActionEvent event) throws IOException {
    
        root = FXMLLoader.load(getClass().getResource("GambarStruk.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
    
}

