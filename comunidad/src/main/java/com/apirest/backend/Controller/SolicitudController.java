package com.apirest.backend.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.SolicitudModel;
import com.apirest.backend.Service.SolicitudService;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<SolicitudModel> crearSolicitud(@RequestBody SolicitudModel solicitud) {
        SolicitudModel creada = solicitudService.crearSolicitud(solicitud);
        return ResponseEntity.ok(creada);
    }

    @GetMapping
    public ResponseEntity<List<SolicitudModel>> listarSolicitudes() {
        List<SolicitudModel> lista = solicitudService.listarSolicitudes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudModel> obtenerSolicitudPorId(@PathVariable Integer id) {
        return solicitudService.obtenerSolicitudPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudModel> actualizarSolicitud(@PathVariable Integer id, @RequestBody SolicitudModel solicitud) {
        try {
            SolicitudModel actualizada = solicitudService.actualizarSolicitud(id, solicitud);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Integer id) {
        solicitudService.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }
}