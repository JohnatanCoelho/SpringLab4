package br.com.cps.projectlab4.Services;

import java.util.List;

import br.com.cps.projectlab4.entity.Usuario;

public interface IUsuarioService {

    public List<Usuario> buscarUsuarios();

    public Usuario buscarPorId(Long id);

    public Usuario novoUsuario(Usuario usuario);
    
} 
