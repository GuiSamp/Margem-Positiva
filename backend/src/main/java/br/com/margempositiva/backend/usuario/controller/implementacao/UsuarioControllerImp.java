package br.com.margempositiva.backend.usuario.controller.implementacao;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.margempositiva.backend.usuario.controller.UsuarioControllerApi;
import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.services.implementacao.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController // A anotação @RestController fica na implementação
@RequiredArgsConstructor
public class UsuarioControllerImp implements UsuarioControllerApi { // <-- Implementa a interface

    private final UsuarioService service;

    @Override
    public UsuarioDto create(UsuarioDto usuarioDto) {
        return service.create(usuarioDto);
    }

    @Override
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        usuarioDto.setId(id);
        return service.update(usuarioDto);
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