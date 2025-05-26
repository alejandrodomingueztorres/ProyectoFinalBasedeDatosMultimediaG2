package com.apirest.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ComentarioRespuesta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaRealizacion;

    // relacion con usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    // esta parte permite que un comentario sea respuesta de otro comentario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idComentarioRespuesta", insertable = false, updatable = false)
    private ComentarioRespuestaModel comentarioRespuesta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoArchivo archivo2;

    // enum para controlar el estado del archivo, deja activar/desactivar archivos sin eliminarlos
    public enum EstadoArchivo {
        Activo, Inactivo
    }
}