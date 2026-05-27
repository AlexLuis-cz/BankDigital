package model;

public class Conta {
    protected String nome;
    protected String senha;
    protected double saldo;
    protected Banco banco;


    public Conta(String nome, String senha) {
        this.nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        this.senha = senha;
    }

    public Conta() {

    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNome(){
        return this.nome;
    }
}
