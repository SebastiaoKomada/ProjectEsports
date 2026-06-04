package com.POO.esports.service;

import com.POO.esports.model.Campeonato;
import com.POO.esports.repository.CampeonatoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public Campeonato cadastrarCampeonato(Campeonato novoCampeonato) {
        if (novoCampeonato.getNome() == null || novoCampeonato.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: O campeonato precisa ter um nome válido");
        }
        if (novoCampeonato.getPremiacao() != null && novoCampeonato.getPremiacao() < 0) {
            throw new IllegalArgumentException("Erro: A premiação não pode ser negativa");
        }
        if (novoCampeonato.getJogo() == null) {
            throw new IllegalArgumentException("Erro: O campeonato deve estar obrigatoriamente vinculado a um jogo");
        }

        return campeonatoRepository.save(novoCampeonato);
    }

    public Campeonato atualizarPremiacao(Long idCamp, Double novaPremiacao) {
        Optional<Campeonato> campeonatoEncontrado = campeonatoRepository.findById(idCamp);

        if (campeonatoEncontrado.isPresent()) {
            Campeonato campeonato = campeonatoEncontrado.get();
            if (novaPremiacao < 0) {
                throw new IllegalArgumentException("Erro: A nova premiação não pode ser negativa");
            }
            campeonato.setPremiacao(novaPremiacao);
            return campeonatoRepository.save(campeonato);
        } else {
            throw new RuntimeException("Campeonato não encontrado no sistema");
        }
    }

    public Campeonato buscarPorId(Long idCamp) {
        return campeonatoRepository.findById(idCamp)
                .orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));
    }
}