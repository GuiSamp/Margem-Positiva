package br.com.margempositiva.backend.usuario.mapper;

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-11T21:26:42-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();

        usuarioDto.cpfCnpj( usuario.getCpfCnpj() );
        usuarioDto.email( usuario.getEmail() );
        usuarioDto.id( usuario.getId() );
        usuarioDto.nome( usuario.getNome() );
        usuarioDto.senha( usuario.getSenha() );
        usuarioDto.telefone( usuario.getTelefone() );

        return usuarioDto.build();
    }

    @Override
    public Usuario UsuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.cpfCnpj( usuarioDto.getCpfCnpj() );
        usuario.email( usuarioDto.getEmail() );
        usuario.id( usuarioDto.getId() );
        usuario.nome( usuarioDto.getNome() );
        usuario.senha( usuarioDto.getSenha() );
        usuario.telefone( usuarioDto.getTelefone() );

        return usuario.build();
    }
}
