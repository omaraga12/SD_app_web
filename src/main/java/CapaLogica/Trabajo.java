/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.conexion;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Trabajo {
    conexion objC;
    String SQL;
    ResultSet rs = null;
     public Trabajo() {
        objC = new conexion();
    }
     
     public static void main(String[] args) {
               
        try {
            Trabajo obj= new Trabajo();
            //int id=obj.registrarTrabajo("Asesoria", "descripcc","Oficina","1","logo.png","66");
            System.err.println(obj.registrarTrabajoRequisito("26", "1"));
            
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
    }
     
   public ResultSet mostrarTrabajosPorEmpresa(String id){
       SQL="select trabajo_postular_id, nombre, case estado when 1 then 'Activo' else 'No activo' end, trabajos_postular.descripcion,categoria_profesion.descripcion, tipo_trabajo, imagen\n" +
        "from trabajos_postular inner join Categoria_profesion on Categoria_profesion.categoria_id=trabajos_postular.categoria_profesion_id "
               + "where empresa_id='"+id+"'";
        try {
            rs=objC.consultarBD(SQL);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       return rs;
   }
   
   public ResultSet mostrarPostulantesPorTrabajo(String id){
       SQL="select  Postulante.postulante_id, postulante.apellido_parterno, Postulante.apellido_materno, Postulante.nombres, Postulante.link_foto, Postulante.numero_documento, Ubigeo.departamento, ubigeo.provincia,\n" +
        "ubigeo.distrito, Categoria_profesion.descripcion, trabajo_postulante.trabajo_postular_id from postulante inner join Ubigeo on ubigeo.ubigeo_id=Postulante.ubigeo_ubigeo_id inner join Categoria_profesion on\n" +
        "Categoria_profesion.categoria_id=Postulante.categoria_profesion_categoria inner join trabajo_postulante on trabajo_postulante.postulante_id=Postulante.postulante_id \n"+
        "where trabajo_postulante.trabajo_postular_id='"+id+"'";
        try {
            rs=objC.consultarBD(SQL);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       return rs;
   }
   
   public int registrarTrabajo(String nombre, String descripcion, String tipo, String categoria_profesion,String imagen, String empresa_id) throws Exception{
       
       try {
            SQL = "insert into trabajos_postular(nombre, descripcion, tipo_trabajo, categoria_profesion_id, imagen, empresa_id, estado)"
          + " values('" + nombre+ "', '" +descripcion + "', '" + tipo + "', '" + categoria_profesion + "', '" + imagen+ "', '" +empresa_id + "', '1')";
            objC.ejecutarBD(SQL);
            String SQL2 = "select IDENT_CURRENT('trabajos_postular') [trabajos_postular_id]";
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
   
   public int registrarTrabajoRequisito(String id_trabajo, String id_requisito) throws Exception{
       
       try {
            SQL = "insert into requisitos_trabajo(trabajo_postular_id, requisito_id)"
          + " values('" + id_trabajo+ "', '" +id_requisito + "')";
            objC.ejecutarBD(SQL);
            String SQL2 = "select IDENT_CURRENT('requisitos_trabajo') [requisito_id]";
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
   
   public void DarDeBajaTrabajo(String id_trabajo) throws Exception{
       
       try {
            SQL = "update trabajos_postular set estado='0' where trabajo_postular_id='"+id_trabajo+"'";
     
            objC.ejecutarBD(SQL);
            
            objC.desconectarBD();
          
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
   }
}
