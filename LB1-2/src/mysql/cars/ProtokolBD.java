package mysql.cars;
import java.sql.*;

import java.util.ArrayList;

public class ProtokolBD {
	private static String url = "jdbc:mysql://localhost/hospitalbd?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "";
    public static ArrayList<Protokol> select() {
    	 ArrayList<Protokol> priyoms = new ArrayList<Protokol>();
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    		 try (Connection conn = DriverManager.getConnection(url, username, password)){
    			 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM priyom");
                 while(resultSet.next()){
                	 int id = resultSet.getInt(1);
                	 String skarga = resultSet.getString(2);
                	 String diagnos = resultSet.getString(3);
                	 String datapr = resultSet.getString(4);
                	 Protokol priyom = new Protokol(id,skarga,diagnos, datapr);
                	 priyoms.add(priyom);
    		 }
    	 }
     }
    	 catch(Exception ex){
    		 System.out.println(ex);
    	 }
    	 return priyoms;
}
    public static Protokol selectOne(int id) {
    	Protokol priyom = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
            	String sql = "SELECT * FROM priyom WHERE id=?";
            	try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                    	 int prodId = resultSet.getInt(1);
                    	 String skarga = resultSet.getString(2);
                    	 String diagnos = resultSet.getString(3);
                    	 String datapr = resultSet.getString(4);
                    	 priyom = new Protokol(prodId,skarga,diagnos,datapr);
                    }
            }
    	}
    }
    	catch(Exception ex) {
    		System.out.println(ex);
    	}
    	return priyom;
    }
    public static int insert(Protokol priyom) {
    	  try{
              Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
              try (Connection conn = DriverManager.getConnection(url, username, password)){
                    
                  String sql = "INSERT INTO priyom (skarga, diagnos, datapr) Values (?, ?, ?)";
                  try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                      preparedStatement.setString(1, priyom.getSkarga());
                      preparedStatement.setString(2, priyom.getDiagnos());
                      preparedStatement.setString(3, priyom.getDatapr());
                      return  preparedStatement.executeUpdate();
                  }
              }
    }
    	  catch(Exception ex) {
      		System.out.println(ex);
      	}
    	  return 0;
 }

    public static int update(Protokol priyom) {
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE pacient SET skarga = ?, diagnos = ?,, datapr = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, priyom.getSkarga());
                    preparedStatement.setString(2, priyom.getDiagnos());
                    preparedStatement.setString(3, priyom.getDatapr());
                    preparedStatement.setInt(4, priyom.getId());
                      
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
            	 String sql = "DELETE FROM priyom WHERE id = ?";
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
 // Find priyom
//  public static int search(Priyom priyom) {
//  	try{
//          Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//          try (Connection conn = DriverManager.getConnection(url, username, password)){
//                
//              String sql = "SELECT * FROM priyom where skarga = ?";
//              try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//    			preparedStatement.setString(1, priyom.getSkarga());
//    			preparedStatement.setString(2, priyom.getDiagnos());
//    			preparedStatement.setString(3, priyom.getDatapr());
//   		 	preparedStatement.setInt(4, priyom.getId());
//                  return  preparedStatement.executeUpdate();
//              }
//          }
//      }
//      catch(Exception ex){
//          System.out.println(ex);
//      }
//      return 0;
//  }
            
}


