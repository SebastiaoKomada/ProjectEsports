package com.POO.esports.service;

import com.POO.esports.model.Partida;
import com.POO.esports.repository.PartidaRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public Partida agendarPartida(Partida novaPartida) {
        if (novaPartida.getDataHora() == null) {
            throw new IllegalArgumentException("Erro: A partida precisa ter uma data e hora definidas");
        }

        if (novaPartida.getCampeonato() == null) {
            throw new IllegalArgumentException("Erro: A partida deve obrigatoriamente estar vinculada a um campeonato");
        }

        novaPartida.setDuracao(null);

        return partidaRepository.save(novaPartida);
    }

    public Partida finalizarPartida(Long idPartida, LocalTime duracaoDaPartida) {
        Optional<Partida> partidaEncontrada = partidaRepository.findById(idPartida);

        if (partidaEncontrada.isPresent()) {
            Partida partida = partidaEncontrada.get();
            
            if (partida.getDuracao() != null) {
                throw new IllegalStateException("Erro: Esta partida já foi finalizada anteriormente");
            }

            partida.setDuracao(duracaoDaPartida);
            
            return partidaRepository.save(partida);
        } else {
            throw new RuntimeException("Partida não encontrada no sistema");
        }
    }

    public Partida buscarPorId(Long idPartida) {
        return partidaRepository.findById(idPartida)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));
    }
}