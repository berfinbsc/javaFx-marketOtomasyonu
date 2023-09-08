package application;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class UrunGuncellemeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;  



    @FXML
    private TextField fiyatAdmin;

    @FXML
    private Button satisTakBut;

    @FXML
    private TextField stok;

    @FXML
    private Button stokTakBut;

 

    @FXML
    private TextField urunAdmin;

    @FXML
    private AnchorPane degisenAncp;

    @FXML
    private Button urunEkleBtn;


    @FXML
    private Button urunGncBtn;

    @FXML
    private Button urunGunBut;

    @FXML
    private TextField urunId;

  

    @FXML
    private Button urunKaldirBtn;

    @FXML
    private AnchorPane ap;

    @FXML
    private VBox bp;
    
 


    @FXML
    public void satisTak(ActionEvent event) {

    }

  

    @FXML
    public void stokTak(ActionEvent event) {

    }

  

 

    @FXML
    public void urunGun(ActionEvent event) {
    	menu("Guncelleme");

    }

 
    
    
    
    
 
    @FXML
    public void anaSayfa(MouseEvent event) {
    

    }

 

    @FXML
    public  void satisTakipSayfa(MouseEvent event) {
menu("SatisTakipSyf");
    }

  

    @FXML
    public  void stokTakipSayfa(MouseEvent event) { 
    	menu("StokTakipSyf");

    }


    	

    
    
    

    public void menu(String sayfa) {
    	
    
		try {
			 
			 AnchorPane	pane1 = (AnchorPane)FXMLLoader.load(getClass().getResource(sayfa+".fxml"));
			 degisenAncp.getChildren().setAll(pane1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	ObservableList<Products>urunList;

    @FXML
    void initialize() {
    	
    	urunList=FXCollections.observableArrayList();


    	
    	
    	
    	
 	
  	
    	
    
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
       
    }

}
