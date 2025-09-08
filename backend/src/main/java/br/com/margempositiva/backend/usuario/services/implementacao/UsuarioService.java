package br.com.margempositiva.backend.usuario.services.implementacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.margempositiva.backend.exceptions.RegraNegocioException;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.entity.Usuario;
import br.com.margempositiva.backend.usuario.mapper.UsuarioMapper;
import br.com.margempositiva.backend.usuario.repository.UsuarioRepository;
import br.com.margempositiva.backend.usuario.services.UsuarioServiceInterface;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioServiceInterface{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto create(UsuarioDto usuarioDto) {
        Usuario usuarioNovo = usuarioMapper.UsuarioDtoToUsuario(usuarioDto);
         Optional<Usuario> usuarioExiste = usuarioRepository.findByCpfCnpj(usuarioNovo.getCpfCnpj()); 
         if (usuarioExiste.isPresent()) {
            throw new RegraNegocioException("Já existe usuário cadastrado com o cnpj/cpf: " + usuarioDto.getCpfCnpj());
         }
        usuarioRepository.save(usuarioNovo); 
        return usuarioMapper.usuarioToUsuarioDto(usuarioNovo);
    }

    @Override
    public List<UsuarioDto> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> usuariosDtos = new ArrayList<>();

        usuarios.forEach(p-> usuariosDtos.add(usuarioMapper.usuarioToUsuarioDto(p)));
        return usuariosDtos;
    }

    @Override
    public UsuarioDto findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new RegraNegocioException("Usuário não encontrado!"); 
        }
        return usuarioMapper.usuarioToUsuarioDto(usuario.get());
    }

    @Override
    public List<UsuarioDto> findByNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.findByNome(nome);
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
      
        usuarios.forEach(p-> usuarioDtos.add(usuarioMapper.usuarioToUsuarioDto(p)));

        return usuarioDtos;
    }

    @Override
    public void remove(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RegraNegocioException("Usuário não encontrada com id " + id);
        }
        usuarioRepository.deleteById(id);     
    }

    @Override
    public UsuarioDto update(UsuarioDto p) {
        if (!usuarioRepository.existsById(p.getId())) {
            throw new RegraNegocioException("Usuário não encontrada com id " + p.getId());
        }
        return create(p);
    }
    
    
}
