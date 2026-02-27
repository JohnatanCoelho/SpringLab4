package com.lab4.project.ProjetoLab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab4.project.ProjetoLab4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
