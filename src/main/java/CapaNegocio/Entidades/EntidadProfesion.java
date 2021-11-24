package CapaNegocio.Entidades;

import java.util.Date;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadProfesion {
    
    private int profesion_id, categoria_profesion_id, postulante_id, universidad_id, grado_academico_id;
    private String descripcion_formal, url_archivo;
    private Date fecha_obtencion;
    
    public EntidadProfesion(){
        
    }

    public EntidadProfesion(int profesion_id, int categoria_profesion_id, int postulante_id, int universidad_id, int grado_academico_id, String descripcion_formal, String url_archivo, Date fecha_obtencion) {
        this.profesion_id = profesion_id;
        this.categoria_profesion_id = categoria_profesion_id;
        this.postulante_id = postulante_id;
        this.universidad_id = universidad_id;
        this.grado_academico_id = grado_academico_id;
        this.descripcion_formal = descripcion_formal;
        this.url_archivo = url_archivo;
        this.fecha_obtencion = fecha_obtencion;
    }

    public int getProfesion_id() {
        return profesion_id;
    }

    public void setProfesion_id(int profesion_id) {
        this.profesion_id = profesion_id;
    }

    public int getCategoria_profesion_id() {
        return categoria_profesion_id;
    }

    public void setCategoria_profesion_id(int categoria_profesion_id) {
        this.categoria_profesion_id = categoria_profesion_id;
    }

    public int getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(int postulante_id) {
        this.postulante_id = postulante_id;
    }

    public int getUniversidad_id() {
        return universidad_id;
    }

    public void setUniversidad_id(int universidad_id) {
        this.universidad_id = universidad_id;
    }

    public int getGrado_academico_id() {
        return grado_academico_id;
    }

    public void setGrado_academico_id(int grado_academico_id) {
        this.grado_academico_id = grado_academico_id;
    }

    public String getDescripcion_formal() {
        return descripcion_formal;
    }

    public void setDescripcion_formal(String descripcion_formal) {
        this.descripcion_formal = descripcion_formal;
    }

    public String getUrl_archivo() {
        return url_archivo;
    }

    public void setUrl_archivo(String url_archivo) {
        this.url_archivo = url_archivo;
    }

    public Date getFecha_obtencion() {
        return fecha_obtencion;
    }

    public void setFecha_obtencion(Date fecha_obtencion) {
        this.fecha_obtencion = fecha_obtencion;
    }

    

    
}
