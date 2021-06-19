package br.com.pereira_print.sistema;

public class Principal {

    public static void main(String[] args) {

        // CASOS DE USO DE CRUD CONFIGURAÇÃO
        PereiraPrint.setPrecoEnergiaEletricaEmReaisPorKWh(0.9);
        PereiraPrint.setTaxaDeManutencaoEmPorcentagem(15);
        PereiraPrint.setTaxaDeFalhasEmPorcentagem(10);
        PereiraPrint.setTaxaDeAcabamentoEmPorcentagem(10);
        PereiraPrint.setTaxaDeLucroEmPorcentagem(200);

        Impressora imp1 = new Impressora(2500, 2500, 300);
        Impressora imp2 = new Impressora(5000, 2500, 400);

        Filamento fil1 = new Filamento("ABS_D1.75", 100, 1.75, 1.00, 250);
        Filamento fil2 = new Filamento("PLA_D1.75", 150, 1.75, 1.50, 250);
        

        // CASOS DE USO DE CONDUÇÃO
        Cliente cli1 = new Cliente("Ordep", "32165498700", "ordep@pereiraprint.com.br");
        Modelo mod1 = new Modelo("Miniatura Batman", 10, 60);
        Orcamento orc1 = new Orcamento(mod1, fil1, imp1);
        Orcamento orc2 = new Orcamento(mod1, fil1, imp2);
        Orcamento orc3 = new Orcamento(mod1, fil2, imp1);
        Orcamento orc4 = new Orcamento(mod1, fil2, imp2);
        Pedido ped1 = new Pedido(orc2, cli1);

        Cliente cli2 = new Cliente("Nauak", "12345678900", "nauak@pereiraprint.com.br");
        Modelo mod2 = new Modelo("Miniatura Pikachu", 15, 45);
        Orcamento orc5 = new Orcamento(mod2, fil1, imp1);
        Orcamento orc6 = new Orcamento(mod2, fil1, imp2);
        Orcamento orc7 = new Orcamento(mod2, fil2, imp1);
        Orcamento orc8 = new Orcamento(mod2, fil2, imp2);
        Pedido ped2 = new Pedido(orc5, cli2);
        Pedido ped3 = new Pedido(orc5, cli2);
        Pedido ped4 = new Pedido(orc5, cli2);
        Pedido ped5 = new Pedido(orc5, cli2);
        Pedido ped6 = new Pedido(orc5, cli2);

        Modelo mod3 = new Modelo("Vaso Estilo Chines", 20, 120);
        Orcamento orc9 = new Orcamento(mod3, fil1, imp1);
        Orcamento orc10 = new Orcamento(mod3, fil1, imp2);
        Orcamento orc11 = new Orcamento(mod3, fil2, imp1);
        Orcamento orc12 = new Orcamento(mod3, fil2, imp2);
        Pedido ped7 = new Pedido(orc12, cli1);
        Pedido ped8 = new Pedido(orc12, cli1);

        ped1.finalizarPedido(11);
        ped2.finalizarPedido(15);
        ped3.finalizarPedido(16);
        ped4.finalizarPedido(17);
        ped5.finalizarPedido(18);
        ped6.finalizarPedido(19);
        ped7.finalizarPedido(20);
        
        System.out.println();
        // CASO DE USO DE ANÁLISE
        PereiraPrint.imprimirRelatorioErrosImpressoras();

    }

}