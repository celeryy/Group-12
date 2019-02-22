package ser322;

import java.io.Console;
import java.io.File;
import java.io.StringWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

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
    
   public static void main(String[] args) {
      
       Connection connect = null;
       Statement stmnt = null;
       PreparedStatement pStmnt=null;
       ResultSet rs = null;
   
       if (args.length < 3) {
	   System.out.print("USAGE: java ser322.TripleCrownDatabase");
	   System.out.println("<url> <driver>");
	   System.exit(0);
       }

       // Database information
       String url = args[0];
       String driver = args[1];
       String method = args[2];
            
       try{	   
	   // Get login info
	   Console cons = System.console();       
	   System.out.print("Please enter your login username: ");
	   String user = cons.readLine();
	   char[] passArr = cons.readPassword("Enter your password: ");
	   String pass = new String(passArr);
	   System.out.println();

	   // Connect to database
	   Class.forName(driver);
	   System.out.println("Connecting to database...");
	   connect = DriverManager.getConnection(url, user, pass);

	   // Create a blank statement
	   System.out.println("Creating statement...");
	   stmnt = connect.createStatement();      

	   // Execute queries
	   if(method.equals("query1")){
	       String query1;
	       query1 = "SELECT cashvaluegiven FROM prize WHERE cashvaluegiven >= 5000";
	       rs = stmnt.executeQuery(query1);
      
	       while(rs.next()){         
		   int cash = rs.getInt("cashvaluegiven");       
		   System.out.println("cash value given: " + cash);
	       }
	   } else if (method.equals("query2")){	       
	       pStmnt=connect.prepareStatement("SELECT _name FROM trainer WHERE trainerID=?");
	       pStmnt.setString(1, args[5]);
	       rs = pStmnt.executeQuery();
      
	       while(rs.next()){
		   String name=rs.getString("_name");
		   System.out.println("NAME: " + name);
	       }
	   } else if (method.equals("insert")){
	       pStmnt=connect.prepareStatement("INSERT INTO record VALUES (?,?,?)");
	       pStmnt.setString(1,args[5]);
	       pStmnt.setString(2,args[6]);
	       pStmnt.setString(3, args[7]);
	       pStmnt.executeUpdate();
     
	       System.out.println("success");
	   }
       } catch(Exception e) {
	   System.out.println("Exception executing statement on database");
	   e.printStackTrace();
       } finally {

	   try {
	       if (rs != null)
		   rs.close();
	       if (stmnt != null)
		   stmnt.close();
	       if (pStmnt != null)
		   pStmnt.close();
	       if (connect != null)
		   connect.close();
	   } catch(SQLException se){
	       System.out.println("Exception closing resources");
	       se.printStackTrace();
	   }
       }
       System.out.println("disconnected..goodbye");
   }
}
