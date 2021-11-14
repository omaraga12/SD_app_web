package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadTipoDocumento;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class TipoDocumento extends EntidadTipoDocumento {

    conexion objC;
    String SQL;
    ResultSet rs = null;

    public TipoDocumento() {
        objC = new conexion();
    }

    public ArrayList<EntidadTipoDocumento> llenarDocumentos() throws Exception {
        try {
            ArrayList<EntidadTipoDocumento> documentos = new ArrayList<EntidadTipoDocumento>();
            SQL = "select * from dbo.tipo_documento";
            rs = objC.consultarBD(SQL);
            while (rs.next()) {
                EntidadTipoDocumento objETD = new EntidadTipoDocumento();
                objETD.setTipo_documento_id(rs.getInt(1));
                objETD.setNombre(rs.getString(2));
                documentos.add(objETD);
            }
            objC.desconectarBD();
            return documentos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
