package br.com.pereira_print.sistema;

public class Pedido {

    private int id;
    private Filamento filamento;
    private Modelo modelo;
    private Impressora impressora;
    private Cliente cliente;
    private double valor;
    private String status;
    private double comprimentoFilamentoUtilizado;

    public Pedido(Orcamento o, Cliente c) {
        this.filamento = o.getFilamento();
        this.modelo = o.getModelo();
        this.impressora = o.getImpressora();
        this.valor = o.getValorServico();
        this.cliente = c;
        c.addPedido(this);
        PereiraPrint.addPedido(this);
        this.id = PereiraPrint.getListaDePedidos().size();
        this.status = "Pendente";
        System.out.println(this);
    }

    public void finalizarPedido(double comprimentoFilamentoUtilizado) {
        this.comprimentoFilamentoUtilizado = comprimentoFilamentoUtilizado;
        this.filamento.retiraEstoque(comprimentoFilamentoUtilizado);
        this.status = "Finalizado";
        this.impressora.addPedidoFinalizado(this);
        System.out.println(String.format("Pedido numero %d finalizado. Taxa de erro: %.2f%%", this.id, getTaxaErroDecimal()*100));
    }

    public double getTaxaErroDecimal() {
        return (comprimentoFilamentoUtilizado/modelo.getComprimentoDeFilamentoNecessarioEmMetros())-1;
    }

    @Override
    public String toString() {
        return String.format("""
        
                                Pedido numero: %d
                                Cliente: %s
                                Descricao: %s
                                Filamento: %s
                                Impressora: %d
                                Valor: R$%.2f
                                Status: %s
                                """, id, cliente, modelo, filamento.getTipo(), impressora.getId(), valor, status);
    }
}
