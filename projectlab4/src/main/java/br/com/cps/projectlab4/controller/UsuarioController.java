package br.com.cps.projectlab4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.cps.projectlab4.Services.IUsuarioService;
import br.com.cps.projectlab4.entity.Usuario;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    private IUsuarioService service;

    public UsuarioController(IUsuarioService service){
        this.service = service;
    }
    
    @GetMapping
    public List<Usuario> buscarTodos(){
        return service.buscarUsuarios();
    } 

    @GetMapping(value = "/{usuario}")
    public Usuario buscarPorId(@PathVariable("usuario") Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return service.novoUsuario(usuario);
    }
}
