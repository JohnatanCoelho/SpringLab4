package br.com.cps.projectlab4.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.cps.projectlab4.entity.Usuario;
import br.com.cps.projectlab4.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    
    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    
    @Override
    public List<Usuario> buscarUsuarios(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuarioOp = usuarioRepository.findById(id);
        if(usuarioOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado com esse id!");
        }
        return usuarioOp.get();
    }

    @Override
    public Usuario novoUsuario(Usuario usuario){
        if(usuario == null ||
            usuario.getId() != null ||
            usuario.getNome().isBlank() ||
            usuario.getNome() == null ||
            usuario.getSenha().isBlank() ||
            usuario.getSenha() == null 
        ){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados de usuário inválidos!");
        }

        return usuarioRepository.save(usuario);
    }
}
