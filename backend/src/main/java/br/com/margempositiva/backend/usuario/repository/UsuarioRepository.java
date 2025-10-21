package br.com.margempositiva.backend.usuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.margempositiva.backend.usuario.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);

    Optional<Usuario> findByCpfCnpj(String cpfCnpj);

    Optional<Usuario> findByEmail(String email);
}