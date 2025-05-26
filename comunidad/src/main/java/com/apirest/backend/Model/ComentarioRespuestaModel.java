package com.apirest.backend.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ComentarioRespuesta")
public class ComentarioRespuestaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentarioRespuesta;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String justificacion;

    @Column(columnDefinition = "TEXT")
    private String calificacion;

    @Column(nullable = false)
    private String archivo;

    @Column(nullable = false)
    private LocalDate fechaRealizacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;

    //permite que un comentario sea respuesta de otro comentario
    @ManyToOne
    @JoinColumn(name = "idComentarioRespuesta", referencedColumnName = "idComentarioRespuesta")
    private ComentarioRespuestaModel comentarioRespuesta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoArchivo archivo2;

    //permite activar/desactivar archivos sin eliminarlos
    public enum EstadoArchivo {
        Activo, Inactivo
    }

    //CONSTRUCTORES
    public ComentarioRespuestaModel() {}

    public ComentarioRespuestaModel(Integer idComentarioRespuesta, String justificacion, String calificacion,
                                   String archivo, LocalDate fechaRealizacion, UsuarioModel usuario,
                                   ComentarioRespuestaModel comentarioRespuesta, EstadoArchivo archivo2) {
        this.idComentarioRespuesta = idComentarioRespuesta;
        this.justificacion = justificacion;
        this.calificacion = calificacion;
        this.archivo = archivo;
        this.fechaRealizacion = fechaRealizacion;
        this.usuario = usuario;
        this.comentarioRespuesta = comentarioRespuesta;
        this.archivo2 = archivo2;
    }

    //GETTERS Y SETTERS
    public Integer getIdComentarioRespuesta() {
        return idComentarioRespuesta;
    }

    public void setIdComentarioRespuesta(Integer idComentarioRespuesta) {
        this.idComentarioRespuesta = idComentarioRespuesta;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ComentarioRespuestaModel getComentarioRespuesta() {
        return comentarioRespuesta;
    }

    public void setComentarioRespuesta(ComentarioRespuestaModel comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }

    public EstadoArchivo getArchivo2() {
        return archivo2;
    }

    public void setArchivo2(EstadoArchivo archivo2) {
        this.archivo2 = archivo2;
    }
}