/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thana
 */
public class DBConnection {
    private static Connection conn;  
    private static String url = "jdbc:mysql://infodynamics.zapto.org/iphp";  
    private static String user = "root";//Username of database  
    private static String pass = "";//Password of database  
    public static Connection connect() throws SQLException{  
   
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
        }catch(ClassNotFoundException cnfe){  
            System.err.println("Error: "+cnfe.getMessage());  
        }catch(InstantiationException ie){  
            System.err.println("Error: "+ie.getMessage());  
        }catch(IllegalAccessException iae){  
            System.err.println("Error: "+iae.getMessage());  
        }  
        conn = DriverManager.getConnection(url,user,pass);  
        return conn;  
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{  
     if(conn !=null && !conn.isClosed())  
       return conn;  
     connect();  
     return conn;  
    }  
}
