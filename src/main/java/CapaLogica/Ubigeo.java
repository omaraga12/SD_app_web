package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadUbigeo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Ubigeo extends EntidadUbigeo {

    conexion objC;
    String SQL;
    ResultSet rs = null;

    public Ubigeo() {
        objC = new conexion();
    }

    public int buscarUbigeo() throws Exception {
        try {
            SQL = "select ubigeo_id from dbo.Ubigeo where departamento = '" + super.getDepartamento() + "' and provincia = '" + super.getProvincia() + "' and distrito = '" + super.getDistrito() + "'";
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                return rs.getInt(1);
            }
            objC.desconectarBD();
            return -1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<String> departamentosUbigeo() throws Exception {
        try {
            SQL = "select departamento from dbo.ubigeo group by departamento";
            rs = objC.consultarBD(SQL);
            ArrayList<String> departamentos = new ArrayList<String>();
            while (rs.next()) {
                departamentos.add(rs.getString(1));
            }
            objC.desconectarBD();
            return departamentos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<String> provinciaUbigeo() throws Exception {
        try {
            SQL = "select provincia from dbo.ubigeo where departamento = '" + super.getDepartamento() + "' group by provincia";
            rs = objC.consultarBD(SQL);
            ArrayList<String> provincias = new ArrayList<String>();
            while (rs.next()) {
                provincias.add(rs.getString(1));
            }
            objC.desconectarBD();
            return provincias;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<String> distritoUbigeo() throws Exception {
        try {
            SQL = "select distrito from dbo.Ubigeo where departamento = '" + super.getDepartamento() + "' and provincia = '" + super.getProvincia() + "' group by distrito";
            rs = objC.consultarBD(SQL);
            ArrayList<String> distritos = new ArrayList<String>();
            while (rs.next()) {
                distritos.add(rs.getString(1));
            }
            objC.desconectarBD();
            return distritos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }   

}
