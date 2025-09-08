package br.com.margempositiva.backend.usuario.controller.implementacao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import br.com.margempositiva.backend.usuario.services.implementacao.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsuarioControllerImp {

    private final UsuarioService service;

    public UsuarioDto create(UsuarioDto usuarioDto) {
        return service.create(usuarioDto);
    }
    
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        usuarioDto.setId(id);
        return service.update(usuarioDto);
    }

    public ResponseEntity<Void> delete(Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }

    public List<UsuarioDto> getAll() {
        return service.findAll();
    }

    public ResponseEntity<UsuarioDto> getById(Long id) {
        UsuarioDto p = service.findById(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<UsuarioDto> getAll(String nome) {
        return service.findByNome(nome);
    }
}
