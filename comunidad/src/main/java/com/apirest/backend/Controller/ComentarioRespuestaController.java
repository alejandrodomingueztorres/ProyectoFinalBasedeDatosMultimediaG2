package com.apirest.backend.Controller;

import com.apirest.backend.Model.ComentarioRespuestaModel;
import com.apirest.backend.Service.ComentarioRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioRespuestaController {

    @Autowired
    private ComentarioRespuestaService comentarioRespuestaService;

    // Obtener todos los comentarios
    @GetMapping
    public ResponseEntity<List<ComentarioRespuestaModel>> obtenerTodos() {
        return ResponseEntity.ok(comentarioRespuestaService.obtenerTodos());
    }

    // Obtener comentario por ID
    @GetMapping("/{id}")
    public ResponseEntity<ComentarioRespuestaModel> obtenerPorId(@PathVariable Integer id) {
        return comentarioRespuestaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener comentarios por ID de usuario
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ComentarioRespuestaModel>> obtenerPorUsuario(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(comentarioRespuestaService.obtenerPorUsuario(idUsuario));
    }

    // Obtener respuestas de un comentario (por ID de comentario padre)
    @GetMapping("/respuestas/{idComentarioPadre}")
    public ResponseEntity<List<ComentarioRespuestaModel>> obtenerRespuestasDeComentario(@PathVariable Integer idComentarioPadre) {
        return ResponseEntity.ok(comentarioRespuestaService.obtenerRespuestasDeComentario(idComentarioPadre));
    }

    // Obtener comentarios principales (sin comentario padre)
    @GetMapping("/principales")
    public ResponseEntity<List<ComentarioRespuestaModel>> obtenerComentariosPrincipales() {
        return ResponseEntity.ok(comentarioRespuestaService.obtenerComentariosPrincipales());
    }

    // Crear un nuevo comentario
    @PostMapping
    public ResponseEntity<ComentarioRespuestaModel> crearComentario(@RequestBody ComentarioRespuestaModel comentario) {
        return ResponseEntity.ok(comentarioRespuestaService.crearComentario(comentario));
    }

    // Actualizar comentario existente
    @PutMapping("/{id}")
    public ResponseEntity<ComentarioRespuestaModel> actualizarComentario(
            @PathVariable Integer id,
            @RequestBody ComentarioRespuestaModel comentario) {
        return ResponseEntity.ok(comentarioRespuestaService.actualizarComentario(id, comentario));
    }

    // Eliminar comentario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Integer id) {
        comentarioRespuestaService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }
}
