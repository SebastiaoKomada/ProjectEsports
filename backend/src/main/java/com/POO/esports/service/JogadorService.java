package com.POO.esports.service;

import com.POO.esports.model.Jogador;
import com.POO.esports.model.Time;
import com.POO.esports.repository.JogadorRepository; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador cadastrarJogador(Jogador novoJogador) {
        if (novoJogador.getNickname() == null || novoJogador.getNickname().isEmpty()) {
            throw new IllegalArgumentException("Erro: O jogador precisa ter um nickname válido");
        }

        if (novoJogador.getIdadeJogador() != null && novoJogador.getIdadeJogador() < 16) {
            throw new IllegalArgumentException("Erro: O jogador deve ter pelo menos 16 anos para competir profissionalmente");
        }

        return jogadorRepository.save(novoJogador);
    }

    public Jogador transferirJogador(Long idJogador, Time novoTime) {
        Optional<Jogador> jogadorEncontrado = jogadorRepository.findById(idJogador);

        if (jogadorEncontrado.isPresent()) {
            Jogador jogador = jogadorEncontrado.get();
            jogador.setTime(novoTime);
            return jogadorRepository.save(jogador);
        } else {
            throw new RuntimeException("Jogador não encontrado no sistema");
        }
    }

    public Jogador buscarPorId(Long idJogador) {
        return jogadorRepository.findById(idJogador)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }
}