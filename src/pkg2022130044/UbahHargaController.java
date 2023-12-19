
package pkg2022130044;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UbahHargaController implements Initializable {
    Model_harga dtharga = new Model_harga();
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button btnkonfirmasi;
    @FXML
    private Button btnreset;
    @FXML
    private Button btnkembali;
    @FXML
    private TextField txtmiegoyang;
    @FXML
    private TextField txtmiedisko;
    @FXML
    private TextField txtmiemanja;
    @FXML
    private TextField txtteriyaki;
    @FXML
    private TextField txtblackpaper;
    @FXML
    private TextField txtsambalmatah;
    @FXML
    private TextField txtsweet;
    @FXML
    private TextField txtspicy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void konfirmasiklik(ActionEvent event) {
            FXMLDocumentController.dtharga.setMieGoyang(Integer.parseInt(txtmiegoyang.getText()));
            FXMLDocumentController.dtharga.setMieDisko(Integer.parseInt(txtmiedisko.getText()));
            FXMLDocumentController.dtharga.setMieManja(Integer.parseInt(txtmiemanja.getText()));
            FXMLDocumentController.dtharga.setTeriyaki(Integer.parseInt(txtteriyaki.getText()));
            FXMLDocumentController.dtharga.setBlackPaper(Integer.parseInt(txtblackpaper.getText()));
            FXMLDocumentController.dtharga.setSambalMatah(Integer.parseInt(txtsambalmatah.getText()));
            FXMLDocumentController.dtharga.setSpicy(Integer.parseInt(txtspicy.getText()));
            FXMLDocumentController.dtharga.setSweet(Integer.parseInt(txtsweet.getText()));
            btnkonfirmasi.getScene().getWindow().hide();

            
    }

    @FXML
    private void resetklik(ActionEvent event) {
       txtmiegoyang.setText("11000");
       txtmiedisko.setText("10000");
       txtmiemanja.setText("9000");
       txtteriyaki.setText("13000");
       txtblackpaper.setText("13000");
       txtsambalmatah.setText("13000");
       txtspicy.setText("13000");
       txtsweet.setText("13000");
    }

    @FXML
    private void kembaliklik(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
    
}
