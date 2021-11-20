/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.conexion;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class Usuario {
    conexion objC;
    String SQL;
    ResultSet rs = null;

    public Usuario() {
        objC = new conexion();
    }
    
        public int RegistrarUsuario(String correo, String contrasena, int tipo) throws Exception {
            
        try {
            SQL = "insert into usuario(correo, contrasena, tipo) values('" + correo+ "', '" + contrasena+ "', " + tipo + "";
            objC.ejecutarBD(SQL);
            String SQL2 = "select IDENT_CURRENT('usuario') [id]";
            rs = objC.consultarBD(SQL2);
            if (rs.next()) {
                return rs.getInt(1);
            }
            objC.desconectarBD();
            return -1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
        
    public int verificarLogin(String correo, String contraseña) throws Exception {
        int rpt=0;
        try {
            
            SQL = "select * from usuario where correo = '"+correo+"' and contrasena='"+contraseña+"'";
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                rpt=rs.getInt(1);
            }objC.desconectarBD();
           
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rpt;
    }
}
