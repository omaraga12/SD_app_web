package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadIdioma;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Idioma extends EntidadIdioma {

    conexion objC;
    String SQL;
    ResultSet rs = null;

    public Idioma() {
        objC = new conexion();
    }

    public EntidadIdioma consultarIdioma() throws Exception {
        try {
            EntidadIdioma objEI = null;
            SQL = "select * from dbo.Idiomas_postulante where idioma_id = " + super.getIdioma_id();
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                objEI.setIdioma_id(rs.getInt(1));
                objEI.setIdioma(rs.getString(2));
                objEI.setNivel(rs.getString(3));
                objEI.setLink_archivo(rs.getString(4));
                objEI.setPostulante_id(rs.getInt(5));
            }
            objC.desconectarBD();
            return objEI;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertarIdioma() throws Exception {
        try {
            SQL = "insert into dbo.Idiomas_postulante(idioma, nivel, link_archivo, postulante_postulante_id) values('" + super.getIdioma() + "', '" + super.getNivel() + "', '" + super.getLink_archivo() + "', " + super.getPostulante_id() + ")";
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void modificarIdioma() throws Exception {
        try {
            SQL = "update dbo.Idiomas_postulante set idioma = '" + super.getIdioma() + "', nivel = '" + super.getNivel() + "', link_archivo = '" + super.getLink_archivo() + "', postulante_postulante_id" + super.getPostulante_id() + ")";
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarIdioma() throws Exception {
        try {
            SQL = "delete from dbo.Idiomas_postulante where idioma_id = " + super.getIdioma_id();
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void listarIdioma(JTable tblListado) throws Exception {
        try {
            SQL = "select ip.idioma_id, ip.idioma, ip.nivel, (p.apellido_parterno + ' ' + p.apellido_materno + ' ' + p.nombres) as nombre from dbo.Idiomas_postulante as ip inner join dbo.Postulante as p on p.postulante_id = ip.postulante_postulante_id";
            rs = objC.consultarBD(SQL);
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Idioma");
            modelo.addColumn("Nivel");
            modelo.addColumn("Postulante");
            
            tblListado.setModel(modelo);
            
            while(rs.next()){
                Object datos[] = new Object[modelo.getColumnCount()];
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i+1);
                }
                
                modelo.addRow(datos);
            }   
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ArrayList<EntidadIdioma> llenarIdiomas() throws Exception {
        try {
            ArrayList<EntidadIdioma> idiomas = new ArrayList<EntidadIdioma>();
            SQL = "select * from dbo.Idiomas_postulante";
            rs = objC.consultarBD(SQL);
            while(rs.next()){
                EntidadIdioma objEI = new EntidadIdioma();
                objEI.setIdioma_id(rs.getInt(1));
                objEI.setIdioma(rs.getString(2));
                objEI.setNivel(rs.getString(3));
                objEI.setLink_archivo(rs.getString(4));
                objEI.setPostulante_id(rs.getInt(5));
                idiomas.add(objEI);
            }
            objC.desconectarBD();
            return idiomas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public ResultSet busquedaFiltradaPostulantePorIdioma( String busqueda) throws Exception{
        String filtro="%"+busqueda+"%";
        SQL="select ip.idioma_id, ip.idioma, ip.nivel, (p.apellido_parterno + ' ' + p.apellido_materno + ' ' + p.nombres) as nombre from dbo.Idiomas_postulante as ip inner join dbo.Postulante as p on p.postulante_id = ip.postulante_postulante_id where UPPER(ip.idioma) like UPPER('"+filtro+"')";
        try {
            rs=objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public ResultSet busquedaFiltradaPostulantePorNivel( String busqueda) throws Exception{
        String filtro="%"+busqueda+"%";
        SQL="select ip.idioma_id, ip.idioma, ip.nivel, (p.apellido_parterno + ' ' + p.apellido_materno + ' ' + p.nombres) as nombre from dbo.Idiomas_postulante as ip inner join dbo.Postulante as p on p.postulante_id = ip.postulante_postulante_id where UPPER(ip.nivel) like UPPER('"+filtro+"')";
        try {
            rs=objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

