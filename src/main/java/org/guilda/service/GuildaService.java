package org.guilda.service;

import org.guilda.model.Membro;
import org.guilda.model.Missao;
import org.guilda.model.RankMissao;
import org.guilda.model.StatusMissao;
import org.guilda.repository.RepositorioGenerico;

import java.util.LinkedList;
import java.util.List;

public class GuildaService {
    private RepositorioGenerico<Membro> membroRepository;
    private RepositorioGenerico<Missao> missaoRepository;
    private LinkedList<Missao> filaDeEspera;


    public GuildaService() {
        this.membroRepository = new RepositorioGenerico<>();
        this.missaoRepository = new RepositorioGenerico<>();
        this.filaDeEspera = new LinkedList<>();
    }

    public void atribuirProximaMissao(Membro membro){
        Missao missao = filaDeEspera.removeFirst();
        if (missao != null) {
            missao.setMembroDesignado(membro);
            missao.setStatus(StatusMissao.CONCLUIDA);
        }
    }

    public void cadastrarMembro(Membro membro){
        membroRepository.salvar(membro);
    }

    public void cadastrarMissao(Missao missao){
        missaoRepository.salvar(missao);
        filaDeEspera.addLast(missao);
    }

    public void adicionarMissaoUrgente(Missao missao){
        missaoRepository.salvar(missao);
        filaDeEspera.addFirst(missao);
    }

    public List<String> listarTitulosMissoesDeAltoRisco(){
        return missaoRepository.buscarTodos().stream()
                .filter(missao -> missao.getRank() == RankMissao.RANK_S || missao.getRank() == RankMissao.RANK_A)
                .map(missao -> missao.getTitulo().toUpperCase())
                .sorted()
                .toList();
    }

    public double calcularFaturamentoTotalGuilda(){
        return missaoRepository.buscarTodos().stream()
                .filter(missao -> missao.getStatus() == StatusMissao.CONCLUIDA)
                .mapToDouble(missao -> missao.getRecompensaRyo() * 0.2)
                .sum();
    }

    public Membro buscarMembroMaisEficiente(){
        return membroRepository.buscarTodos().stream()
                .max((n1, n2) -> Double.compare(n1.taxaVitoria(), n2.taxaVitoria()))
                .orElse(null);
    }

}
