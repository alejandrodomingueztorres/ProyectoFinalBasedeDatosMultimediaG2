package com.apirest.backend.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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

@Entity
@Table(name = "Evidencia")
public class EvidenciaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvidencia;

    @Column(nullable = false)
    private String tipoArchivo;

    @Column(columnDefinition = "TEXT")
    private String descripcionOpcional;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaCarga;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date horaCarga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSolicitud", nullable = false)
    private SolicitudModel solicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoArchivo archivo;

    public enum TipoArchivo {
        PDF, Imagen, Video, Audio
    }

    // Constructores
    public EvidenciaModel() {}

    // Getters y Setters
    public Integer getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getDescripcionOpcional() {
        return descripcionOpcional;
    }

    public void setDescripcionOpcional(String descripcionOpcional) {
        this.descripcionOpcional = descripcionOpcional;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Date getHoraCarga() {
        return horaCarga;
    }

    public void setHoraCarga(Date horaCarga) {
        this.horaCarga = horaCarga;
    }

    public SolicitudModel getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudModel solicitud) {
        this.solicitud = solicitud;
    }

    public TipoArchivo getArchivo() {
        return archivo;
    }

    public void setArchivo(TipoArchivo archivo) {
        this.archivo = archivo;
    }
}