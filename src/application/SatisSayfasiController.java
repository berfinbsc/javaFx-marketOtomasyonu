package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.myConnect.Util.VeriTabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SatisSayfasiController {
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adtBtn;

    @FXML
    private Button anb;

    @FXML
    private Tab atistirmalik;


    @FXML
    private Button bC;

    @FXML
    private Tab bakiyat;

    @FXML
    private Button balti;

    @FXML
    private Button bbes;

    @FXML
    private Button bbir;

    @FXML
    private Button bdokuz;

    @FXML
    private Button bdort;

    @FXML
    private Button besb;

   
    @FXML
    private Button biki;

    
    @FXML
    private Button bsekiz;

    @FXML
    private Button bsifir;

    @FXML
    private Button buc;

   
    @FXML
    private Button bvirgul;

    @FXML
    private Button byedi;
   

    @FXML
    private TextField ekran;

    @FXML
    private Button ellib;

   

    @FXML
    private Tab icecek;

    @FXML
    private Button ikiyuzb;

 

    @FXML
    private Button kart;
   
    @FXML
    private Tab meyve;

  
    @FXML
    private Label paraustu;
    @FXML
    private Label odenen;
    @FXML
    private Button odnBtn;
    @FXML
    private Button okBtn;
    @FXML
    private Tab sebze;
    @FXML
    private Button silBtn;
    @FXML
    private TabPane tabUrunler;
    @FXML
    private Tab temizlk;
    @FXML
    private Label toplam;
    @FXML
    private Text tplm;
    @FXML
    private Button yirmib;
    @FXML
    private Button yuzb;
    @FXML
	Label lblsonuc; 
    @FXML
    private TableView<Siparisler> sepet;

    @FXML
    private TableColumn<Siparisler, Integer> adet; 

    @FXML
    private TableColumn<Siparisler, String> urun;

    @FXML
    private TableColumn<Siparisler, Double> fiyat;

    @FXML
    private TableColumn<Siparisler, Double> total;
    @FXML
    private TableColumn<Siparisler, Integer> id;
    @FXML
    private ImageView mguc;
    @FXML
    private ImageView sogan;
    @FXML
    private ImageView muz;
    @FXML
    private ImageView makarna;
    @FXML
    private ImageView peynirk;

    @FXML
    private ImageView portakal;

    @FXML
    private ImageView kbiber;

    @FXML
    private ImageView pirinc;

    @FXML
    private ImageView salgam;
    @FXML
    private ImageView sguc;
    @FXML
    private ImageView sampuan;
    @FXML
    private ImageView elma;

    @FXML
    private ImageView etiCt;

    @FXML
    private ImageView karpuz;
    @FXML
    private ImageView bulgur;
    @FXML
    private ImageView bplimon;
    @FXML
    private ImageView beypazari;

    @FXML
    private ImageView fasulye;

    @FXML
    private ImageView patlican;
    @FXML
    private ImageView camSil;

    @FXML
    private ImageView cappy;

    @FXML
    private ImageView nohut;

    @FXML
    private ImageView cilek;

    @FXML
    private ImageView cpsSade;

    @FXML
    private ImageView cpsYogurt;

    @FXML
    private ImageView salatalik;

    @FXML
    private ImageView domestos;
    @FXML
    private ImageView sarimsak;

    @FXML
    private ImageView ymercimek;
    @FXML
    private ImageView kavun;

    @FXML
    private ImageView kiraz;

    @FXML
    private ImageView kivi;

    @FXML
    private ImageView pirasa;

    @FXML
    private ImageView limon;

    @FXML
    private ImageView mercimek;

    @FXML
    private ImageView limonata;

    @FXML
    private ImageView link;

    @FXML
    private ImageView manti;
    @FXML
    private ImageView domates;
    @FXML
    private ImageView tpuzum;
    @FXML
    private ImageView uzum;
    @FXML
    private ImageView yummos;

    @FXML
    private ImageView wanted;
    @FXML
    private ImageView snikers;

    @FXML
    private ImageView susamk;
    
   
   

    @FXML
    void image(MouseEvent event) {
    	

    }
    

   public String totalSayi="";   
    
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    ResultSet getirilen=null;
    String sql;
    
    //class calıstırıldıgında verı tabanı baglantısı otomatık olusturulucak
     
    public SatisSayfasiController(){
    	
    	baglanti=VeriTabaniUtil.Baglan();
    }

      
    //Sepetteki urunlerın adetını guncelleme
    @FXML
    void adetBtn(ActionEvent event) {
    	   
    	int a=Integer.parseInt((ekran.getText()));
    	 ekran.clear();
       	totalSayi="";

    	Siparisler sepetSecili2 =new Siparisler();
    	sepetSecili2 =(Siparisler) sepet.getItems().get(sepet.getSelectionModel().getSelectedIndex());

    
    	sepetSecili2.setAdet(a);
    	double fiyatHsp=sepetSecili2.getFiyat();
    	
     	double totalHsp=a*fiyatHsp;
     	sepetSecili2.setTotal(totalHsp);
     	
        dizi.remove(sepetSecili2);
        dizi.add(sepetSecili2);
    	sepet.setItems(dizi);  
    	 Sepetim();
 
    	 
    }
    
    //Text ekranını silme

    @FXML
    void c(ActionEvent event) {
    	
     	ekran.clear();
     	totalSayi="";

    }

    @FXML
    void drink12_Click(MouseEvent event) {

    }

    //odeme yontemı kart secıldıgınde sıparıs eklenır odeme alınır

    @FXML
    void kart(ActionEvent event) {
    	odenen.setText(toplam.getText());
    	paraustu.setText("ödendi");
 

    	
    }

    
    //0-9 sayıları ıle deger gırme bu deger basılan butona gore adet,odenen para olarak atanır
    @FXML
    void number(ActionEvent event) {
    	  Button btn = (Button)event.getSource();
          
      	totalSayi=totalSayi+btn.getText();
      	ekran.setText(totalSayi);
      


    }

    //odenen butona basıldıgında texttekı sayıyı odenen mıktar olarak alır
    @FXML
    void odenenBtn(ActionEvent event) {
    	odenen.setText(ekran.getText());
    	ekran.clear();
     	totalSayi="";
    	ParaUstu();

    
    }

    //ok butona basıldıgında sıparıs tamamlanmıstır ve tum ekranlar ve sepet sıfırlanır
    @FXML
    void okBtn(ActionEvent event) {
    	toplam.setText(".....");
    	odenen.setText(".....");
    	paraustu.setText(".....");
    	
    	
    	for(Siparisler siparis: dizi ) {
    		
    	
    		int adet=siparis.getAdet();
    	double fiyat=siparis.getFiyat();
    		String urun=siparis.getUrun();
    	double total=siparis.getTotal();
    		
        //urunlerın stok mıktarı ve satıs takıbı yapılması ıcın sıparısler tablosuna kaydedılır

    	try {
    		sql="insert into siparisler(adet,fiyat,urun,total) values(?,?,?,?)";

    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setInt(1,adet);
    		sorgu.setDouble(2,fiyat);

    		sorgu.setString(3,urun);
    		sorgu.setDouble(3,total);
    		sorgu.executeUpdate();
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    		
    	}
    	
    	
    	dizi.clear(); 
     	sepet.setItems(dizi);
     	ekran.clear();
     	totalSayi="";

    }
    
    
    //textekı degerı sılme

    @FXML
    void silBtn(ActionEvent event) {
    	
    	 ekran.clear(); 
     	totalSayi="";
    	Siparisler sepetSecili1 =new Siparisler();
    	sepetSecili1 =(Siparisler) sepet.getItems().get(sepet.getSelectionModel().getSelectedIndex());
    	
    	dizi.remove(sepetSecili1);
    	sepet.setItems(dizi);
    	   Sepetim();
    	  
    	   
    }
    
    //odenen tam para degerlerı ıse kısaca bu butonlara basılır
    @FXML
    void tamSayi(ActionEvent event) {
    	
    	ekran.clear();
     	totalSayi="";

    	   Button tam =(Button)event.getSource();
    		  odenen.setText(tam.getText());
    		  ParaUstu();
    		  
    }

    @FXML
    void virgul(ActionEvent event) {

    }

    


    
    //resime tıklandıgında resmın id degeri ile veri tabanından urunun bılgılerı cekılır ve sepete eklenır
    
    @FXML
    void handleImageViewClick(ImageView img) { 
    	
String resimId=img.getId();
lblsonuc.setText(resimId);


try {  
	
	sql="select * from urunler where urun=?";
	sorgu=baglanti.prepareStatement(sql);
	sorgu.setString(1,resimId);
	getirilen=sorgu.executeQuery(); 
	if(getirilen.next()) {
		lblsonuc.setText(getirilen.getString("urun"));

	    int adetx=1;

	      	dizi.add(new Siparisler(getirilen.getInt("id"),adetx,getirilen.getString("urun"),getirilen.getDouble("fiyat"),getirilen.getDouble("fiyat"))); 
	     	sepet.setItems(dizi);  
            System.out.println(dizi.get(0).getUrun());
	     	Sepetim();     
	} 
	   
	     
	 
	 
} catch (Exception e) { 
	// TODO: handle exception
}

}
    
 
    
    @FXML
    void sepetSec_Click(ActionEvent event) {
    	 
    
    }
    String getir ="select * from urunler";
    ObservableList<Siparisler> dizi;
	List<Siparisler> siparisler=new ArrayList<>(); 

    @FXML
    void initialize() { 
    	
    	//tablo ıle siparisler classı ılıskılendırılır
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	adet.setCellValueFactory(new PropertyValueFactory<>("adet"));	
    	urun.setCellValueFactory(new PropertyValueFactory<>("urun")); 
    	fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
    	total.setCellValueFactory(new PropertyValueFactory<>("total")); 
    	
    	
       	dizi=FXCollections.observableArrayList();
       	
       	//resimlere tıklanıldıgında ımagevıew nesnesı fonksıyona deger olarak atanır
        patlican.setOnMouseClicked(event -> handleImageViewClick(patlican));
        fasulye.setOnMouseClicked(event -> handleImageViewClick(fasulye));
        beypazari.setOnMouseClicked(event -> handleImageViewClick(beypazari));
        bplimon.setOnMouseClicked(event -> handleImageViewClick(bplimon));
        bulgur.setOnMouseClicked(event -> handleImageViewClick(bulgur));
        camSil.setOnMouseClicked(event -> handleImageViewClick(camSil));
        cappy.setOnMouseClicked(event -> handleImageViewClick(cappy));
        nohut.setOnMouseClicked(event -> handleImageViewClick(nohut));
        cilek.setOnMouseClicked(event -> handleImageViewClick(cilek)); 
        cpsSade.setOnMouseClicked(event -> handleImageViewClick(cpsSade));
        cpsYogurt.setOnMouseClicked(event -> handleImageViewClick(cpsYogurt));
        salatalik.setOnMouseClicked(event -> handleImageViewClick(salatalik));
        domestos.setOnMouseClicked(event -> handleImageViewClick(domestos));
        elma.setOnMouseClicked(event -> handleImageViewClick(elma));
        etiCt.setOnMouseClicked(event -> handleImageViewClick(etiCt));
        sarimsak.setOnMouseClicked(event -> handleImageViewClick(sarimsak));
        ymercimek.setOnMouseClicked(event -> handleImageViewClick(ymercimek));
        karpuz.setOnMouseClicked(event -> handleImageViewClick(karpuz));
        kavun.setOnMouseClicked(event -> handleImageViewClick(kavun));
        kiraz.setOnMouseClicked(event -> handleImageViewClick(kiraz));
        kivi.setOnMouseClicked(event -> handleImageViewClick(kivi));
        pirasa.setOnMouseClicked(event -> handleImageViewClick(pirasa));
        limon.setOnMouseClicked(event -> handleImageViewClick(limon));
        mercimek.setOnMouseClicked(event -> handleImageViewClick(mercimek));
        limonata.setOnMouseClicked(event -> handleImageViewClick(limonata));
        link.setOnMouseClicked(event -> handleImageViewClick(link));
        manti.setOnMouseClicked(event -> handleImageViewClick(manti));
        mguc.setOnMouseClicked(event -> handleImageViewClick(mguc));
        muz.setOnMouseClicked(event -> handleImageViewClick(muz));
        sarimsak.setOnMouseClicked(event -> handleImageViewClick(sarimsak));
        ymercimek.setOnMouseClicked(event -> handleImageViewClick(ymercimek));
        pirinc.setOnMouseClicked(event -> handleImageViewClick(pirinc));
        snikers.setOnMouseClicked(event -> handleImageViewClick(snikers));
        susamk.setOnMouseClicked(event -> handleImageViewClick(susamk));
        tpuzum.setOnMouseClicked(event -> handleImageViewClick(tpuzum));
        uzum.setOnMouseClicked(event -> handleImageViewClick(uzum)); 
        wanted.setOnMouseClicked(event -> handleImageViewClick(wanted));
        yummos.setOnMouseClicked(event -> handleImageViewClick(yummos));
        sguc.setOnMouseClicked(event -> handleImageViewClick(sguc));
        sampuan.setOnMouseClicked(event -> handleImageViewClick(sampuan));
        makarna.setOnMouseClicked(event -> handleImageViewClick(makarna));
        peynirk.setOnMouseClicked(event -> handleImageViewClick(peynirk));
        salgam.setOnMouseClicked(event -> handleImageViewClick(salgam));
        sogan.setOnMouseClicked(event -> handleImageViewClick(sogan));
       // kbiber.setOnMouseClicked(event -> handleImageViewClick(kbiber));
        domates.setOnMouseClicked(event -> handleImageViewClick(domates));
        
    } 
   
 
    
    
    //her urune tıklandıgında toplam fıyat yenıden hesaplanır veya adet guncellemesı,urun sılmede
   
    public void Sepetim() { 

    	  double y =0; 

    	  for (Siparisler siparis : dizi) {
    		 
    		 double tp = siparis.getTotal();
    	
    		 y +=tp;
    		   
  			
  		}
  	  
    	  toplam.setText(String.valueOf(y));
    	
    	}
       
    
    //odenen paradan toplam fıyat cıkarılarak verılecek para ustu ekranda gosterılır
      public void ParaUstu() {
      	
      	
  double tp = Double.parseDouble(toplam.getText());
  double odn =Double.parseDouble(odenen.getText());
  double pustu =odn-tp;
  String parau=String.valueOf(pustu);
  paraustu.setText(parau);
      }
      
      
      
       
      
  public void degerleriGetir(TableView tablo,String getir) {
   	   ObservableList<Products> veri=FXCollections.observableArrayList();
    	  
   	try {
		 sorgu = baglanti.prepareStatement(getir);
		 ResultSet getirilen=sorgu.executeQuery();
		 while (getirilen.next()) {
			 veri.add(new Products(
					 getirilen.getInt("id"),
					 getirilen.getString("urun"),
					 getirilen.getInt("stok"),
					 getirilen.getDouble("fiyat")
					 ));
			 
			
		}
			adet.setCellValueFactory(new PropertyValueFactory<Siparisler,Integer>("id"));
			urun.setCellValueFactory(new PropertyValueFactory<Siparisler,String>("urun"));
			fiyat.setCellValueFactory(new PropertyValueFactory<Siparisler,Double>("fiyat"));
			total.setCellValueFactory(new PropertyValueFactory<Siparisler,Double>("total"));
			
			tablo.setItems(dizi);
			  
	} catch (Exception e) {
		System.out.println(e.getMessage().toString());
	}
    	  
    	  
      }
      
       
      
       
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    
    
}
