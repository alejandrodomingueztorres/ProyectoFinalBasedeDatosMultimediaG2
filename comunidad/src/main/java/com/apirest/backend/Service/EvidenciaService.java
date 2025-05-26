package com.apirest.backend.Service;

import com.apirest.backend.Model.EvidenciaModel;
import com.apirest.backend.Repository.EvidenciaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EvidenciaService {
    
    private final EvidenciaRepository evidenciaRepository;
    
    public EvidenciaService(EvidenciaRepository evidenciaRepository) {
        this.evidenciaRepository = evidenciaRepository;
    }
    
    public EvidenciaModel crearEvidencia(EvidenciaModel evidencia) {
        return evidenciaRepository.save(evidencia);
    }
    
    public List<EvidenciaModel> obtenerTodas() {
        return evidenciaRepository.findAll();
    }
    
    public Optional<EvidenciaModel> obtenerPorId(Integer id) {
        return evidenciaRepository.findById(id);
    }
    
    public List<EvidenciaModel> obtenerPorSolicitud(Integer idSolicitud) {
        return evidenciaRepository.findBySolicitudIdSolicitud(idSolicitud);
    }
    
    public EvidenciaModel actualizarEvidencia(Integer id, EvidenciaModel nuevaEvidencia) {
        return evidenciaRepository.findById(id).map(evidencia -> {
            evidencia.setTipoArchivo(nuevaEvidencia.getTipoArchivo());
            evidencia.setDescripcionOpcional(nuevaEvidencia.getDescripcionOpcional());
            evidencia.setFechaCarga(nuevaEvidencia.getFechaCarga());
            evidencia.setHoraCarga(nuevaEvidencia.getHoraCarga());
            evidencia.setSolicitud(nuevaEvidencia.getSolicitud());
            evidencia.setArchivo(nuevaEvidencia.getArchivo());
            return evidenciaRepository.save(evidencia);
        }).orElseThrow(() -> new RuntimeException("Evidencia no encontrada"));
    }
    
    public void eliminarEvidencia(Integer id) {
        evidenciaRepository.deleteById(id);
    }
}
