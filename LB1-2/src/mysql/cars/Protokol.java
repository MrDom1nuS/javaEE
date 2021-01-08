package mysql.cars;
import java.io.Serializable;

public class Protokol implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String skarga;
	 private String diagnos;
	 private String datapr;
	 
	 public Protokol(){ }
	 public Protokol(String skarga, String diagnos, String datapr) {
		 this.skarga = skarga;
		 this.diagnos = diagnos;
		 this.datapr = datapr;
	 }
	 public Protokol(int id, String skarga, String diagnos, String datapr) {
		 this.id = id;
		 this.skarga = skarga;
		 this.diagnos = diagnos;
		 this.datapr = datapr;
	 }
	 public int getId() {
	        return id;
	    }
	 public String getSkarga() {
	        return skarga;
	    }
	 
	    public void setSkarga(String skarga) {
	        this.skarga = skarga;
	    }
	    public String getDiagnos() {
	        return diagnos;
	    }
	 
	    public void setDiagnos(String diagnos) {
	        this.diagnos = diagnos;
	    }
	    public String getDatapr() {
	        return datapr;
	    }
	 
	    public void setDatapr(String datapr) {
	        this.datapr = datapr;
	    }
	    
}
