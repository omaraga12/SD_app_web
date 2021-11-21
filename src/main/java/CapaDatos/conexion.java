package CapaDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Ruidias
 */
public class conexion {
    private String driver,url,user,password;
    private Connection con;
    private Statement sent=null;
    private CallableStatement cs;

    //Constructor
    public conexion() {
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String servidor="database-2.cfhzxl8ixjw6.us-west-1.rds.amazonaws.com";
        String servidor="SQL5103.site4now.net";
        this.url = "jdbc:sqlserver://"+servidor+":1433;databaseName=db_a7b1bc_proyectosd";
        //this.user = "masteruser";
        this.user = "db_a7b1bc_proyectosd_admin";
        //this.password = "abc123456789";
        this.password = "admin123456789";
        this.con = null;
    }
    public  void main(String[] args) throws Exception {
       conectarBD(); 
    }
    //Conectar a BD
    public void conectarBD() throws Exception{
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, password);
            //System.err.println(con);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception ("Error al conectar la BD..."+e);
        }
            
    }
    
    //Consultar estado de la conexión
    public boolean getEstado() throws SQLException {
        return this.con.isClosed();
    }
    
    //07 Abril 2021
    
    //Desconectar de la BD
    public void desconectarBD() throws Exception{
        try {
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al desconectar de la BD.");
        }
    }
    
    //Ejecutar consultas a la BD:  SELECT - Función
    public ResultSet consultarBD(String strSQL) throws Exception{
        ResultSet rs=null;
        try {
            conectarBD();
            sent = con.createStatement();
            rs=sent.executeQuery(strSQL);
            
            return rs;
            
        } catch (Exception e) {
            
            throw new Exception ("Error al ejecutar consulta..."+e);
        }
       
        
    }
    
    //Ejecutar inserta/elimina/modifica base de datos: INSERT, UPDATE y DELETE - Procedimientos
    public void ejecutarBD (String strSQL) throws Exception{
        try {
            conectarBD();
            sent = con.createStatement();
            sent.executeUpdate(strSQL);
        } catch (Exception e) {
            System.err.println("Error al ejecutar consulta..."+e);
        } 
    }
    
    public void ejecutarBDTransacciones(String strSQL1, String strSQL2, String strSQL3,String strSQL4) throws Exception{
        try {
            conectarBD();
            con.setAutoCommit(false);
            sent=con.createStatement();
            sent.executeUpdate(strSQL1);
            sent.executeUpdate(strSQL2);
            sent.executeUpdate(strSQL3);
            sent.executeUpdate(strSQL4);
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            con.rollback();
            throw new Exception("Error al ejecutar consultas..."+e);
        }
    }
    
    //Ejecuta un arreglo de sentencias (cadenas)
    public void ejecutarBDTransacciones(ArrayList arregloConsultas) throws Exception{
        try {
            conectarBD();
            con.setAutoCommit(false);
            sent=con.createStatement();
            for(Object consulta:arregloConsultas){
                sent.executeUpdate((String)consulta);
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            con.rollback();
            throw new Exception("Error al ejecutar consultas..."+e);
        }
    }
    
    public ResultSet consultarBD_PA(String strSQL) throws Exception{
        ResultSet rs=null;
        try {
            conectarBD();
            cs = con.prepareCall(strSQL);
            rs = cs.executeQuery();
            //cs.setInt(1,55);
            //cs.registerOutParameter(1, java.sql.Types.INTEGER);
            //Integer i= cs.getInt(1);
            return rs;
        } catch (Exception e) {
            throw new Exception ("Error al ejecutar consulta con PA..."+e);
        } 
    }

   public Connection getCon() {
        return con;
    }
   
      public void ejecutarBDTransaccionesRM(String ...consultas) throws Exception {
        try {
            conectarBD();
            con.setAutoCommit(false);
            sent = con.createStatement();
            for (Object consulta : consultas) {
                sent.executeUpdate((String) consulta);
            }
            con.commit();
            con.setAutoCommit(true);
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new Exception("Error al ejecutar consulta..."+e);
            // throw new Exception(e.getMessage());
        } 
    } 
}
