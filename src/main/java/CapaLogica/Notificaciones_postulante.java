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
public class Notificaciones_postulante {
    
    conexion objC = new conexion();
    String SQL = null;
    ResultSet rs = null;
    
    public ResultSet consultarNotificacionesPostulante(int postulante_id) throws Exception{
        SQL = "select em.imagen, em.nombre_empresa, fecha, convert(char(8), hora, 108) as hora, np.notificacion_id, mensaje, tp.nombre "
                + "from notificaciones_postulante np inner join Empresa em on np.empresa_id = em.empresa_id inner join trabajos_postular tp "
                + "on np.trabajo_postular_id = tp.trabajo_postular_id "
                + "where np.postulante_id = "+postulante_id+" order by fecha, hora desc";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
