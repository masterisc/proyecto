/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HGR46;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.*;

public class Conexion {
   /**Parametros de conexion*/
   static String bd = "hgr46";
   static String login = "root";
   static String password = "root";
   static String url = "jdbc:mysql://localhost/"+bd;
 
   Connection connection = null;
   Statement stm = null;
 
   public Conexion() {
      try{
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(url,login,password);
         stm = connection.createStatement();
         //showMessageDialog(null, "Conexxion a la Base de datos OK!!!");
         //ResultSet rs = stm.executeQuery("select * from clientes");
         /*while(rs.next()){
             
            System.out.println(rs.getString("id_cliente"));
            System.out.println(rs.getString("nombre"));
            System.out.println(rs.getString("direccion"));
            System.out.println(rs.getString("telefono"));
            System.out.println(rs.getString("contrato"));
             
         }
         if (connection!=null){
            showMessageDialog(null, "Conexxion a la Base de datos OK!!!");
            //System.out.println("Conexión a base de datos "+bd+" OK\n");
         }*/
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
     // connection = null;
       try {
           connection.close();
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   }
