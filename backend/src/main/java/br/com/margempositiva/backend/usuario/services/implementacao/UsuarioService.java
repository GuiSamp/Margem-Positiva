package br.com.margempositiva.backend.usuario.services.implementacao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.margempositiva.backend.exceptions.RegraNegocioException;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioCreateRequestDto;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioUpdateRequestDto;
import br.com.margempositiva.backend.usuario.domain.entity.UserRole;
import br.com.margempositiva.backend.usuario.domain.entity.Usuario;
import br.com.margempositiva.backend.usuario.mapper.UsuarioMapper;
import br.com.margempositiva.backend.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioDto create(UsuarioCreateRequestDto usuarioCreateDto) {
        usuarioRepository.findByCpfCnpj(usuarioCreateDto.getCpfCnpj()).ifPresent(u -> {
            throw new RegraNegocioException("Já existe usuário cadastrado com o cnpj/cpf: " + u.getCpfCnpj());
        });

        usuarioRepository.findByEmail(usuarioCreateDto.getEmail()).ifPresent(u -> {
            throw new RegraNegocioException("Já existe usuário cadastrado com o e-mail: " + u.getEmail());
        });

        Usuario usuarioNovo = usuarioMapper.usuarioCreateRequestToUsuario(usuarioCreateDto);
        usuarioNovo.setSenha(passwordEncoder.encode(usuarioCreateDto.getSenha()));
        usuarioNovo.setRole(UserRole.USER); // Define USER como role padrão

        Usuario usuarioSalvo = usuarioRepository.save(usuarioNovo);
        return usuarioMapper.usuarioToUsuarioDto(usuarioSalvo);
    }

    public UsuarioDto update(Long id, UsuarioUpdateRequestDto usuarioUpdateDto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado com id " + id));

        usuarioExistente.setNome(usuarioUpdateDto.getNome());
        usuarioExistente.setTelefone(usuarioUpdateDto.getTelefone());

        Usuario usuarioAtualizado = usuarioRepository.save(usuarioExistente);

        return usuarioMapper.usuarioToUsuarioDto(usuarioAtualizado);
    }

    public void remove(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RegraNegocioException("Usuário não encontrado com id " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::usuarioToUsuarioDto)
                .collect(Collectors.toList());
    }

    public UsuarioDto findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::usuarioToUsuarioDto)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado!"));
    }

    public List<UsuarioDto> findByNome(String nome) {
        return usuarioRepository.findByNome(nome)
                .stream()
                .map(usuarioMapper::usuarioToUsuarioDto)
                .collect(Collectors.toList());
    }
}