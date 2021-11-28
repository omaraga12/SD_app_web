package CapaNegocio;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadEmpresa;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Empresa extends EntidadEmpresa{
    conexion objC;
    String SQL;
    ResultSet rs = null;
    
    public Empresa() {
        objC = new conexion();
    }
    
    public int verificarLogin(String ruc, String contraseña) throws Exception {
        int rpt=0;
        try {
            
            SQL = "select * from empresa where ruc = '"+ruc+"' and contraseña='"+contraseña+"'";
            rs = objC.consultarBD(SQL);
            if (rs.next()) {
                rpt=rs.getInt(1);
            }
           objC.desconectarBD();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return rpt;
    }
    
    public void listarEmpresa(JTable tblListado) throws Exception {
        try {
            SQL = "select e.empresa_id, e.nombre_empresa, e.tipo_empresa, e.ruc, pa.nombre_pais from dbo.Empresa as e inner join dbo.Pais as pa on pa.pais_id = e.pais_pais_id order by 2, 3 asc";
            rs = objC.consultarBD(SQL);
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo");
            modelo.addColumn("RUC");
            modelo.addColumn("Pais");
            
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
    
    public ResultSet busquedaFiltradaEmpresaPorNombre( String busqueda) throws Exception{
        String filtro="%"+busqueda+"%";
        SQL="select e.empresa_id, e.nombre_empresa, e.tipo_empresa, e.ruc, pa.nombre_pais from dbo.Empresa as e inner join dbo.Pais as pa on pa.pais_id = e.pais_pais_id where UPPER(e.nombre_empresa) like UPPER('"+filtro+"')";
        try {
            rs=objC.consultarBD(SQL);
            return rs;
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public ResultSet busquedaFiltradaEmpresaPorTipo( String busqueda) throws Exception{
        String filtro="%"+busqueda+"%";
        SQL="select e.empresa_id, e.nombre_empresa, e.tipo_empresa, e.ruc, pa.nombre_pais from dbo.Empresa as e inner join dbo.Pais as pa on pa.pais_id = e.pais_pais_id where UPPER(e.tipo_empresa) like UPPER('"+filtro+"')";
        try {
            rs=objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public ArrayList<EntidadEmpresa> llenarEmpresas() throws Exception{
        try {
            ArrayList<EntidadEmpresa> empresas = new ArrayList<EntidadEmpresa>();
            SQL = "select * from dbo.Empresa";
            rs = objC.consultarBD(SQL);
            while(rs.next()){
                EntidadEmpresa objEE = new EntidadEmpresa();
                objEE.setEmpresa_id(rs.getInt(1));
                objEE.setNombre_empresa(rs.getString(2));
                objEE.setTipo_empresa(rs.getString(3));
                objEE.setRuc(rs.getString(4));
                objEE.setPais_id(rs.getInt(5));
                empresas.add(objEE);
            }
            objC.desconectarBD();
            return empresas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public ResultSet consultarEmpresa() throws Exception{
        SQL = "select nombre_empresa from Empresa";
        try {
            rs=objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
