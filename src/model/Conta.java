package model;

public class Conta {
    protected String nome;
    protected double saldo;
    protected Banco banco;


    public Conta(String nome, Banco banco) {
        this.nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        this.banco = banco;
    }

    public Conta() {

    }
}
