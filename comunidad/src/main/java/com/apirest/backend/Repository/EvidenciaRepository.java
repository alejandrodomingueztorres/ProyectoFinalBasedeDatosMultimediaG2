package com.apirest.backend.Repository;

import com.apirest.backend.Model.EvidenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvidenciaRepository extends JpaRepository<EvidenciaModel, Integer> {
    
    // Buscar evidencias por ID de solicitud
    List<EvidenciaModel> findBySolicitudIdSolicitud(Integer idSolicitud);
    
    // Buscar evidencias por tipo de archivo
    List<EvidenciaModel> findByArchivo(EvidenciaModel.TipoArchivo tipoArchivo);
    
    // Buscar evidencias por fecha de carga
    List<EvidenciaModel> findByFechaCarga(java.time.LocalDate fechaCarga);
    
    // Buscar evidencias por rango de fechas
    List<EvidenciaModel> findByFechaCargaBetween(java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin);
    
    // Contar evidencias por solicitud
    Long countBySolicitudIdSolicitud(Integer idSolicitud);
    
    // Verificar si existe evidencia para una solicitud específica
    boolean existsBySolicitudIdSolicitud(Integer idSolicitud);
}
