package com.apirest.backend.Repository;

import com.apirest.backend.Model.ComentarioRespuestaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComentarioRespuestaRepository extends JpaRepository<ComentarioRespuestaModel, Integer> {
    
    // Buscar comentarios por ID de usuario
    List<ComentarioRespuestaModel> findByUsuarioIdUsuario(Integer idUsuario);
    
    // Buscar respuestas de un comentario específico (hilos de conversación)
    List<ComentarioRespuestaModel> findByComentarioRespuestaIdComentarioRespuesta(Integer idComentarioPadre);
    
    // Buscar comentarios principales (que no son respuestas de otros)
    List<ComentarioRespuestaModel> findByComentarioRespuestaIsNull();
    
    // Buscar comentarios por estado de archivo
    List<ComentarioRespuestaModel> findByArchivo2(ComentarioRespuestaModel.EstadoArchivo estadoArchivo);
    
    // Buscar comentarios por fecha de realización
    List<ComentarioRespuestaModel> findByFechaRealizacion(java.time.LocalDate fechaRealizacion);
    
    // Buscar comentarios por rango de fechas
    List<ComentarioRespuestaModel> findByFechaRealizacionBetween(java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin);
    
    // Contar comentarios por usuario
    Long countByUsuarioIdUsuario(Integer idUsuario);
    
    // Contar respuestas de un comentario específico
    Long countByComentarioRespuestaIdComentarioRespuesta(Integer idComentarioPadre);
    
    // Buscar comentarios con calificación no nula
    List<ComentarioRespuestaModel> findByCalificacionIsNotNull();
    
    // Query personalizada para obtener jerarquía completa de comentarios
    @Query("SELECT c FROM ComentarioRespuestaModel c WHERE c.comentarioRespuesta.idComentarioRespuesta = :idComentarioPadre OR c.idComentarioRespuesta = :idComentarioPadre ORDER BY c.fechaRealizacion ASC")
    List<ComentarioRespuestaModel> findComentarioConRespuestas(@Param("idComentarioPadre") Integer idComentarioPadre);
    
    // Query personalizada para obtener comentarios activos
    @Query("SELECT c FROM ComentarioRespuestaModel c WHERE c.archivo2 = 'Activo' ORDER BY c.fechaRealizacion DESC")
    List<ComentarioRespuestaModel> findComentariosActivos();
}