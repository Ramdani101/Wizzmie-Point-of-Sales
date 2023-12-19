/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pkg2022130044;

import java.net.URL;
import static java.util.Optional.empty;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static pkg2022130044.FXMLDocumentController.dtharga;


public class StrukPembayaranController implements Initializable {

    @FXML
    private Label lblnopesanan;
    @FXML
    private Label lblnama;
    @FXML
    private Label lblnomeja;
    @FXML
    private Label lbltotalqty;
    @FXML
    private Label lblsubtotal1;
    @FXML
    private Label lblsubtotal2;
    @FXML
    private Label lblmember;
    @FXML
    private Label lblshoopepay;
    @FXML
    private Label lblgopay;
    @FXML
    private Label lblsubtotal3;
    @FXML
    private Label lblpajak;
    @FXML
    private Label lblpekerja;
    @FXML
    private Label lblqtyp;
    @FXML
    private Label lblnamap;
    @FXML
    private Label lbltotalharga;
    @FXML
    private Button btncetak;
    @FXML
    private Button btnkembali;
    
 
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    
    public void hitung(Model d){

        int pesanan1 = 0, potonganShoopepay = 0, potonganGopay = 0, potonganMemberJumlah = 0, jumlahPesanan = 0;
        String namaPesanan = "", keterangan = "";
        double potongan;
        

        switch(d.getPilihmakanan1()){
            case 0 : pesanan1 =FXMLDocumentController.dtharga.getMieGoyang();    namaPesanan = "Mie Goyang";break;
            case 1 : pesanan1 =FXMLDocumentController.dtharga.getMieDisko();    namaPesanan = "Mie Disko"; break;
            case 2 : pesanan1 =FXMLDocumentController.dtharga.getMieManja();     namaPesanan = "Mie Manja";break;
            case 3 : pesanan1 =FXMLDocumentController.dtharga.getTeriyaki();   namaPesanan = "Rice Bowl Teriyaki";break;
            case 4 : pesanan1 =FXMLDocumentController.dtharga.getTeriyaki();   namaPesanan = "Rice Bowl BlackPaper";break;
            case 5 : pesanan1 =FXMLDocumentController.dtharga.getSambalMatah();   namaPesanan = "Rice Bowl Sambal Matah";break;
            case 6 : pesanan1 =FXMLDocumentController.dtharga.getSweet();   namaPesanan = "Rice Bowl Sweet & Sour";break;
            case 7 : pesanan1 =FXMLDocumentController.dtharga.getSpicy();   namaPesanan = "Rice Bowl Spicy";break;
            default: pesanan1=0;
        }

           
        int pedasmakanan1 = 0;
        
        if (namaPesanan == "Mie Goyang" || namaPesanan == "Mie Disko" || namaPesanan == "Mie Manja") {
            switch(d.getPilihpedas1()){
            case 0 : pedasmakanan1=0;break;
            case 1 : pedasmakanan1=1000;break;
            case 2 : pedasmakanan1=1000;break;
            case 3 : pedasmakanan1=2000;break;
            case 4 : pedasmakanan1=2000;break;
            case 5 : pedasmakanan1=3000;break;
            default: pedasmakanan1=0;
            }
        }else{pedasmakanan1 = 0;}

        int jumlahbeli1;
        
        switch(d.getPilihjumlah1()){
            case 0 : jumlahbeli1 = 1;break;
            case 1 : jumlahbeli1 = 2;break;
            case 2 : jumlahbeli1 = 3;break;
            case 3 : jumlahbeli1 = 4;break;
            case 4 : jumlahbeli1 = 5;break;
            case 5 : jumlahbeli1 = 6;break;
            case 6 : jumlahbeli1 = 7;break;
            case 7 : jumlahbeli1 = 8;break;
            case 8 : jumlahbeli1 = 9;break;
            case 9 : jumlahbeli1 = 10;break;
            default: jumlahbeli1 = 0;
        }

        int totalHarga = ((pesanan1+pedasmakanan1)*jumlahbeli1);
        
        int pajak = (int)(totalHarga * 0.1);
        int subtotal2 = totalHarga + pajak;
        
        
        if(d.isShoopepay()){
           potongan = 0.1;
           potonganShoopepay = (int)(subtotal2 * (potongan));
           potonganGopay = 0;
        }else if(d.isGopay()){
           potongan = 0.2;
           potonganShoopepay = 0;
           potonganGopay = (int)(subtotal2 * (potongan));
        }else if(d.isTunai()){
          potongan = 0;
          potonganShoopepay = 0;
          potonganGopay = 0;
        }else{potongan = 0.0;}
        
        double potonganMember;
        if(d.isMember()){
            potonganMember = 0.02;
        }else{potonganMember = 0.0;}
        
        potonganMemberJumlah = (int)(subtotal2 * potonganMember);
        int subtotal3 = subtotal2 - potonganMemberJumlah - potonganShoopepay - potonganGopay;
        
        if (d.isPulang()) {
            keterangan = "Dibawa Pulang";
        }else if(d.isPulang() && d.getNoMeja() != ""){
            d.setNoMeja("");
        }else{
            keterangan = d.getNoMeja();
        }
        
        jumlahPesanan++;
        String noPesanan = "WZM20221115" + jumlahPesanan;
        
        lblqtyp.setText(String.valueOf(jumlahbeli1));
        lblnamap.setText(namaPesanan);
        lbltotalharga.setText(String.valueOf(totalHarga));
        lblsubtotal1.setText(String.valueOf(totalHarga));
        lblpajak.setText(String.valueOf(pajak));
        lblsubtotal2.setText(String.valueOf(subtotal2));
        lblmember.setText(String.valueOf(potonganMemberJumlah));
        lblshoopepay.setText(String.valueOf(potonganShoopepay));
        lblgopay.setText(String.valueOf(potonganGopay));
        lblsubtotal3.setText(String.valueOf(subtotal3));
        lblnomeja.setText(keterangan);
        lblnama.setText(d.getPembeli()); 
        lblnopesanan.setText(noPesanan);
        lbltotalqty.setText(String.valueOf(jumlahbeli1));
    }
    


    @FXML
    private void cetakklik(ActionEvent event) {
        Alert a1 = new Alert(Alert.AlertType.INFORMATION);
        a1.setTitle("Information");
        a1.setHeaderText("STRUK PEMBAYARAN BERHASIL DICETAK!!!");
        a1.showAndWait();
    }

    @FXML
    private void kembaliklik(ActionEvent event) {
        btnkembali.getScene().getWindow().hide();;
    }
    
}
