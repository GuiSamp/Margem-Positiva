package br.com.margempositiva.backend.usuario.services;

import java.util.List;

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;

public interface UsuarioServiceInterface {
    
    UsuarioDto create(UsuarioDto usuarioDto);
    
    UsuarioDto update(UsuarioDto p);

    void remove(Long id);

    List<UsuarioDto> findAll();

    UsuarioDto findById(Long id);

    List<UsuarioDto> findByNome(String nome);

}
