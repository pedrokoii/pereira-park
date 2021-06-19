package br.com.pereira_print.sistema;

import java.util.ArrayList;
import java.util.LinkedList;
public class Impressora {
    
    private int id;
    private double precoEmReais;
    private double tempoDeRetornoEmHoras;
    private double consumoDeEnergiaEmWatts;
    private ArrayList<Pedido> pedidosFinalizados = new ArrayList<Pedido>();
    private LinkedList<Pedido> ultimosPedidos = new LinkedList<Pedido>();

    public Impressora(double precoEmReais, double tempoDeRetornoEmHoras, double consumoDeEnergiaEmWatts) {
        PereiraPrint.addImpressora(this);
        this.id = PereiraPrint.getListaDeImpressoras().size();
        this.precoEmReais = precoEmReais;
        this.tempoDeRetornoEmHoras = tempoDeRetornoEmHoras;
        this.consumoDeEnergiaEmWatts = consumoDeEnergiaEmWatts;
    }

    public int getId() {
        return id;
    }

    public double getCustoRetornoPorHora() {
        return precoEmReais / tempoDeRetornoEmHoras;
    }

    public double getConsumoDeEnergiaEmWatts() {
        return consumoDeEnergiaEmWatts;
    }

    public void addPedidoFinalizado(Pedido p) {
        this.pedidosFinalizados.add(p);
        this.ultimosPedidos.addFirst(p);
        if (this.ultimosPedidos.size() > 5){
            this.ultimosPedidos.removeLast();
        }
    }

    public ArrayList<Pedido> getPedidosFinalizados() {
        return pedidosFinalizados;
    }

    public double getMediaErrosEmDecimal() {
        double soma = 0;
        for (int i=0; i<ultimosPedidos.size(); i++) {
            soma += ultimosPedidos.get(i).getTaxaErroDecimal();
        }
        return soma/ultimosPedidos.size();
    }
}
