package com.apirest.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.backend.Model.SolicitudModel;
import com.apirest.backend.Repository.SolicitudRepository;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public SolicitudModel crearSolicitud(SolicitudModel solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public List<SolicitudModel> listarSolicitudes() {
        return solicitudRepository.findAll();
    }

    public Optional<SolicitudModel> obtenerSolicitudPorId(Integer id) {
        return solicitudRepository.findById(id);
    }

    public SolicitudModel actualizarSolicitud(Integer id, SolicitudModel nuevaSolicitud) {
        return solicitudRepository.findById(id).map(solicitud -> {
            solicitud.setTipoSolicitud(nuevaSolicitud.getTipoSolicitud());
            solicitud.setDescripcionSolicitud(nuevaSolicitud.getDescripcionSolicitud());
            solicitud.setCategoria(nuevaSolicitud.getCategoria());
            solicitud.setEstadoSolicitud(nuevaSolicitud.getEstadoSolicitud());
            solicitud.setFechaCreacion(nuevaSolicitud.getFechaCreacion());
            solicitud.setHoraCreacion(nuevaSolicitud.getHoraCreacion());
            solicitud.setFechaUltActua(nuevaSolicitud.getFechaUltActua());
            solicitud.setUsuario(nuevaSolicitud.getUsuario());
            return solicitudRepository.save(solicitud);
        }).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    public void eliminarSolicitud(Integer id) {
        solicitudRepository.deleteById(id);
    }
}