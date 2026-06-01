package com.POO.esports.model;

import jakarta.persistence.*;

@Entity
@Table(name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_camp")
    private Long idCamp;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(precision = 12, scale = 2)
    private Double premiacao;

    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    public Campeonato() {
    }

    public Campeonato(String nome, Double premiacao, Jogo jogo) {
        this.nome = nome;
        this.premiacao = premiacao;
        this.jogo = jogo;
    }

    public Long getIdCamp() {
        return idCamp;
    }

    public String getNome() {
        return nome;
    }

    public Double getPremiacao() {
        return premiacao;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPremiacao(Double premiacao) {
        this.premiacao = premiacao;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}