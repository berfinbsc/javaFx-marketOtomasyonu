package application;

public class Siparisler {
	
	

	private int id;
	 private int adet;
	private String urun;
	private double fiyat;
	private double total;
	 
		public Siparisler() { 
			
			
		}

      
 
    
	public Siparisler(int id, int adet,String urun,double fiyat ,double total) {
		
		this.id=id; 
		this.adet=adet;

		this.urun=urun;
		this.fiyat=fiyat;
		this.total=total;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getAdet() {
		return adet;
	}




	public void setAdet(int adet) {
		this.adet = adet;
	}




	public String getUrun() {
		return urun;
	} 




	public void setUrun(String urun) {
		this.urun = urun;
	}




	public double getFiyat() {
		return fiyat;
	}




	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}




	public double getTotal() {
		return total;
	}




	public void setTotal(double total) {
		this.total = total;
	}
    
 	

	
	
	

}
