package mysql.cars;
import java.io.Serializable;

public class Violent implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String name;
	 private String skarga;
	 
	 public Violent(){ }
	 public Violent(String name, String skarga) {
		 this.name = name;
		 this.skarga = skarga;
	 }
	 public Violent(int id, String name, String skarga) {
		 this.id = id;
		 this.name = name;
		 this.skarga = skarga;
	 }
	 public int getId() {
	        return id;
	    }
	 public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getSkarga() {
	        return skarga;
	    }
	 
	    public void setSkarga(String skarga) {
	        this.skarga = skarga;
	    }
}
