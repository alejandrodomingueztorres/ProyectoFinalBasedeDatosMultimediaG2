package com.apirest.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.backend.Model.SolicitudModel;

@Repository
public interface SolicitudRepository extends JpaRepository<SolicitudModel, Integer> {
    // Puedes agregar métodos personalizados si los necesitas
}