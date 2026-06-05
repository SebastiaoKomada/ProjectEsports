package com.POO.esports.dto;

import com.POO.esports.model.Time;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class JogadorRequest {
    private String nickname;
    private Integer idadeJogador;
    private BigDecimal salario;
    private Time time;

    public JogadorRequest(){

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getIdadeJogador() {
        return idadeJogador;
    }

    public void setIdadeJogador(Integer idadeJogador) {
        this.idadeJogador = idadeJogador;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
