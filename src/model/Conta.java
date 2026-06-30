package model;

import engine.BankEngine;

public class Conta {
    protected String nome;
    protected String senha;
    protected double saldo;
    protected double[] extrato = new double[100];
    private byte prox = 0;


    public Conta(String nome, String senha) {
        this.nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        this.senha = senha;
    }

    public Conta() {

    }

    //sets
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //gets

    public double getSaldo() {
        return this.saldo;
    }

    public String getSenha() {
        return this.senha;
    }


    public String getNome() {
        return this.nome;
    }

    //Extrato
    public void setExtrato(double valor) {
        if (prox <= extrato.length) {
            extrato[prox] = valor;
            prox++;
        }
    }

    public void getExtrato() {
        for (int i = 0; i < prox; i++) {
            System.out.println("Valores depositados:" + extrato[i]);
        }
        if (prox == 100) {
            prox = 0;
        }
    }


    @Override
    public String toString() {
        return "Saldo:" + this.saldo;
    }
}
