/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaDatos.conexion;
import CapaNegocio.Entidades.EntidadRequisitos;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Requisito {
    conexion objC;
    String SQL;
    ResultSet rs = null;
    
    public Requisito() {
        objC = new conexion();
    }
    
    public ArrayList<EntidadRequisitos> llenarRequisitos() throws Exception{
        try {
           ArrayList<EntidadRequisitos> requisitos = new ArrayList<EntidadRequisitos>();
           SQL = "select * from requisito";
           rs = objC.consultarBD(SQL);
           while(rs.next()){
               EntidadRequisitos objEP = new EntidadRequisitos();
               objEP.setIdRequito(rs.getInt(1));
               objEP.setNombre(rs.getString(2));
               requisitos.add(objEP);
           }
           objC.desconectarBD();
           return requisitos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
