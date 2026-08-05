package org.guilda;

import org.guilda.model.Membro;
import org.guilda.model.Missao;
import org.guilda.model.RankMissao;
import org.guilda.service.GuildaService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuildaService guildaService = new GuildaService();
        Membro gaara = new Membro("111", "Gaara", "Ninjutsu de areia", 68.0);
        Membro naruto = new Membro("222", "Naruto", "Ninjutsu dos 5 elementos", 92.0);
        Membro sasuke = new Membro("333", "Sasuke", "Ninjutsu Ocular", 81.0);

        guildaService.cadastrarMembro(gaara);
        guildaService.cadastrarMembro(naruto);
        guildaService.cadastrarMembro(sasuke);

        Missao m1 = new Missao("MS01", "Escoltar Mercador", 1000.0, RankMissao.RANK_C);
        Missao m2 = new Missao("MS02", "Capturar Pergaminho", 5000.0, RankMissao.RANK_A);
        Missao m3 = new Missao("MS03", "Derrotar Bando Rebelde", 3000.0, RankMissao.RANK_B);

        guildaService.cadastrarMissao(m1);
        guildaService.cadastrarMissao(m2);
        guildaService.cadastrarMissao(m3);

        Missao mUrgente = new Missao("MS04", "Invasão Akatsuki", 20000.0, RankMissao.RANK_S);

        guildaService.adicionarMissaoUrgente(mUrgente);

        guildaService.atribuirProximaMissao(naruto);
        guildaService.atribuirProximaMissao(gaara);

        System.out.println("===== RELATÓRIOS DA GUILDA =====");
        List<String> altoRisco = guildaService.listarTitulosMissoesDeAltoRisco();
        System.out.println("Missões de Alto Risco: " + altoRisco);

        double faturamento = guildaService.calcularFaturamentoTotalGuilda();
        System.out.println("Faturamento Total da Guilda (20%): Ryo " + faturamento);

        Membro maisEficiente = guildaService.buscarMembroMaisEficiente();
        System.out.println("Membro Mais Eficiente: " + maisEficiente);

    }
}
