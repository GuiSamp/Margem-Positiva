package br.com.margempositiva.backend.usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; // Importado para o filtro

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import jakarta.validation.Valid;

import static br.com.margempositiva.backend.constants.UsuarioConstants.API_USUARIO;

import java.util.List;

@RequestMapping(API_USUARIO)
public interface UsuarioControllerApi {

    @PostMapping
    UsuarioDto create(@RequestBody @Valid UsuarioDto usuarioDto);
    
    @PutMapping("/{id}")
    UsuarioDto update(@PathVariable("id") Long id, @RequestBody @Valid UsuarioDto usuarioDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);

    @GetMapping
    List<UsuarioDto> getAll(@RequestParam(name = "nome", required = false) String nome);

    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> getById(@PathVariable("id") Long id);
}