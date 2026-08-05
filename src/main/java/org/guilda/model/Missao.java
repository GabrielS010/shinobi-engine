package org.guilda.model;

public class Missao {
    String id;
    String titulo;
    double recompensaRyo;
    RankMissao rank;
    StatusMissao status = StatusMissao.PENDENTE;
    Membro membroDesignado = null;

    public Missao(String id, String titulo, double recompensaRyo, RankMissao rank) {
        this.id = id;
        this.titulo = titulo;
        this.recompensaRyo = recompensaRyo;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getRecompensaRyo() {
        return recompensaRyo;
    }

    public RankMissao getRank() {
        return rank;
    }

    public StatusMissao getStatus() {
        return status;
    }

    public void setStatus(StatusMissao status) {
        this.status = status;
    }

    public Membro getMembroDesignado() {
        return membroDesignado;
    }

    public void setMembroDesignado(Membro membroDesignado) {
        this.membroDesignado = membroDesignado;
    }

    @Override
    public String toString() {
        return "Missao: [" +
                "id= '" + id + '\'' +
                ", titulo= '" + titulo + '\'' +
                ", recompensaRyo= " + recompensaRyo +
                ", rank= " + rank +
                ", status= " + status +
                ", membroDesignado= " + membroDesignado +
                ']';
    }
}
