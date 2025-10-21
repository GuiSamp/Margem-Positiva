package br.com.margempositiva.backend.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping; 

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioCreateRequestDto;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.entity.Usuario;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
    
    
    public abstract UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    public abstract Usuario usuarioCreateRequestToUsuario(UsuarioCreateRequestDto usuarioCreateDto);
}