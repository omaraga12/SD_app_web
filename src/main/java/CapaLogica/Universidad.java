package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadUniversidad;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Universidad extends EntidadUniversidad{
    
    conexion objC;
    String SQL;
    ResultSet rs = null;
    
    public Universidad() {
        objC = new conexion();
    }
    
    public ArrayList<EntidadUniversidad> llenarUniversidad() throws Exception{
        try {
           ArrayList<EntidadUniversidad> universidades = new ArrayList<EntidadUniversidad>();
           SQL = "select * from dbo.Universidad";
           rs = objC.consultarBD(SQL);
           while(rs.next()){
               EntidadUniversidad objEU = new EntidadUniversidad();
               objEU.setUniversidad_id(rs.getInt(1));
               objEU.setNombre_universidad(rs.getString(2));
               objEU.setPais_id(rs.getInt(3));
               universidades.add(objEU);
           }
           objC.desconectarBD();
           return universidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
