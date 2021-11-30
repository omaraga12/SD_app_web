/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.conexion;
import CapaDatos.encoder;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Usuario {
    conexion objC;
    String SQL;
    ResultSet rs = null;

    public  Usuario() {
        objC = new conexion();
    }
    public static void main(String[] args) {
               
        try {
            Usuario obj= new Usuario();
            obj.agregarIDPostulanteEmpresa(1, 781);
            
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
    }
        public int RegistrarUsuario(String correo, String contrasena, int tipo) throws Exception {
            encoder encriptacion=new encoder();
            String contrasenaEncriptada=encriptacion.ecnode(contrasena);
        try {
            SQL = "insert into usuario(correo, contrasena, tipo) values('"+correo+"', '"+contrasenaEncriptada+"', "+tipo+")";
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
    
        public int agregarIDPostulanteEmpresa(int idUser, int idPostulanteEmpresa) throws Exception {
            
        try {
            SQL = "update usuario set id_postulante_empresa="+idPostulanteEmpresa+" where id="+idUser+"";
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

    
    public ResultSet verificarLogin(String correo, String contraseña) throws Exception {
        encoder encriptacion=new encoder();
        String contrasenaEncriptada=encriptacion.ecnode(contraseña);
        try {
            
            SQL = "select * from usuario where correo ='"+correo+"' and contrasena='"+contrasenaEncriptada+"'";
            rs = objC.consultarBD(SQL);
            return rs;
           
        } catch (Exception e) {
            System.err.println("ERROR"+e);
        }
        return null;
    }
}
