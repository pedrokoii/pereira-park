package br.com.pereira_print.sistema;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Filamento {

    private int id;
    private String tipo;
    private double precoEmReaisPorQuilo;
    private double diametroEmMilimetros;
    private double densidadeEmGramaPorCentimetroCubico;
    private double comprimentoEmEstoqueEmMetros;

    public Filamento(String tipo, double precoEmReaisPorQuilo, double diametroEmMilimetros,
            double densidadeEmGramaPorCentimetroCubico, double comprimentoEmEstoqueEmMetros) {
        PereiraPrint.addFilamento(this);
        this.id = PereiraPrint.getListaDeFilamentos().size();
        this.tipo = tipo;
        this.precoEmReaisPorQuilo = precoEmReaisPorQuilo;
        this.diametroEmMilimetros = diametroEmMilimetros;
        this.densidadeEmGramaPorCentimetroCubico = densidadeEmGramaPorCentimetroCubico;
        this.comprimentoEmEstoqueEmMetros = comprimentoEmEstoqueEmMetros;
    }

    public double getAreaSecaoEmMetro2() {
        return (PI * pow((diametroEmMilimetros), 2) / 4) * pow(10, -6);
    }

    public double getDensidadeEmQuiloPorM3() {
        return densidadeEmGramaPorCentimetroCubico * pow(10, 3);
    }

    public double getPrecoEmReaisPorQuilo() {
        return precoEmReaisPorQuilo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void adicionaEstoque(double comprimentoEmMetros) {
        comprimentoEmEstoqueEmMetros += comprimentoEmMetros;
    }

    public void retiraEstoque(double comprimentoEmMetros) {
        comprimentoEmEstoqueEmMetros -= comprimentoEmMetros;
    }

    public double getComprimentoEmEstoqueEmMetros() {
        return comprimentoEmEstoqueEmMetros;
    }
}
