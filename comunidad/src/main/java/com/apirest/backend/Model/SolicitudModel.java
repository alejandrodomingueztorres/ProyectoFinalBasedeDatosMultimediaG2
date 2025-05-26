package com.apirest.backend.Model;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "Solicitud")
public class SolicitudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSolicitud tipoSolicitud;

    @Column(columnDefinition = "TEXT")
    private String descripcionSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSolicitud estadoSolicitud;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @Column(nullable = false)
    private LocalTime horaCreacion;

    @Column(nullable = false)
    private LocalDate fechaUltActua;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;

    // --------- ENUMS ---------
    public enum TipoSolicitud {
        Peticion, Queja, Reclamo, Sugerencia
    }

    public enum Categoria {
        Servicios_generales("Servicios generales"),
        Seguridad("Seguridad"),
        Areas_comunes("Areas comunes");

        private final String value;
        Categoria(String value) { this.value = value; }
        @Override
        public String toString() { return value; }
    }

    public enum EstadoSolicitud {
        Radicada("Radicada"),
        En_proceso("En proceso"),
        Resuelta("Resuelta"),
        Cerrada("Cerrada"),
        Reabierta("Reabierta");

        private final String value;
        EstadoSolicitud(String value) { this.value = value; }
        @Override
        public String toString() { return value; }
    }

    // --------- CONSTRUCTORES ---------
    public SolicitudModel() {}

    public SolicitudModel(Categoria categoria, String descripcionSolicitud, EstadoSolicitud estadoSolicitud,
                          LocalDate fechaCreacion, LocalDate fechaUltActua, LocalTime horaCreacion,
                          Integer idSolicitud, TipoSolicitud tipoSolicitud, UsuarioModel usuario) {
        this.categoria = categoria;
        this.descripcionSolicitud = descripcionSolicitud;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltActua = fechaUltActua;
        this.horaCreacion = horaCreacion;
        this.idSolicitud = idSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.usuario = usuario;
    }

    // --------- GETTERS Y SETTERS ---------
    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    public void setDescripcionSolicitud(String descripcionSolicitud) {
        this.descripcionSolicitud = descripcionSolicitud;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public LocalDate getFechaUltActua() {
        return fechaUltActua;
    }

    public void setFechaUltActua(LocalDate fechaUltActua) {
        this.fechaUltActua = fechaUltActua;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}