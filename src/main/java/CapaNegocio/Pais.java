package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadPais;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Pais extends EntidadPais{
    
    conexion objC;
    String SQL;
    ResultSet rs = null;
    
    public Pais() {
        objC = new conexion();
    }
    
    public ArrayList<EntidadPais> llenarPais() throws Exception{
        try {
           ArrayList<EntidadPais> paises = new ArrayList<EntidadPais>();
           SQL = "select * from dbo.pais";
           rs = objC.consultarBD(SQL);
           while(rs.next()){
               EntidadPais objEP = new EntidadPais();
               objEP.setPais_id(rs.getInt(1));
               objEP.setNombre_pais(rs.getString(2));
               paises.add(objEP);
           }
           objC.desconectarBD();
           return paises;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
