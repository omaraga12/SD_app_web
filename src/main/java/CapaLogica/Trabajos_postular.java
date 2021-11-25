/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.conexion;
import java.sql.ResultSet;

/**
 *
 * @author nickb
 */
public class Trabajos_postular {
    
    conexion objC = new conexion();
    String SQL = null;
    ResultSet rs = null;
    
    public ResultSet consultarTrabajosPostular(int postulante_id) throws Exception{
        SQL = "select trabajo_postular_id, nombre, estado, em.nombre_empresa, tp.descripcion, cp.descripcion as profesion, tipo_trabajo, imagen from trabajos_postular tp "
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
    
    
    
}
