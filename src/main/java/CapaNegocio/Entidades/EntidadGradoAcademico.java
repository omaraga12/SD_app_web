package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadGradoAcademico {

    private int grado_id;
    private String descripcion_grado;

    public EntidadGradoAcademico() {

    }

    public EntidadGradoAcademico(int grado_id, String descripcion_grado) {
        this.grado_id = grado_id;
        this.descripcion_grado = descripcion_grado;
    }

    public int getGrado_id() {
        return grado_id;
    }

    public void setGrado_id(int grado_id) {
        this.grado_id = grado_id;
    }

    public String getDescripcion_grado() {
        return descripcion_grado;
    }

    public void setDescripcion_grado(String descripcion_grado) {
        this.descripcion_grado = descripcion_grado;
    }

    @Override
    public String toString() {
        return descripcion_grado;
    }

}
