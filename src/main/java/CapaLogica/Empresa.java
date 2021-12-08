package CapaLogica;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadEmpresa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo Ruidias
 */
public class Empresa extends EntidadEmpresa{
    conexion objC;
    String SQL;
    ResultSet rs = null;
    public static void main(String[] args) {
               
        try {
            Empresa obj= new Empresa();
            obj.insertarEmpresa("Dubbie", "SAC","10734169471","1","logo.png");
            
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
    }
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
  

 public int insertarEmpresa(String nombre, String tipo, String ruc, String id_pais, String imagen) throws Exception {
        try {
            SQL = "insert into empresa(nombre_empresa, tipo_empresa, ruc, pais_pais_id, imagen) values"
                    + "('" +nombre+ "', '" +tipo+ "', '" +ruc+ "', '" +id_pais+ "', '" +imagen+ "')";
            objC.ejecutarBD(SQL);
            String SQL2 = "select IDENT_CURRENT('empresa') [empresa_id]";
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
        
 

 
 
}
