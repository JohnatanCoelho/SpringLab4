package br.com.cps.projectlab4.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.cps.projectlab4.Entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Optional<Usuario> findByNome(String nome);

    @Query("SELECT u FROM Usuario u where u.nome = ?1")
    public Optional<Usuario> buscarPeloNome(String nome);

    public List<Usuario> findByNomeContains(String nome); 

    @Query("SELECT u FROM Usuario u where u.nome LIKE %?1%")
    public List<Usuario> buscarPeloNomeContendo(String nome);

    public boolean existsById(Long id);
}
