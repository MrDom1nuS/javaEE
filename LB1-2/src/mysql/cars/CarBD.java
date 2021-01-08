package mysql.cars;
import java.sql.*;
import java.util.ArrayList;

public class CarBD {
	private static String url = "jdbc:mysql://localhost/hospitalbd?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "";
    public static ArrayList<Car> select() {
    	 ArrayList<Car> doctors = new ArrayList<Car>();
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		 try (Connection conn = DriverManager.getConnection(url, username, password)){
    			 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM doctor");
                 while(resultSet.next()){
                	 int id = resultSet.getInt(1);
                	 String name = resultSet.getString(2);
                	 String special = resultSet.getString(3);
                	 Car doctor = new Car(id,name,special);
                	 doctors.add(doctor);
    		 }
    	 }
     }
    	 catch(Exception ex){
    		 System.out.println(ex);
    	 }
    	 return doctors;
}
    public static Car selectOne(int id) {
    	Car doctor = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
            	String sql = "SELECT * FROM doctor WHERE id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	 int prodId = resultSet.getInt(1);
                    	 String name = resultSet.getString(2);
                    	 String special = resultSet.getString(3);
                    	 doctor = new Car(prodId, name , special);
                    }
            }
    	}
    }
    	catch(Exception ex) {
    		System.out.println(ex);
    	}
    	return doctor;
    }
    public static int insert(Car doctor) {
    	  try{
              Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
              try (Connection conn = DriverManager.getConnection(url, username, password)){
                    
                  String sql = "INSERT INTO doctor (name, special) Values (?, ?)";
                  try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                      preparedStatement.setString(1, doctor.getName());
                      preparedStatement.setString(2, doctor.getSpecial());
                    
                      return  preparedStatement.executeUpdate();
                  }
              }
    }
    	  catch(Exception ex) {
      		System.out.println(ex);
      	}
    	  return 0;
 }

    public static int update(Car doctor) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE doctor SET name = ?, special = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, doctor.getName());
                    preparedStatement.setString(2, doctor.getSpecial());
                    preparedStatement.setInt(3, doctor.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
            	 String sql = "DELETE FROM doctor WHERE id = ?";
                 try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                     preparedStatement.setInt(1, id);
                       
                     return  preparedStatement.executeUpdate();
                 }
             }
         }
         catch(Exception ex){
             System.out.println(ex);
         }
         return 0;
     }
// Find doctor
//    public static int search(Doctor doctor) {
//    	try{
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)){
//                  
//                String sql = "SELECT * FROM doctor where name = ?";
//                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                    preparedStatement.setString(1, doctor.getName());
//                    preparedStatement.setString(2, doctor.getSpecial());
//                    preparedStatement.setInt(3, doctor.getId());
//                      
//                    return  preparedStatement.executeUpdate();
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return 0;
//    }
            
}


