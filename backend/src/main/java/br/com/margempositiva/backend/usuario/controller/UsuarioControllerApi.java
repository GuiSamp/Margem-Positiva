package br.com.margempositiva.backend.usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.margempositiva.backend.usuario.domain.dto.UsuarioDto;
import jakarta.validation.Valid;

import static br.com.margempositiva.backend.constants.UsuarioConstants.API_USUARIO;

import java.util.List;

@RequestMapping(API_USUARIO)
public interface UsuarioControllerApi {

     @PostMapping
    UsuarioDto create(@RequestBody @Valid UsuarioDto pessoaDTO);
    
    @PutMapping("/{id}")
    UsuarioDto update(@PathVariable("id") Long id,
                            @RequestBody @Valid UsuarioDto pessoaDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id);

    @GetMapping
    List<UsuarioDto> getAll();

    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> getById(@PathVariable("id") Long id);

    @GetMapping("/nome/{nome}")
    public List<UsuarioDto> getAll(@PathVariable("nome") String nome);

} 