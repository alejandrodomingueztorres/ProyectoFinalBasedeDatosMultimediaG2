package com.apirest.backend.Service;

import com.apirest.backend.Model.UsuarioModel;
import com.apirest.backend.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel crearUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuarioNuevo) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioNuevo.getNombre());
            usuario.setTipoUsuario(usuarioNuevo.getTipoUsuario());
            usuario.setTipoDocumento(usuarioNuevo.getTipoDocumento());
            usuario.setNumeroDocumento(usuarioNuevo.getNumeroDocumento());
            usuario.setCorreoElectronico(usuarioNuevo.getCorreoElectronico());
            usuario.setNumTelefono(usuarioNuevo.getNumTelefono());
            usuario.setDireccionUnidad(usuarioNuevo.getDireccionUnidad());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
