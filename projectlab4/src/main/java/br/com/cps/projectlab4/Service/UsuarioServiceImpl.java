package br.com.cps.projectlab4.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.cps.projectlab4.Entity.Autorizacao;
import br.com.cps.projectlab4.Entity.Usuario;
import br.com.cps.projectlab4.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    
    UsuarioRepository usuarioRepository;

    IAutorizacaoService autorizacaoService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, IAutorizacaoService autorizacaoService){
        this.usuarioRepository = usuarioRepository;
        this.autorizacaoService = autorizacaoService;
    }

    @Transactional
    @Override
    public Usuario novoUsuario(Usuario usuario){
        if(usuario == null ||
            usuario.getId() != null ||
            usuario.getNome().isBlank() ||
            usuario.getNome() == null ||
            usuario.getSenha().isBlank() ||
            usuario.getSenha() == null
        ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário com dados inválidos!");
        }

        if(usuario.getAutorizacoes() != null){
            Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
            for(Autorizacao aut: usuario.getAutorizacoes()){
                autorizacoes.add(autorizacaoService.findById(aut.getId()));
            }
            usuario.setAutorizacoes(autorizacoes);
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado com esse id!");
        });
    }
    
}
