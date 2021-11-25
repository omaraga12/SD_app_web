/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaLogica;

import CapaDatos.conexion;
import java.sql.ResultSet;

/**
 *
 * @author nickb
 */
public class Requisitos_trabajo {
 
    conexion objC = new conexion();
    String SQL = null;
    ResultSet rs = null;
    
    public ResultSet consultarRequisitosTrabajo(int trabajo_id) throws Exception{
        SQL = "select re.requisito from requisitos_trabajo rt inner join requisito re on rt.requisito_id = re.requisito_id where rt.trabajo_postular_id = "+trabajo_id+"";
        try {
            rs = objC.consultarBD(SQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
