package application;

public class Products {
	
	    	 
	    	
	    	private int id;
	    	private String urun;
	    	private double fiyat;
	        private int stok; 
	        
	        
	    	public Products() {
	    		
	    	}
	    	
 	public Products(String urun,int stok) {
	    		
	    		this.urun=urun;
	    		this.stok=stok;
	    	}
	        
	    	public Products(int id,String urun,int stok,double fiyat) {
	    		
	    		this.id=id;
	    		this.urun=urun;
	    		this.fiyat=fiyat;
	    		this.stok=stok;
	    	}
	        
	     	public Integer getId() {
				return id;
			}
	    	public void setId(Integer id) {
				this.id = id;
			}

	    
	    	public Integer getStok() {
				return stok;
			}
	    	public void setStok(Integer stok) {
				this.stok = stok;
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

		
		
	    	
	    }
	


