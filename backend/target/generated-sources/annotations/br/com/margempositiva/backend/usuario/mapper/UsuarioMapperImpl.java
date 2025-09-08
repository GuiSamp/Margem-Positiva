package br.com.margempositiva.backend.usuario.mapper;

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-07T22:51:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();

        usuarioDto.id( usuario.getId() );
        usuarioDto.nome( usuario.getNome() );
        usuarioDto.email( usuario.getEmail() );
        usuarioDto.cpfCnpj( usuario.getCpfCnpj() );
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

        usuario.id( usuarioDto.getId() );
        usuario.nome( usuarioDto.getNome() );
        usuario.email( usuarioDto.getEmail() );
        usuario.cpfCnpj( usuarioDto.getCpfCnpj() );
        usuario.senha( usuarioDto.getSenha() );
        usuario.telefone( usuarioDto.getTelefone() );

        return usuario.build();
    }
}
