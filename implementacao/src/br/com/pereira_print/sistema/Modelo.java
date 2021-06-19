package br.com.pereira_print.sistema;

public class Modelo {

    private String descricao;
    private double comprimentoDeFilamentoNecessarioEmMetros;
    private int tempoDeImpressaoNecessarioEmMinutos;

    public Modelo(String descricao, double comprimentoDeFilamentoNecessarioEmMetros,
            int tempoDeImpressaoNecessarioEmMinutos) {
        this.descricao = descricao;
        this.comprimentoDeFilamentoNecessarioEmMetros = comprimentoDeFilamentoNecessarioEmMetros;
        this.tempoDeImpressaoNecessarioEmMinutos = tempoDeImpressaoNecessarioEmMinutos;
    }

    public double getComprimentoDeFilamentoNecessarioEmMetros() {
        return comprimentoDeFilamentoNecessarioEmMetros;
    }

    public double getTempoDeImpressaoNecessarioEmHoras() {
        return (double)tempoDeImpressaoNecessarioEmMinutos / 60;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
