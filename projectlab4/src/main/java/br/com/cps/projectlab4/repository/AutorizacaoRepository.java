package br.com.cps.projectlab4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cps.projectlab4.Entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
    
}
