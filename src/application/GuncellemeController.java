package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class GuncellemeController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField fiyatAdmin;
    @FXML
    private TextField stokAdmin;
    @FXML
    private TextField urunAdmin;
    @FXML
    private AnchorPane urunAdminAncp;
    @FXML
    private Button urunEkleBtn;
    @FXML
    private Button urunGncBtn;
    @FXML
    private TextField urunId;
    @FXML
    private Button urunKaldirBtn;
    @FXML
    private TableView<Products> adminUrunTablo;
    @FXML
    private TableColumn<Products, String> urunAd;
    @FXML
    private TableColumn<Products, Double> urunFiyat;
    @FXML
    private TableColumn<Products, Integer> urunIdAnaSyf;
    @FXML
    private TableColumn<Products, Integer> urunStok;
    
     
      
      
    
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    public String sql;
    
    //constructor
    public GuncellemeController(){
		baglanti=VeriTabaniUtil.Baglan();
		  
	}
 
    //veri tabanına yenı urun ekleme 
 
        @FXML
        public void urunEkle(ActionEvent event) {
        	sql="insert into urunler(urun,stok,fiyat) values (?,?,?) "; 
        	try {
        		sorgu=baglanti.prepareStatement(sql);
        		
        		sorgu.setString(1,urunAdmin.getText().trim());  
        		sorgu.setString(3,fiyatAdmin.getText().trim());
        		sorgu.setString(2,stokAdmin.getText().trim()); 
        		
        		sorgu.executeUpdate();
        		
        		Alert alert=new Alert(AlertType.INFORMATION); 
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Bilgi Mesajı");
    	    	alert.setContentText("Ürün Ekleme İşlemi Başarılı!");
    	    	alert.showAndWait(); 
        		
        		
        		
        	}catch(Exception e) {
        		System.out.println(e.getMessage().toString());
        		Alert alert=new Alert(AlertType.WARNING);
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Bilgi Mesajı");
    	    	alert.setContentText("Ürün Ekleme İşlemi Başarısız!");
    	    	alert.showAndWait();
        		
        		
        	}
 
        }
        
 
        //verı tabanındakı bır urunu guncelleme
        @FXML
        public  void urunGnc(ActionEvent event) {
        	sql="update urunler set urun=?,fiyat=?,stok=? where id=? ";
        	try {
        		sorgu=baglanti.prepareStatement(sql);
        	
        		sorgu.setString(1,urunAdmin.getText().trim());
        		sorgu.setString(2,fiyatAdmin.getText().trim());
        		sorgu.setString(3,stokAdmin.getText().trim());
        		sorgu.setString(4,urunId.getText().trim()); 

        		
        		
        		sorgu.executeUpdate();

        		Alert alert=new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Bilgi Mesajı");
    	    	alert.setContentText("Güncelleme Başarılı!");
    	    	alert.showAndWait();
        		
        	}catch(Exception e) {
        		System.out.println(e.getMessage().toString());
        		
        		Alert alert=new Alert(AlertType.WARNING);
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Bilgi Mesajı");
    	    	alert.setContentText("Güncelleme Başarısız!");
    	    	alert.showAndWait();
        		
        	} 

        }
 
        
        
        

       
        //veri tabanından bır urun sılme

        @FXML
        public void urunKaldir(ActionEvent event) {
        	
        	sql="delete from urunler where id=?";
        	try {
        		
        		sorgu=baglanti.prepareStatement(sql);
        		sorgu.setString(1,urunId.getText().trim());
        		sorgu.executeUpdate();
        		 
        		Alert alert=new Alert(AlertType.INFORMATION);
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Bilgi Mesajı");
    	    	alert.setContentText("Silme işlemi başarılı");
    	    	alert.showAndWait();
        		
        	
        	}catch(Exception e) {
        		System.out.println(e.getMessage().toString());  
        		Alert alert=new Alert(AlertType.WARNING);
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Bilgi Mesajı");
    	    	alert.setContentText("Silme işlemi başarısız");
    	    	alert.showAndWait();
        		
        		
        	}
        }
        
        
        //tabloda secılen urunun degerlerının textfieldlara yazılması.
        @FXML
        public void  urunSec_Click (ActionEvent event) {
        	
        	Products urun=new Products();
            urun=(Products)adminUrunTablo.getItems().get(adminUrunTablo.getSelectionModel().getSelectedIndex());
            urunId.setText(String.valueOf(urun.getId()));
            urunAdmin.setText(urun.getUrun());
            fiyatAdmin.setText(String.valueOf(urun.getFiyat()));
            stokAdmin.setText(String.valueOf(urun.getStok()));

        	
        }
        
    	ObservableList<Products>urunList;

        @FXML
        void initialize() {
        	
        	urunList=FXCollections.observableArrayList();

        	//ekran acıldıgında tum urunlerın tabloda lıstelenmesı ıcın verı tabanına ıstek yollanır.Tum verıler cekılır.
        	sql="select * from urunler";
        	try {
        		sorgu=baglanti.prepareStatement(sql);
        	    ResultSet getirilen=sorgu.executeQuery();
        	   
        	    while(getirilen.next())
        	    {
        	    	int id=getirilen.getInt("id");
        	    	String urun=getirilen.getString("urun");
        	    	double fiyat=getirilen.getInt("fiyat");
        	    	int stok=getirilen.getInt("stok");       	    
        	    	urunList.add(new Products(id,urun,stok,fiyat));
            	    adminUrunTablo.setItems(urunList);

        	    }
        	    //tablo colonları ıle urunler classındakı degerlerın eslestırılmesı
        	    urunIdAnaSyf.setCellValueFactory(new PropertyValueFactory<>("id"));
        	    urunAd.setCellValueFactory(new PropertyValueFactory<>("urun"));
        	    urunFiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        	    urunStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        		
        	    
        	
        	}catch(Exception e) { 
        		System.out.println(e.getMessage().toString());
        		
        	}
        		
    	
    	
    	
        
    }

}
