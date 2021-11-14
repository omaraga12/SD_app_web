package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadCategoriaProfesion {
    
    private int categoria_id;
    private String descripcion;
    
    public EntidadCategoriaProfesion(){
        
    }

    public EntidadCategoriaProfesion(int categoria_id, String descripcion) {
        this.categoria_id = categoria_id;
        this.descripcion = descripcion;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return descripcion;
    }
    
}
