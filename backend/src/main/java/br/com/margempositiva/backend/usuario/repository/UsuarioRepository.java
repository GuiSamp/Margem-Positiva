package br.com.margempositiva.backend.usuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.margempositiva.backend.usuario.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Override
    default List<Usuario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    default Optional<Usuario> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    List<Usuario> findByNome(String nome);

    Optional<Usuario> findByCpfCnpj(String cpfCnpj);
    
}
