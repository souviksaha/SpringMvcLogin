package com.checkwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

 public boolean check(String uname,String pass)
 {
	 String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	 String u="system";
	 String p="souvik";
	 
	 try
	 {	
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection(url,u,p); 
		 		 
		 PreparedStatement pst=con.prepareStatement("select * from userfinal where uname=? and pass=?");
		 
		 pst.setString(1,uname);
		 pst.setString(2,pass);
		 
		 ResultSet rs=pst.executeQuery();
		 
		 if(rs.next())
		 {
			 return true;
		 }
	 }//end of try
	 catch(Exception e)
	 {
		 System.out.println("Inside catch");
		 System.out.println(e);
	 }//end of catch
	 
	 return false;
	 
 }//end of check
	
}//end of class LoginService