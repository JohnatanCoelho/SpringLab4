package br.com.cps.projectlab4.Service;

import java.util.List;

import br.com.cps.projectlab4.Entity.Usuario;

public interface IUsuarioService {

    public List<Usuario> buscarUsuarios();

    public Usuario buscarPorId(Long id);

    public Usuario novoUsuario(Usuario usuario);
    
}
