package com.apirest.backend.Controller;

import com.apirest.backend.Model.EvidenciaModel;
import com.apirest.backend.Service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidencias")
public class EvidenciaController {

    @Autowired
    private EvidenciaService evidenciaService;

    @GetMapping
    public ResponseEntity<List<EvidenciaModel>> obtenerTodas() {
        return ResponseEntity.ok(evidenciaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvidenciaModel> obtenerPorId(@PathVariable Integer id) {
        return evidenciaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/solicitud/{idSolicitud}")
    public ResponseEntity<List<EvidenciaModel>> obtenerPorSolicitud(@PathVariable Integer idSolicitud) {
        return ResponseEntity.ok(evidenciaService.obtenerPorSolicitud(idSolicitud));
    }

    @PostMapping
    public ResponseEntity<EvidenciaModel> crearEvidencia(@RequestBody EvidenciaModel evidencia) {
        return ResponseEntity.ok(evidenciaService.crearEvidencia(evidencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvidenciaModel> actualizarEvidencia(@PathVariable Integer id, @RequestBody EvidenciaModel evidencia) {
        return ResponseEntity.ok(evidenciaService.actualizarEvidencia(id, evidencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvidencia(@PathVariable Integer id) {
        evidenciaService.eliminarEvidencia(id);
        return ResponseEntity.noContent().build();
    }
}