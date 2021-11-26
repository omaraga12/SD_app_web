package CapaNegocio.Entidades;

import java.io.InputStream;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadPostulante {

    private int postulante_id, ubigeo_id, pais_id, profesion_categoria, numero_colegiatura;
    private String tipo_documento_id, numero_documento, apellido_paterno, apellido_materno, nombres, contra, link_foto;

    public EntidadPostulante() {

    }

    public EntidadPostulante(int postulante_id, int ubigeo_id, int pais_id, int profesion_categoria, int numero_colegiatura, String tipo_documento_id, String numero_documento, String apellido_paterno, String apellido_materno, String nombres, String contra, String link_foto) {
        this.postulante_id = postulante_id;
        this.ubigeo_id = ubigeo_id;
        this.pais_id = pais_id;
        this.profesion_categoria = profesion_categoria;
        this.numero_colegiatura = numero_colegiatura;
        this.tipo_documento_id = tipo_documento_id;
        this.numero_documento = numero_documento;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.nombres = nombres;
        this.contra = contra;
        this.link_foto = link_foto;
    }

    public int getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(int postulante_id) {
        this.postulante_id = postulante_id;
    }

    public int getUbigeo_id() {
        return ubigeo_id;
    }

    public void setUbigeo_id(int ubigeo_id) {
        this.ubigeo_id = ubigeo_id;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public int getProfesion_categoria() {
        return profesion_categoria;
    }

    public void setProfesion_categoria(int profesion_categoria) {
        this.profesion_categoria = profesion_categoria;
    }

    public int getNumero_colegiatura() {
        return numero_colegiatura;
    }

    public void setNumero_colegiatura(int numero_colegiatura) {
        this.numero_colegiatura = numero_colegiatura;
    }

    public String getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(String tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getLink_foto() {
        return link_foto;
    }

    public void setLink_foto(String link_foto) {
        this.link_foto = link_foto;
    }

    

    @Override
    public String toString() {
        return nombres + " " + apellido_paterno + " " + apellido_materno;
    }
}
