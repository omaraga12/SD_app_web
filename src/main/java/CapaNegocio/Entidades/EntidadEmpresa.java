package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadEmpresa {
    
    private int empresa_id, pais_id;
    private String nombre_empresa, tipo_empresa, ruc;
    
    public EntidadEmpresa(){
        
    }

    public EntidadEmpresa(int empresa_id, int pais_id, String nombre_empresa, String tipo_empresa, String ruc) {
        this.empresa_id = empresa_id;
        this.pais_id = pais_id;
        this.nombre_empresa = nombre_empresa;
        this.tipo_empresa = tipo_empresa;
        this.ruc = ruc;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    
    @Override
    public String toString(){
        return nombre_empresa;
    }
    
    
}
