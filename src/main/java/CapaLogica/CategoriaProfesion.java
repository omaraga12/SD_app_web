
package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadCategoriaProfesion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class CategoriaProfesion extends EntidadCategoriaProfesion{
    
    conexion objC;
    String SQL;
    ResultSet rs = null;
    
    public CategoriaProfesion() {
        objC = new conexion();
    }
    
    public ArrayList<EntidadCategoriaProfesion> llenarCategorias() throws Exception{
        try {
            ArrayList<EntidadCategoriaProfesion> categorias = new ArrayList<EntidadCategoriaProfesion>();
            SQL = "select * from dbo.Categoria_profesion";
            rs = objC.consultarBD(SQL);
            while(rs.next()){
                EntidadCategoriaProfesion objECP = new EntidadCategoriaProfesion();
                objECP.setCategoria_id(rs.getInt(1));
                objECP.setDescripcion(rs.getString(2));
                categorias.add(objECP);
            }objC.desconectarBD();
            return categorias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
