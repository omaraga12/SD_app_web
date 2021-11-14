package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadProfesion;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Profesion extends EntidadProfesion {

    conexion objC;
    String SQL;
    ResultSet rs = null;

    public Profesion() {
        objC = new conexion();
    }

    public EntidadProfesion consultarProfesion() throws Exception {
        try {
            EntidadProfesion objEP = null;
            SQL = "select * from postulante where profesion_id = " + super.getProfesion_id();
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                objEP = new EntidadProfesion();
                objEP.setProfesion_id(rs.getInt(1));
                objEP.setFecha_obtencion(rs.getDate(2));
                objEP.setCategoria_profesion_id(rs.getInt(3));
                objEP.setPostulante_id(rs.getInt(4));
                objEP.setUniversidad_id(rs.getInt(5));
                objEP.setDescripcion_formal(rs.getString(6));
                objEP.setUrl_archivo(rs.getString(7));
            }
            objC.desconectarBD();
            return objEP;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertarProfesion(String fecha) throws Exception {
        try {

            String fechad = fecha.replace("/", "-");
            String dia = fechad.substring(0, 2);
            String mes = fechad.substring(3, 5);
            String ano = fechad.substring(6, 10);
            String fechaO = ano + "-" + mes + "-" + dia;

            SQL = "insert into dbo.Postulante_profesion(fecha_obtencion, categoria_profesion_categoria, postulante_postulante_id, universidad_universidad_id, descripcion_formal, grado_academico_grado_id, url_archivo) values('" + fechaO + "', " + super.getCategoria_profesion_id() + ", " + super.getPostulante_id() + ", " + super.getUniversidad_id() + ", '" + super.getDescripcion_formal() + "', " + super.getGrado_academico_id() + ", '" + super.getUrl_archivo() + "')";
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void modificarProfesion() throws Exception {
        try {
            SQL = "update dbo.Postulante_profesion set fecha_obtencion = '" + super.getFecha_obtencion() + "', categoria_profesion_categoria = " + super.getCategoria_profesion_id() + ", postulante_postulante_id = " + super.getPostulante_id() + ", universidad_universidad_id = " + super.getUniversidad_id() + ", descripcion_formal = '" + super.getDescripcion_formal() + "', grado_academico_grado_id = " + super.getGrado_academico_id() + ", url_archivo = '" + super.getUrl_archivo() + "' where detalle_id = " + super.getProfesion_id();
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminarProfesion() throws Exception {
        try {
            SQL = "delete from dbo.Postulante_profesion where detalle_id = " + super.getProfesion_id();
            objC.ejecutarBD(SQL);
            objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void listarProfesion(JTable tblListado) throws Exception {
        try {
            SQL = "select pp.detalle_id, pp.fecha_obtencion, cp.descripcion, (p.apellido_parterno + ' ' + p.apellido_materno + ' ' + p.nombres) as nombre, ga.descripcion_grado from dbo.Postulante_profesion as pp inner join dbo.Categoria_profesion as cp on cp.categoria_id = pp.categoria_profesion_categoria inner join dbo.Postulante as p on p.postulante_id = pp.postulante_postulante_id inner join dbo.Grado_academico as ga on ga.grado_id = pp.grado_academico_grado_id order by 1 asc";
            rs = objC.consultarBD(SQL);

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Fecha");
            modelo.addColumn("Profesión");
            modelo.addColumn("Postulante");
            modelo.addColumn("Grado Academico");

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

    public ResultSet busquedaFiltradaPostulantePorCategoria(String busqueda) throws Exception {
        String filtro = "%" + busqueda + "%";
        SQL = "select pp.detalle_id, pp.fecha_obtencion, cp.descripcion, (p.apellido_parterno + ' ' + p.apellido_materno + ' ' + p.nombres) as nombre, ga.descripcion_grado from dbo.Postulante_profesion as pp inner join dbo.Categoria_profesion as cp on cp.categoria_id = pp.categoria_profesion_categoria inner join dbo.Postulante as p on p.postulante_id = pp.postulante_postulante_id inner join dbo.Grado_academico as ga on ga.grado_id = pp.grado_academico_grado_id where UPPER(cp.descripcion) like UPPER('" + filtro + "')";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ResultSet busquedaFiltradaPostulantePorGrado(String busqueda) throws Exception {
        String filtro = "%" + busqueda + "%";
        SQL = "select pp.detalle_id, pp.fecha_obtencion, cp.descripcion, (p.apellido_parterno + ' ' + p.apellido_materno + ' ' + p.nombres) as nombre, ga.descripcion_grado from dbo.Postulante_profesion as pp inner join dbo.Categoria_profesion as cp on cp.categoria_id = pp.categoria_profesion_categoria inner join dbo.Postulante as p on p.postulante_id = pp.postulante_postulante_id inner join dbo.Grado_academico as ga on ga.grado_id = pp.grado_academico_grado_id where UPPER(ga.descripcion_grado) like UPPER('" + filtro + "')";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
