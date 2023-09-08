package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AdminGirisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane adminGirisPnl;
 
    @FXML
    private TextField admin_name;
 
  
    @FXML
    private PasswordField admin_sifre; 
    
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
     
    public AdminGirisController(){ 
    	
    	baglanti=VeriTabaniUtil.Baglan();
    }
     
       
      

    @FXML
    public void admGiris(ActionEvent event) {  //Admin girişi
    	
    
    	  
    	//Admin Giriş kontrolü
    	try {     
    		
    		sql="select * from kullanicilar where kullaniciAdi=? and sifre=? and yetki='1'";
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,admin_name.getText().trim());
    	    sorgu.setString(2,admin_sifre.getText().trim());
    	    //VeriTabaniUtil.MD5Sifrele(admin_sifre.getText().trim()) 
    		getirilen=sorgu.executeQuery();
    		
    		//Hata vermesi durumunda
    		if(!getirilen.next()) {     
    		
    		    	Alert alert=new Alert(AlertType.CONFIRMATION);
    		    	alert.setTitle("Market Otomasyon");
    		    	alert.setHeaderText("Giriş Hatası");
    		    	alert.setContentText("kullanici adi veya sifre hatalıdır");
    		}
    		 
    		//Doğru Giriş olduğunda admın sayfasının acılması
    		else {     
    			
    			FXMLLoader guncelleme = new FXMLLoader (getClass().getResource("UrunGuncelleme.fxml"));        		
				Parent root2 =(Parent)guncelleme.load();
				Stage stage = new Stage();
	    		stage.setScene(new Scene(root2));
	    		stage.show();
				
    			 
    		}
    	}
    	//hata vermesı durumunda
    	catch (Exception e) {  
            System.out.println(e.getMessage().toString());
    
    		 
    		
				
			}  
		  
    	}
    	    	
    	    

    

    @FXML
    public void cikis(ActionEvent event) {
    	
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Market Otomasyonu");
    	alert.setHeaderText("Çıkış");
    	alert.setContentText("çıkmak istediğinize emin misiniz?");
    	
    	ButtonType buton1=new ButtonType("Evet");
    	ButtonType buton2=new ButtonType("Hayır");
    	alert.getButtonTypes().setAll(buton1,buton2); 
    	Optional<ButtonType> sonuc=alert.showAndWait();
    	
    	if(sonuc.get()==buton1) {
    		Platform.exit();
    		
    	}
    	else if(sonuc.get()==buton2) {
    		System.out.println("işlem iptal edildi.");
    	}

    } 
 
    @FXML
    public void personelGiris(ActionEvent event) {
    	
    	  
		try {
	
			 
			FXMLLoader personel = new FXMLLoader (getClass().getResource("PersonelGiris.fxml"));
    		Parent root1=(Parent) personel.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));
    		stage.show();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

    @FXML
    void initialize() {
        
    	
    	
    	
    	
    }

}
