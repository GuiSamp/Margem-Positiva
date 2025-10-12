package br.com.margempositiva.backend.usuario.services.implementacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder; 
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

    private final PasswordEncoder passwordEncoder;

    @Override
     public UsuarioDto create(UsuarioDto usuarioDto) {
        Optional<Usuario> usuarioExiste = usuarioRepository.findByCpfCnpj(usuarioDto.getCpfCnpj());
        if (usuarioExiste.isPresent()) {
            throw new RegraNegocioException("Já existe usuário cadastrado com o cnpj/cpf: " + usuarioDto.getCpfCnpj());
        }

        Usuario usuarioNovo = usuarioMapper.UsuarioDtoToUsuario(usuarioDto);
        usuarioNovo.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));

        usuarioRepository.save(usuarioNovo);
        return usuarioMapper.usuarioToUsuarioDto(usuarioNovo);
    }

    @Override
    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::usuarioToUsuarioDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::usuarioToUsuarioDto)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado!"));
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
