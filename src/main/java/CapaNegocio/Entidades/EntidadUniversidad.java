package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadUniversidad {
    
    private int universidad_id, pais_id;
    private String nombre_universidad;
    
    public EntidadUniversidad(){
        
    }

    public EntidadUniversidad(int universidad_id, int pais_id, String nombre_universidad) {
        this.universidad_id = universidad_id;
        this.pais_id = pais_id;
        this.nombre_universidad = nombre_universidad;
    }

    public int getUniversidad_id() {
        return universidad_id;
    }

    public void setUniversidad_id(int universidad_id) {
        this.universidad_id = universidad_id;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }
    
    @Override
    public String toString(){
        return nombre_universidad;
    }
    
}
