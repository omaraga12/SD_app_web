package CapaLogica;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadPostulante;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Postulante extends EntidadPostulante {

    conexion objC;
    String SQL;
    ResultSet rs = null;

    public Postulante() {
        objC = new conexion();
    }

    public EntidadPostulante consultarPostulante() throws Exception {
        try {
            EntidadPostulante objEP = null;
            SQL = "select * from dbo.Postulante where postulante_id = " + super.getPostulante_id();
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                objEP = new EntidadPostulante();
                objEP.setPostulante_id(rs.getInt(1));
                objEP.setTipo_documento_id(rs.getString(2));
                objEP.setNumero_documento(rs.getString(3));
                objEP.setApellido_paterno(rs.getString(4));
                objEP.setApellido_materno(rs.getString(5));
                objEP.setNombres(rs.getString(6));
                objEP.setUbigeo_id(rs.getInt(7));
                objEP.setPais_id(rs.getInt(8));
                objEP.setProfesion_categoria(rs.getInt(9));
                objEP.setNumero_colegiatura(10);
                objEP.setLink_foto(rs.getString(11));
            }
            objC.desconectarBD();
            return objEP;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public int insertarPostulante() throws Exception {
        try {
            SQL = "insert into dbo.Postulante(tipo_documento_id, numero_documento, apellido_parterno, apellido_materno, nombres, ubigeo_ubigeo_id, pais_pais_id, categoria_profesion_categoria, numero_colegiatura, link_foto, contraseña) values('" + super.getTipo_documento_id() + "', '" + super.getNumero_documento() + "', '" + super.getApellido_paterno() + "', '" + super.getApellido_materno() + "', '" + super.getNombres() + "', " + super.getUbigeo_id() + ", " + super.getPais_id() + ", " + super.getProfesion_categoria() + ", " + super.getNumero_colegiatura() + ", '" + super.getLink_foto() + "', '" + super.getContra() + "')";
            objC.ejecutarBD(SQL);
            String SQL2 = "select IDENT_CURRENT('dbo.Postulante') [postulante_id]";
            rs = objC.consultarBD(SQL2);
            if (rs.next()) {
                return rs.getInt(1);
            }
            objC.desconectarBD();
            return -1;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void modificarPostulante() throws Exception {
        try {
            SQL = "update dbo.Postulante set tipo_documento_id = '" + super.getTipo_documento_id() + "', numero_documento =  '" + super.getNumero_documento() + "', apellido_paterno = '" + super.getApellido_paterno() + "', apellido_materno = '" + super.getApellido_materno() + "', nombres = '" + super.getNombres() + "', ubigeo_ubigeo_id = " + super.getUbigeo_id() + ", pais_pais_id = " + super.getPais_id() + ", numero_colegiatura = " + super.getNumero_colegiatura() + ", link_foto = '" + super.getLink_foto() + "' where postulante_id = " + super.getPostulante_id();
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarPostulante() throws Exception {
        try {
            SQL = "delete from dbo.Postulante where postulante_id = " + super.getPostulante_id();
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void listarPostulante(JTable tblListado) throws Exception {
        try {
            SQL = "select p.postulante_id, p.apellido_parterno + ' ' + p.apellido_materno as apellidos, p.nombres, p.numero_colegiatura, u.departamento, pa.nombre_pais from dbo.Postulante as p inner join dbo.Ubigeo as u on u.ubigeo_id = p.ubigeo_ubigeo_id inner join dbo.Pais as pa on pa.pais_id = p.pais_pais_id order by 2, 3 asc";
            rs = objC.consultarBD(SQL);

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Nombres");
            modelo.addColumn("Colegiatura");
            modelo.addColumn("Departamento");
            modelo.addColumn("País");

            tblListado.setModel(modelo);

            while (rs.next()) {
                Object datos[] = new Object[modelo.getColumnCount()];
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }

                modelo.addRow(datos);
            }
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public int verificarLogin(String dni, String contraseña) throws Exception {
        int rpt = 0;
        try {

            SQL = "select * from postulante where numero_documento = '" + dni + "' and contraseña='" + contraseña + "'";
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                rpt = rs.getInt(1);
            }
            objC.desconectarBD();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rpt;
    }

    public ResultSet busquedaFiltradaPostulantePorNombre(String busqueda) throws Exception {
        String filtro = "%" + busqueda + "%";
        SQL = "select p.postulante_id, p.apellido_parterno + ' ' + p.apellido_materno as apellidos, p.nombres, p.numero_colegiatura, u.departamento, pa.nombre_pais from dbo.Postulante as p inner join dbo.Ubigeo as u on u.ubigeo_id = p.ubigeo_ubigeo_id inner join dbo.Pais as pa on pa.pais_id = p.pais_pais_id where UPPER(p.nombres) like UPPER('" + filtro + "')";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ResultSet busquedaFiltradaPostulantePorPais(String busqueda) throws Exception {
        String filtro = "%" + busqueda + "%";
        SQL = "select p.postulante_id, p.apellido_parterno + ' ' + p.apellido_materno as apellidos, p.nombres, p.numero_colegiatura, u.departamento, pa.nombre_pais from dbo.Postulante as p inner join dbo.Ubigeo as u on u.ubigeo_id = p.ubigeo_ubigeo_id inner join dbo.Pais as pa on pa.pais_id = p.pais_pais_id where UPPER(pa.nombre_pais) like UPPER('" + filtro + "')";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ResultSet buscarPostulante(int id_postulante) throws Exception {
        SQL = "select apellido_parterno+' '+apellido_materno+' '+pos.nombres as nom_postulante, tpd.nombres as tipo_doc, numero_documento, pa.nombre_pais, "
                + "ub.departamento, ub.provincia, ub.distrito, numero_colegiatura, link_foto "
                + "from Postulante pos inner join tipo_documento tpd on pos.tipo_documento_id = tpd.tipo_documento_id inner join pais pa "
                + "on pos.pais_pais_id = pa.pais_id inner join Ubigeo ub on pos.ubigeo_ubigeo_id = ub.ubigeo_id where postulante_id = " + id_postulante + ";";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
