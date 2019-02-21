package ser322;

import java.io.File;
import java.io.StringWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TripleCrownDatabase {
   
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema";

   static final String USER = "root";
   static final String PASS = "Millie6667!";
   
   public static void main(String[] args) {
   Connection connect = null;
   Statement statemnt = null;
   PreparedStatement statement=null;
   try{
      
      Class.forName(args[3]);

      
      System.out.println("Connecting to database...");
      connect = DriverManager.getConnection(args[0],args[1],args[2]);

      
      System.out.println("Creating statement...");
      statemnt = connect.createStatement();
      
      
      
      if(args[4].equals("query1")){
      String query1;
      query1 = "SELECT cashvaluegiven FROM prize WHERE cashvaluegiven >= 5000";
      ResultSet rs = statemnt.executeQuery(query1);
      
       while(rs.next()){
         
         int cash = rs.getInt("cashvaluegiven");
       
         System.out.println("cash value given: " + cash);

      }
     
      rs.close();
      }
      
      
      if(args[4].equals("query2")){
      statement=connect.prepareStatement("SELECT _name FROM trainer WHERE trainerID=?");
      statement.setString(1, args[5]);
      ResultSet rs2 = statement.executeQuery();
      
      while(rs2.next()){
    	  String name=rs2.getString("_name");
    	  System.out.println("NAME: " + name);
      }
      rs2.close();
      
      }

      if(args[4].equals("insert")){
    	  statement=connect.prepareStatement("INSERT INTO record VALUES (?,?,?)");
    	  statement.setString(1,args[5]);
    	  statement.setString(2,args[6]);
    	  statement.setString(3, args[7]);
    	  statement.executeUpdate();
     
    	  System.out.println("success");
      }
     
      statemnt.close();
      connect.close();
   }catch(SQLException se){
      
      se.printStackTrace();
   }catch(Exception e){
      
      e.printStackTrace();
   }finally{
      
      try{
         if(statemnt!=null)
            statemnt.close();
      }catch(SQLException se2){
      }
      try{
         if(connect!=null)
            connect.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("disconnected..goodbye");
}
}
