package CapaNegocio.Entidades;

import java.io.InputStream;

/**
 *
 * @author Rodrigo Ruidias
 */
public class EntidadIdioma {

    private int idioma_id, postulante_id;
    private String idioma, nivel, link_archivo;

    public EntidadIdioma() {

    }

    public EntidadIdioma(int idioma_id, int postulante_id, String idioma, String nivel, String link_archivo) {
        this.idioma_id = idioma_id;
        this.postulante_id = postulante_id;
        this.idioma = idioma;
        this.nivel = nivel;
        this.link_archivo = link_archivo;
    }

    public int getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(int idioma_id) {
        this.idioma_id = idioma_id;
    }

    public int getPostulante_id() {
        return postulante_id;
    }

    public void setPostulante_id(int postulante_id) {
        this.postulante_id = postulante_id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getLink_archivo() {
        return link_archivo;
    }

    public void setLink_archivo(String link_archivo) {
        this.link_archivo = link_archivo;
    }  

    @Override
    public String toString() {
        return idioma;
    }

}
