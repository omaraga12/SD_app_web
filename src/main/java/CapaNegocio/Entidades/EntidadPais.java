package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadPais {

    private int pais_id;
    private String nombre_pais;

    public EntidadPais() {

    }

    public EntidadPais(int pais_id, String nombre_pais) {
        this.pais_id = pais_id;
        this.nombre_pais = nombre_pais;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    @Override
    public String toString() {
        return nombre_pais;
    }

}
