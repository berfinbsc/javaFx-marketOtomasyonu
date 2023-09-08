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

public class PersonelGirisController {
	
	
	
	 
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane PersonelGirisPaneli;

    @FXML
    private TextField personel_name;


    @FXML
    private PasswordField personel_sifre;
    
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
    public PersonelGirisController(){
    	
    	baglanti=VeriTabaniUtil.Baglan();
    }
    
    
      
     

    @FXML
    public void cikis(ActionEvent event) {

    	Alert alert=new Alert(AlertType.WARNING);
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
   public void kullaniciGiris(ActionEvent event) {
    	
		try {  
		
    		
    		
    		FXMLLoader admin = new FXMLLoader (getClass().getResource("AdminGiris.fxml"));
    		Parent root1=(Parent) admin.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));
    		stage.show();
    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
    }  

    @FXML
    public void prsnlGiris(ActionEvent event) {
    	
		sql="select * from kullanicilar where kullaniciAdi=? and sifre=? and yetki='0'";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1,personel_name.getText().trim());    		
            sorgu.setString(2,personel_sifre.getText().trim());
    		getirilen=sorgu.executeQuery();
    		
    		if(!getirilen.next()) {  
    			
    	    	
    	    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	    	alert.setTitle("Market Otomasyon");
    	    	alert.setHeaderText("Giriş Hatası");
    	    	alert.setContentText("kullanici adi veya sifre hatalıdır");
    	    	
    	    	}
    	   
    	    	else {
    	    		FXMLLoader satis = new FXMLLoader (getClass().getResource("Satis.fxml"));
    	    		Parent root3=(Parent) satis.load();
    	    		Stage stage = new Stage(); 
    	    		stage.setScene(new Scene(root3));
    	    		stage.show(); 
    	    	}
    	    		
    	    	
    	
    		}

    
    	 catch (Exception e) { 
    		
    
				e.printStackTrace();
			}
    		
    	}

    

    @FXML
    void initialize() {
        
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
