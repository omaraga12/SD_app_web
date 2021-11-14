package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadUbigeo {
    
    private int ubigeo_id;
    private String distrito, provincia, departamento;
    
    public EntidadUbigeo(){
        
    }

    public EntidadUbigeo(int ubigeo_id, String distrito, String provincia, String departamento) {
        this.ubigeo_id = ubigeo_id;
        this.distrito = distrito;
        this.provincia = provincia;
        this.departamento = departamento;
    }

    public int getUbigeo_id() {
        return ubigeo_id;
    }

    public void setUbigeo_id(int ubigeo_id) {
        this.ubigeo_id = ubigeo_id;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
}
