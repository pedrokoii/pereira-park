package br.com.pereira_print.sistema;

public class Orcamento {

    private Modelo modelo;
    private Filamento filamento;
    private Impressora impressora;
    private double valorServico;

    public Orcamento(Modelo modelo, Filamento filamento, Impressora impressora) {
        this.modelo = modelo;
        this.filamento = filamento;
        this.impressora = impressora;
        calcularValorServico();
        System.out.println(this);
    }

    private double getPesoProdutoEmQuilos() {
        return filamento.getDensidadeEmQuiloPorM3() * modelo.getComprimentoDeFilamentoNecessarioEmMetros()
                * filamento.getAreaSecaoEmMetro2();
    }

    private double getCustoMaterialEmReais() {
        return getPesoProdutoEmQuilos() * filamento.getPrecoEmReaisPorQuilo();
    }

    private double getCustoEnergiaEmReais() {
        return PereiraPrint.getPrecoEnergiaEletricaEmReaisPorWh() * impressora.getConsumoDeEnergiaEmWatts()
                * modelo.getTempoDeImpressaoNecessarioEmHoras();
    }

    private double getCustoManutencaoEmReais() {
        return getCustoMaterialEmReais() * PereiraPrint.getTaxaDeManutencaoEmDecimal();
    }

    private double getCustoFalhasEmReais() {
        return getCustoMaterialEmReais() * PereiraPrint.getTaxaDeFalhasEmDecimal();
    }

    private double getCustoAcabamentoEmReais() {
        return getCustoMaterialEmReais() * PereiraPrint.getTaxaDeAcabamentoEmDecimal();
    }

    private double getCustoRetornoImpressora() {
        return impressora.getCustoRetornoPorHora() * modelo.getTempoDeImpressaoNecessarioEmHoras();
    }

    private double getCustoProducao() {
        return (getCustoMaterialEmReais() + getCustoEnergiaEmReais() + getCustoManutencaoEmReais()
                + getCustoFalhasEmReais() + getCustoAcabamentoEmReais() + getCustoRetornoImpressora());
    }

    public void calcularValorServico() {
        this.valorServico = getCustoProducao() * (1 + PereiraPrint.getTaxaDeLucroEmDecimal());
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Impressora getImpressora() {
        return impressora;
    }

    public Filamento getFilamento() {
        return filamento;
    }

    public double getValorServico() {
        return valorServico;
    }
    
    @Override
    public String toString() {
        return String.format("Orcamento: %s | Filamento: %s | Impressora: %d | Valor do Servico: R$%.2f",this.modelo, this.filamento.getTipo(), this.impressora.getId(), this.valorServico);
    }
}
