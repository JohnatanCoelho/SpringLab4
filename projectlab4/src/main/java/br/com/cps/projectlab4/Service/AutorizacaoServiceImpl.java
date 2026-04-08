package br.com.cps.projectlab4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.cps.projectlab4.Entity.Autorizacao;
import br.com.cps.projectlab4.Repository.AutorizacaoRepository;

@Service
public class AutorizacaoServiceImpl implements IAutorizacaoService{

    @Autowired
    AutorizacaoRepository autorizacaoRepository;
    
    @Override
    public Autorizacao findById(Long id){
        return autorizacaoRepository.findById(id).orElseThrow(()-> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Autorização não encontrada!");
        });
    }
    
}
