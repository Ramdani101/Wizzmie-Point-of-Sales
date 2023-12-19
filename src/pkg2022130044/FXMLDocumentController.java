/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pkg2022130044;

import java.io.IOException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

//INFO DAN ASUMSI MENGENAI PROSES BISNIS PADA RESTAURAN WIZZMIE
/*
A.  Pembelian
    -Pembelian dibatasi sampai pada 3 varian makanan mie beserta level pedas, dan 5 varian rice bowl
    -Rice bowl tidak bisa memodifikasi tingkat kepedasan, jika dipaksakan diberikan level pedas maka tidak akan masuk perhitungan pedas makanan nya
    -Tiap pembelian terhadap 1 jenis makanan atau minuman dibatasi hanya 10
B.  Potongan
    -jika membayar memakai gopay mendapat potongan harga sebesar 20%
    -jika membayar memakai shoopepay mendapat potongan harga sebesar 10%
    -jika dia merupakan member mendapat tambahan potongan harga sebanyak 2%
    -jika membayar memakai uang cash tidak mendapat potongan
    -tidak bisa membayar dengan shoopepay dan gopay dalam 1 pembayaran

C. Pajak
    -Total harga akan dikenakan pajak sebesar 10%

D. Info lainnya di struk
    -Untuk no struk, tanggal dan cashier akan dikalkulasikan otomatis oleh program tidak harus diinputkan lagi
    -Jika pada form input utama checkbox "dibawa pulang" di centak dan textfield no meja juga diisi, maka di struk akan dianggap dibawa pulang
*/
public class FXMLDocumentController implements Initializable {
    public static Model_harga dtharga = new Model_harga();
    Model dt = new Model();
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label label;
    @FXML
    private TextField txtpemesan;
    @FXML
    private ComboBox<String> cmbmakanan1;
    @FXML
    private ComboBox<String> cmbpedas1;
    @FXML
    private ComboBox<String> cmbjumlah1;
    private TextField txtbayar;
    @FXML
    private Button btnhitung;
    @FXML
    private Button btnhapus;
    @FXML
    private ToggleGroup potonganharga;
    @FXML
    private RadioButton rdbgopay;
    @FXML
    private RadioButton rdbshoopepay;
    @FXML
    private CheckBox chkmember;
    @FXML
    private TextField txtnomeja;
    @FXML
    private CheckBox chkpulang;
    @FXML
    private RadioButton rdbtunai;
    @FXML
    private Button btnkembali;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cmbmakanan1.setItems(FXCollections.observableArrayList("Mie Goyang", "Mie Disko", "Mie Manja", "Rice Bowl Teriyaki", "Rice Bowl BlackPaper", "Rice Bowl Sambal Matah", "Rice Bowl Sweet & Sour", "Rice Bowl Spicy"));
       cmbpedas1.setItems(FXCollections.observableArrayList("0","1", "2", "3", "4", "5"));
       cmbjumlah1.setItems(FXCollections.observableArrayList("1", "2", "3","4", "5", "6", "7", "8", "9", "10"));
       
       cmbpedas1.getSelectionModel().selectFirst();
       
    
    }    

    @FXML
    private void hitungklik(ActionEvent event) {
        
        
        if (txtpemesan.getText().isEmpty() || txtnomeja.getText().isEmpty() && !(chkpulang.isSelected()) || cmbmakanan1.getSelectionModel().isEmpty() || cmbjumlah1.getSelectionModel().isEmpty()) {
            if (txtnomeja.getText().isEmpty()) {
            Alert a1 = new Alert(Alert.AlertType.WARNING);
            a1.setTitle("Warning");
            a1.setHeaderText("No Meja Diisi Dengan Angka!!! ");
            a1.showAndWait();
            }
        
            if (txtpemesan.getText().isEmpty()) {
            Alert a1 = new Alert(Alert.AlertType.WARNING);
            a1.setTitle("Warning");
            a1.setHeaderText("Nama Pemesan Harus Diisi!!! ");
            a1.showAndWait();
            }
            
            if (cmbmakanan1.getSelectionModel().isEmpty()) {
                ChoiceDialog<String> pilih=new ChoiceDialog<String>
                (cmbmakanan1.getItems().get(0),  cmbmakanan1.getItems());
                pilih.setContentText("Pilih Makanan:");            
                pilih.showAndWait();
                cmbmakanan1.getSelectionModel().select(pilih.getResult());
            }
            
            if (cmbjumlah1.getSelectionModel().isEmpty()) {
                ChoiceDialog<String> pilih=new ChoiceDialog<String>
                (cmbjumlah1.getItems().get(0),  cmbjumlah1.getItems());
                pilih.setContentText("Pilih Jumlah:");            
                pilih.showAndWait();
                cmbjumlah1.getSelectionModel().select(pilih.getResult());
            }
            
        }else{
        
        dt.setPilihmakanan1(cmbmakanan1.getSelectionModel().selectedIndexProperty().intValue());
        dt.setPilihpedas1(cmbpedas1.getSelectionModel().selectedIndexProperty().intValue());
        dt.setPilihjumlah1(cmbjumlah1.getSelectionModel().selectedIndexProperty().intValue());
        dt.setMember(chkmember.isSelected());
        dt.setPembeli(txtpemesan.getText());
        dt.setNoMeja(txtnomeja.getText());
        dt.setPulang(chkpulang.isSelected());
        dt.setGopay(rdbgopay.isSelected());
        dt.setShoopepay(rdbshoopepay.isSelected());
        dt.setTunai(rdbtunai.isSelected());    
            
            
        try{  FXMLLoader loader=new    
          FXMLLoader(getClass().getResource("StrukPembayaran.fxml"));    
          Parent root = (Parent)loader.load();
          StrukPembayaranController isidt=     
          (StrukPembayaranController)loader.getController();
          isidt.hitung(dt);
          Scene scene = new Scene(root);
          Stage stg=new Stage();  
          stg.setScene(scene);
          stg.show();
          }catch (IOException e){   e.printStackTrace();}
        
        }

}

    @FXML
    private void hapusklik(ActionEvent event) {
        rdbgopay.setSelected(false);
        rdbshoopepay.setSelected(false);
        chkmember.setSelected(false);
        chkpulang.setSelected(false);
        cmbmakanan1.setValue("");
        cmbpedas1.getSelectionModel().selectFirst();
        cmbjumlah1.setValue("");
        txtpemesan.setText("");
        txtbayar.setText("");
        txtnomeja.setText("");
        txtpemesan.requestFocus();
        txtnomeja.setText("");
        rdbtunai.setSelected(false);
        
    }


    @FXML
    private void kembaliklik(ActionEvent event) throws IOException {
    
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    
    }

}
    



    

    
    
    
    
    
    
    
    
    
