package CapaNegocio.Entidades;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadFuncionesEmpresa {
    
    private int actividad_id, experiencia_laboral_id;
    private String descripcion_actividad;
    
    public EntidadFuncionesEmpresa(){
        
    }

    public EntidadFuncionesEmpresa(int actividad_id, int experiencia_laboral_id, String descripcion_actividad) {
        this.actividad_id = actividad_id;
        this.experiencia_laboral_id = experiencia_laboral_id;
        this.descripcion_actividad = descripcion_actividad;
    }

    public int getActividad_id() {
        return actividad_id;
    }

    public void setActividad_id(int actividad_id) {
        this.actividad_id = actividad_id;
    }

    public int getExperiencia_laboral_id() {
        return experiencia_laboral_id;
    }

    public void setExperiencia_laboral_id(int experiencia_laboral_id) {
        this.experiencia_laboral_id = experiencia_laboral_id;
    }

    public String getDescripcion_actividad() {
        return descripcion_actividad;
    }

    public void setDescripcion_actividad(String descripcion_actividad) {
        this.descripcion_actividad = descripcion_actividad;
    }
    
    @Override
    public String toString() {
        return descripcion_actividad;
    }
    
}
