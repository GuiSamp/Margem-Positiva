package br.com.margempositiva.backend.usuario.mapper;

import org.mapstruct.Mapper;

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.entity.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
    public abstract UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    public abstract Usuario UsuarioDtoToUsuario(UsuarioDto usuarioDto);    
}
