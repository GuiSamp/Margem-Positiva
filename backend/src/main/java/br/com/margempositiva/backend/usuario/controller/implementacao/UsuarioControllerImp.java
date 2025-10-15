package br.com.margempositiva.backend.usuario.controller.implementacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.margempositiva.backend.usuario.controller.UsuarioControllerApi;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioCreateRequestDto;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioUpdateRequestDto;
import br.com.margempositiva.backend.usuario.services.implementacao.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImp implements UsuarioControllerApi {

    private final UsuarioService service;

    @Override
    public UsuarioDto create(UsuarioCreateRequestDto usuarioCreateDto) {
        return service.create(usuarioCreateDto);
    }

    @Override
    public UsuarioDto update(Long id, UsuarioUpdateRequestDto usuarioUpdateDto) {
        return service.update(id, usuarioUpdateDto);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<UsuarioDto> getAll(String nome) {
        if (nome != null && !nome.isBlank()) {
            return service.findByNome(nome);
        }
        return service.findAll();
    }

    @Override
    public ResponseEntity<UsuarioDto> getById(Long id) {
        UsuarioDto usuarioDto = service.findById(id);
        return ResponseEntity.ok(usuarioDto);
    }
}