package com.apirest.backend.Model;

import java.time.LocalDateTime;

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

    @Column(columnDefinition = "TEXT")
    private String justificacion;

    @Column
    private Integer calificacion;

    @Column
    private String archivo;

    @Column(nullable = false)
    private LocalDateTime fechaRealizacion;

    @ManyToOne
    @JoinColumn(name = "idSolicitud", nullable = false)
    private SolicitudModel solicitud;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idComentarioPadre", referencedColumnName = "idComentarioRespuesta")
    private ComentarioRespuestaModel comentarioPadre;

    public enum EstadoArchivo {
        Activo, Inactivo
    }

    @Enumerated(EnumType.STRING)
    private EstadoArchivo estadoArchivo;

    // CONSTRUCTORES
    public ComentarioRespuestaModel() {}

    public ComentarioRespuestaModel(Integer idComentarioRespuesta, String justificacion, Integer calificacion,
                                    String archivo, LocalDateTime fechaRealizacion, SolicitudModel solicitud,
                                    UsuarioModel usuario, ComentarioRespuestaModel comentarioPadre,
                                    EstadoArchivo estadoArchivo) {
        this.idComentarioRespuesta = idComentarioRespuesta;
        this.justificacion = justificacion;
        this.calificacion = calificacion;
        this.archivo = archivo;
        this.fechaRealizacion = fechaRealizacion;
        this.solicitud = solicitud;
        this.usuario = usuario;
        this.comentarioPadre = comentarioPadre;
        this.estadoArchivo = estadoArchivo;
    }

    // GETTERS Y SETTERS
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

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public LocalDateTime getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public SolicitudModel getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudModel solicitud) {
        this.solicitud = solicitud;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ComentarioRespuestaModel getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(ComentarioRespuestaModel comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }

    public EstadoArchivo getEstadoArchivo() {
        return estadoArchivo;
    }

    public void setEstadoArchivo(EstadoArchivo estadoArchivo) {
        this.estadoArchivo = estadoArchivo;
    }
}
