package br.com.pereira_print.sistema;

import java.util.ArrayList;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String email;

    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(String nome, String cpf, String email) {
        PereiraPrint.addCliente(this);
        this.id = PereiraPrint.getListaDeClientes().size();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return nome + " - " + email;
    }

}
