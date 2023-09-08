package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class SatisTakipSyfController{
 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button geriSatis;

    @FXML
    private Button ileriSatis;


    @FXML
    private ProgressBar pb10a;

    @FXML
    private ProgressBar pb11a;

    @FXML
    private ProgressBar pb12a;

    @FXML
    private ProgressBar pb1a;

    @FXML
    private ProgressBar pb2a;

    @FXML
    private ProgressBar pb3a;

    @FXML
    private ProgressBar pb5a;

    @FXML
    private ProgressBar pb6a;

    @FXML
    private ProgressBar pb7a;

    @FXML
    private ProgressBar pb8a;

    @FXML
    private ProgressBar pb9a;

    @FXML
    private ProgressBar pba;

    @FXML
    private DatePicker takvim;

    @FXML
    private Label u1;

    @FXML
    private Label u2;

    @FXML
    private Label u3;

    @FXML
    private Label u4;

    @FXML
    private Label u5;

    @FXML
    private Label u6;

    @FXML
    private Label u7;

    @FXML
    private Label u8;

    @FXML
    private Label u9; 

    @FXML
    private Label u10;

    @FXML
    private Label u11;

    @FXML
    private Label u12;

    public int secilenYil;
    
    Connection baglanti=null;
    PreparedStatement sorgu=null; 
    ResultSet getirilen=null;
    String sql;
    
public SatisTakipSyfController() {
		baglanti=VeriTabaniUtil.Baglan();
}  
        @FXML
    public void geriBtn(ActionEvent event) {
    	      	
    	// Tarih değerini bir yıl artırmak için:

    	LocalDate secilenTarihIleri = takvim.getValue(); 
    	LocalDate yeniTarihIleri = secilenTarihIleri.minusYears(1); 
    	takvim.setValue(yeniTarihIleri); 
        secilenYil = yeniTarihIleri.getYear();
  	  Getir();

    }

    @FXML
    public  void ileriBtn(ActionEvent event) {
    	
    	// Tarih değerini bir yıl azaltmak için:
    	LocalDate secilenTarihGeri = takvim.getValue(); 
    	LocalDate yeniTarihGeri = secilenTarihGeri.plusYears(1); 
    	takvim.setValue(yeniTarihGeri);
        secilenYil = yeniTarihGeri.getYear();
  	  Getir();

    }

    @FXML
    public  void takvim_C(ActionEvent event) {
    	
    	  LocalDate secilenTarih = takvim.getValue();
           secilenYil = secilenTarih.getYear();
     	  Getir();

    }
  
	ObservableList<ProgressBar>listeProgress;

    
    @FXML
    public void initialize() {
    	listeProgress=FXCollections.observableArrayList();
    	int i=1;  
    	double x;
    	 double tot[]; 
    	
    	 listeProgress.addAll(pb1a, pb2a, pb3a,pba,pb5a, pb6a, pb7a, pb8a, pb9a,pb10a, pb11a, pb12a);
    		
    	} 
    
    public void Getir() {
   	 double hepsitoplam=0;

		try { 
	    	for(int ay=1;ay<13;ay++) {
	    		
	    		sql="select total from siparisler where year(tarih) = ? and month(tarih) = ?";
				 sorgu=baglanti.prepareStatement(sql);
				 sorgu.setInt(1, secilenYil);
				 sorgu.setInt(2, ay);
		         ResultSet getirilen = sorgu.executeQuery();
		          
		         
		         while(getirilen.next()) {
		        	double tplm= getirilen.getDouble("total");
		        	  hepsitoplam=tplm + hepsitoplam;
		         } 
		         ProgressBar pbx =listeProgress.get(ay-1);
		         hepsitoplam = (hepsitoplam - 0) / (150 - 0); 

	    		pbx.setProgress(hepsitoplam);
	    		 
	    	} 
	    	    	
	      
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	 
	    	
	    }
    	
  

}
