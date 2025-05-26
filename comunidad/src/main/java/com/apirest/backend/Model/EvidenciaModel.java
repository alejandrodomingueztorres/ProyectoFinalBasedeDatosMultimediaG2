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
@Table(name = "Evidencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}