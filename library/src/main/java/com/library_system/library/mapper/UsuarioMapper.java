package com.library_system.library.mapper;

import com.library_system.library.dto.usuario.UsuarioRequestDTO;
import com.library_system.library.dto.usuario.UsuarioResponseDTO;
import com.library_system.library.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {

        UsuarioResponseDTO dto = new UsuarioResponseDTO();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setTipo(usuario.getTipo());

        return dto;
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTelefone(dto.getTelefone());
        usuario.setTipo(dto.getTipo());

        return usuario;
    }
}