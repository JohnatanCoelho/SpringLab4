package com.lab4.project.ProjetoLab4.entity;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usr_usuario)")
public class Usuario {

    @Id
    @Column(name="usr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="usr_nome")
    private String nome;

    @Column(name="usr_senha")
    private String senha;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Anotacao> anotacoes;

    @ManyToAny(fetch = FetchType.EAGER)
    @JoinTable(name="uau_usuario_autorizacao",
        joinColumns = @JoinColumn(name="usr_id"),
        inverseJoinColumns = @JoinColumn(name="aut_id"))
    private Set<Autorizacao> autorizacoes;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(Set<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

}


