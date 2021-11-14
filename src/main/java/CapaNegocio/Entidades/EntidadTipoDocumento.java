package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadTipoDocumento {
    
    private int tipo_documento_id;
    private String nombre;
    
    public EntidadTipoDocumento(){
        
    }

    public EntidadTipoDocumento(int tipo_documento_id, String nombre) {
        this.tipo_documento_id = tipo_documento_id;
        this.nombre = nombre;
    }

    public int getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(int tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
}
