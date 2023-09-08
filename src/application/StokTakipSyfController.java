package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class StokTakipSyfController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button geriStok;

    @FXML
    private AnchorPane stokAncp;

    @FXML
    private Button ileriStok;

    @FXML
    private ProgressBar pb1;

    @FXML
    private ProgressBar pb2;

    @FXML
    private ProgressBar pb3;

    @FXML
    private ProgressBar pb4;

    @FXML
    private ProgressBar pb5;

    @FXML
    private ProgressBar pb6;

    @FXML
    private ProgressBar pb7;

    @FXML
    private ProgressBar pb8;
    
    @FXML
    private TableView<Products> stokUrunTablo;
    @FXML
    private TableColumn<Products, Integer> idStok;
    @FXML
    private TableColumn<Products, String> stokUrun;
    @FXML
    private TableColumn<Products, Integer> stokStok;
    @FXML
    private TableColumn<Products, Double> stokFiyat;
    
    
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


    public int j=0;
    
    
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
    
    public  StokTakipSyfController(){
		baglanti=VeriTabaniUtil.Baglan();
}
    @FXML
    public  void geriBtn(ActionEvent event) {
    	if(j==0) {
    		DegerGir(j);
    	}
    	else {
    		j=j-8;
        	DegerGir(j);
    	}
    
 }
 
    @FXML
    public  void ileriBtn(ActionEvent event) { 	
    	j=j+8;
    	DegerGir(j);
 } 
    
     
	ObservableList<Products>productListe1; 
	ObservableList<Products>productListe2;
	ObservableList<ProgressBar>list3; 
	ObservableList<Label>list4;


    @FXML
    void initialize() {
    	productListe1 =FXCollections.observableArrayList();
		productListe2=FXCollections.observableArrayList();
		list3=FXCollections.observableArrayList();
		list4=FXCollections.observableArrayList();


		  // TableColumn'ları veri modeli ile eşleme
        idStok.setCellValueFactory(new PropertyValueFactory<>("id"));
        stokUrun.setCellValueFactory(new PropertyValueFactory<>("urun")); 
        stokStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        stokFiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
    
    	            
    	          
        sql="select * from urunler";
        try {
            sorgu=baglanti.prepareStatement(sql);
            ResultSet getirilen=sorgu.executeQuery();
            while(getirilen.next())

            {
            	productListe1.add(new Products(getirilen.getInt("id"),getirilen.getString("urun"),getirilen.getInt("stok"),getirilen.getDouble("fiyat")));


            }
			stokUrunTablo.setItems(productListe1);  

			

 
        }
        catch(Exception e) {
            System.out.println(e.getMessage().toString());

        }
   	 list3.addAll(pb1);
   	 list3.addAll(pb2); 
   	 list3.addAll(pb3);
   	 list3.addAll(pb4);
   	 list3.addAll(pb5);
   	 list3.addAll(pb6);
   	 list3.addAll(pb7);
   	 list3.addAll(pb8);
   	 	 
   	 list4.addAll(u1);
   	 list4.addAll(u2);
   	 list4.addAll(u3);
   	 list4.addAll(u4);	 
   	 list4.addAll(u5);
   	 list4.addAll(u6);	  
   	 list4.addAll(u7);
   	 list4.addAll(u8);
    	                         
    	DegerGir(0);
for(int n=0;n<8;n++)
{
	ProgressBar pby=list3.get(n);
	pby.setMaxHeight(200);
}
    }
	
	 
public void DegerGir(int baslangic) {
	 Products product = null ;
	 Products product1 = null ;


	for(int i=0;i<8;i++) 
	{
		    product  = productListe1.get(baslangic);
		    baslangic++; 
		   productListe2.addAll(product);
	       }
	  
		for(int i=0;i<8;i++) 
		{ 
			
			product1=productListe2.get(i); 
			String urun=product1.getUrun();
				double stok = product1.getStok();
				stok = (stok - 0) / (200 - 0); 

				
				ProgressBar pbx=list3.get(i); 
				 pbx.setProgress(stok); 
				 Label lblx=list4.get(i);
				 lblx.setText(urun);

		} 
    
		productListe2.clear();
    }




 
 

}
