/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Apple
 */
public class Validate extends ConexionDB{
    Connection con= this.conectar();
    PreparedStatement pr;
    public boolean checkUser (String email,String password) throws SQLException
    {
     boolean resultado=false;
     try{
         String sql="select* from usuarios where email=? and password=?";
         pr=con.prepareStatement(sql);
         pr.setString(1,email);
         pr.setString(2,password);
         ResultSet rs= pr.executeQuery();
         resultado=rs.next();
     }catch(SQLException ex){
         System.out.println(""+"error al autenticar"+ex.getMessage());
     }
     return resultado;
    }
}
