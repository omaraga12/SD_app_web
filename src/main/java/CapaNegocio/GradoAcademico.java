package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadGradoAcademico;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class GradoAcademico extends EntidadGradoAcademico{
    
    conexion objC;
    String SQL;
    ResultSet rs = null;
    
    public GradoAcademico() {
        objC = new conexion();
    }
    
    public ArrayList<EntidadGradoAcademico> llenarGrados() throws Exception{
        try {
            ArrayList<EntidadGradoAcademico> grados = new ArrayList<EntidadGradoAcademico>();
            SQL = "select * from dbo.Grado_academico";
            rs = objC.consultarBD(SQL);
            while(rs.next()){
                EntidadGradoAcademico objEGA = new EntidadGradoAcademico();
                objEGA.setGrado_id(rs.getInt(1));
                objEGA.setDescripcion_grado(rs.getString(2));
                grados.add(objEGA);
            }objC.desconectarBD();
            return grados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
