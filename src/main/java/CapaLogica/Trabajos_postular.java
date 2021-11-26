/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nickb
 */
public class Trabajos_postular {
    
    conexion objC = new conexion();
    String SQL = null;
    ResultSet rs = null;
    ArrayList<String> SQLs = new ArrayList<>();
    
    public ResultSet consultarTrabajosPostular(int postulante_id) throws Exception{
        SQL = "select trabajo_postular_id, nombre, estado, em.nombre_empresa, tp.descripcion, cp.descripcion as profesion, tipo_trabajo, em.imagen from trabajos_postular tp "
                + "inner join Empresa em on tp.empresa_id = em.empresa_id inner join Categoria_profesion cp on tp.categoria_profesion_id = cp.categoria_id "
                + "where cp.categoria_id = (select categoria_profesion_categoria from Postulante where postulante_id = "+postulante_id+") and tp.trabajo_postular_id not in " 
                + "(select tpo.trabajo_postular_id from trabajo_postulante tpo where tpo.postulante_id = "+postulante_id+")";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void registrar_trabajo_postulante(int trabajo_id, int postulante_id) throws Exception{
        SQLs.clear();
        ResultSet consult_empresa = consultarEmpresaTrabajo(trabajo_id);
        if(consult_empresa.next()){
            int empresa_id = consult_empresa.getInt(1);
            SQLs.add("insert into trabajo_postulante values(" + trabajo_id + ", " + postulante_id + ");");
            SQLs.add("insert into notificaciones_postulante(empresa_id, postulante_id, mensaje, trabajo_postular_id) values("
                    + empresa_id + ", " + postulante_id + ", 'Su postulación se ha registrado correctamente, con mucho gusto "
                    + "revisaremos su perfil, gracias por postular a nuestro trabajo.', "+trabajo_id+");");
            try {
                objC.ejecutarBDTransacciones(SQLs);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }   
    }
    
    public ResultSet consultarEmpresaTrabajo(int trabajo_id) throws Exception{
        SQL = "select empresa_id from trabajos_postular where trabajo_postular_id = "+trabajo_id;
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
