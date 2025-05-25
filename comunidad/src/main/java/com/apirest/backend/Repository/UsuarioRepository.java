package com.apirest.backend.Repository;

import com.apirest.backend.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    boolean existsByNumeroDocumento(Long numeroDocumento);
}
