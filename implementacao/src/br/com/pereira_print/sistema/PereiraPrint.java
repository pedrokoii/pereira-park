package br.com.pereira_print.sistema;

import java.util.ArrayList;

public abstract class PereiraPrint {

    private static double precoEnergiaEletricaEmReaisPorKWh;
    private static double taxaDeManutencaoEmPorcentagem;
    private static double taxaDeAcabamentoEmPorcentagem;
    private static double taxaDeFalhasEmPorcentagem;
    private static double taxaDeLucroEmPorcentagem;

    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private static ArrayList<Impressora> impressoras = new ArrayList<Impressora>();
    private static ArrayList<Filamento> filamentos = new ArrayList<Filamento>();
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    

    public static void setPrecoEnergiaEletricaEmReaisPorKWh(double novoPrecoEnergiaEletricaEmReaisPorKWh) {
        precoEnergiaEletricaEmReaisPorKWh = novoPrecoEnergiaEletricaEmReaisPorKWh;
    }

    public static void setTaxaDeManutencaoEmPorcentagem(double novaTaxaDeManutencaoEmPorcentagem) {
        taxaDeManutencaoEmPorcentagem = novaTaxaDeManutencaoEmPorcentagem;
    }

    public static void setTaxaDeAcabamentoEmPorcentagem(double novaTaxaDeAcabamentoEmPorcentagem) {
        taxaDeAcabamentoEmPorcentagem = novaTaxaDeAcabamentoEmPorcentagem;
    }

    public static void setTaxaDeFalhasEmPorcentagem(double novaTaxaDeFalhasEmPorcentagem) {
        taxaDeFalhasEmPorcentagem = novaTaxaDeFalhasEmPorcentagem;
    }

    public static void setTaxaDeLucroEmPorcentagem(double novaTaxaDeLucroEmPorcentagem) {
        taxaDeLucroEmPorcentagem = novaTaxaDeLucroEmPorcentagem;
    }

    public static double getPrecoEnergiaEletricaEmReaisPorWh() {
        return precoEnergiaEletricaEmReaisPorKWh / 1000;
    }

    public static double getTaxaDeManutencaoEmDecimal() {
        return taxaDeManutencaoEmPorcentagem / 100;
    }

    public static double getTaxaDeAcabamentoEmDecimal() {
        return taxaDeAcabamentoEmPorcentagem / 100;
    }

    public static double getTaxaDeFalhasEmDecimal() {
        return taxaDeFalhasEmPorcentagem / 100;
    }

    public static double getTaxaDeLucroEmDecimal() {
        return taxaDeLucroEmPorcentagem / 100;
    }

    public static ArrayList<Pedido> getListaDePedidos() {
        return pedidos;
    }

    public static void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public static void addImpressora(Impressora impressora) {
        impressoras.add(impressora);
    }

    public static ArrayList<Impressora> getListaDeImpressoras() {
        return impressoras;
    }

    public static void addFilamento(Filamento filamento) {
        filamentos.add(filamento);
    }

    public static ArrayList<Filamento> getListaDeFilamentos() {
        return filamentos;
    }

    public static void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static ArrayList<Cliente> getListaDeClientes() {
        return clientes;
    }


    public static void imprimirRelatorioErrosImpressoras() {
        System.out.println("Relatorio de Erros das Impressoras");
        for (Impressora impressora : impressoras) {
            System.out.println(String.format("Impressora: %2d | Taxa média de erros: %6.2f%%", impressora.getId(), impressora.getMediaErrosEmDecimal()*100));
        }
    }
}
