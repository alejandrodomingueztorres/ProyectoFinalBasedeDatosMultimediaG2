package com.apirest.backend.Service;

import com.apirest.backend.Model.ComentarioRespuestaModel;
import com.apirest.backend.Repository.ComentarioRespuestaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioRespuestaService {
    
    private final ComentarioRespuestaRepository comentarioRespuestaRepository;
    
    public ComentarioRespuestaService(ComentarioRespuestaRepository comentarioRespuestaRepository) {
        this.comentarioRespuestaRepository = comentarioRespuestaRepository;
    }
    
    public ComentarioRespuestaModel crearComentario(ComentarioRespuestaModel comentario) {
        return comentarioRespuestaRepository.save(comentario);
    }
    
    public List<ComentarioRespuestaModel> obtenerTodos() {
        return comentarioRespuestaRepository.findAll();
    }
    
    public Optional<ComentarioRespuestaModel> obtenerPorId(Integer id) {
        return comentarioRespuestaRepository.findById(id);
    }
    
    public List<ComentarioRespuestaModel> obtenerPorUsuario(Integer idUsuario) {
        return comentarioRespuestaRepository.findByUsuarioIdUsuario(idUsuario);
    }
    
    public List<ComentarioRespuestaModel> obtenerRespuestasDeComentario(Integer idComentarioPadre) {
        return comentarioRespuestaRepository.findByComentarioPadreIdComentarioRespuesta(idComentarioPadre);
    }
    
    public List<ComentarioRespuestaModel> obtenerComentariosPrincipales() {
        return comentarioRespuestaRepository.findByComentarioPadreIsNull();
    }
    
    public ComentarioRespuestaModel actualizarComentario(Integer id, ComentarioRespuestaModel nuevoComentario) {
        return comentarioRespuestaRepository.findById(id).map(comentario -> {
            comentario.setJustificacion(nuevoComentario.getJustificacion());
            comentario.setCalificacion(nuevoComentario.getCalificacion());
            comentario.setArchivo(nuevoComentario.getArchivo());
            comentario.setFechaRealizacion(nuevoComentario.getFechaRealizacion());
            comentario.setUsuario(nuevoComentario.getUsuario());
            comentario.setComentarioPadre(nuevoComentario.getComentarioPadre());
            comentario.setEstadoArchivo(nuevoComentario.getEstadoArchivo());
            comentario.setSolicitud(nuevoComentario.getSolicitud());
            return comentarioRespuestaRepository.save(comentario);
        }).orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }
    
    public void eliminarComentario(Integer id) {
        comentarioRespuestaRepository.deleteById(id);
    }
}

