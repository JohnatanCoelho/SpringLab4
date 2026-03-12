package br.com.cps.projectlab4.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ant_anotacao")
public class Anotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private Long id;

    @Column(name = "ant_texto")
    private String texto;

    @Column(name="ant_data_hora")
    private LocalDateTime datahora;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ant_usr_id")
    private Usuario usuario;

}
