package CapaNegocio.Entidades;

import java.util.Date;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadExperienciaLaboral {
    
    private int experiencia_id, postulante_id, empresa_id;
    private Date fecha_inicio, fecha_final;
    private String link_archivo, cargo;
    
    public EntidadExperienciaLaboral(){
        
    }

    public EntidadExperienciaLaboral(int experiencia_id, int postulante_id, int empresa_id, Date fecha_inicio, Date fecha_final, String link_archivo, String cargo) {
        this.experiencia_id = experiencia_id;
        this.postulante_id = postulante_id;
        this.empresa_id = empresa_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.link_archivo = link_archivo;
        this.cargo = cargo;
    }

    public int getExperiencia_id() {
        return experiencia_id;
    }

    public void setExperiencia_id(int experiencia_id) {
        this.experiencia_id = experiencia_id;
    }

    public int getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(int postulante_id) {
        this.postulante_id = postulante_id;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getLink_archivo() {
        return link_archivo;
    }

    public void setLink_archivo(String link_archivo) {
        this.link_archivo = link_archivo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return cargo;
    }
    
}
