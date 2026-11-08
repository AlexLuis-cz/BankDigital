package model;

import java.util.ArrayList;

public class Conta {
    protected String email;
    protected String nome;
    protected String senha;
    protected double saldo;
    protected String chaveTransacao;
    protected AccountType accountType;
    protected ArrayList<Double> extrato = new ArrayList<Double>();
    private ContaCorrente contaCorrente;

    public Conta(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Conta(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Conta(Conta copia) {
        this.email = copia.email;
        this.nome = copia.nome;
        this.senha = copia.senha;
        this.saldo = copia.saldo;
        this.chaveTransacao = copia.chaveTransacao;
        this.accountType = copia.accountType;
        this.extrato = copia.extrato;
        this.contaCorrente = copia.contaCorrente;
    }

    public Conta() {

    }

    //sets
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setChaveTransacao(String chaveTransacao) {
        this.chaveTransacao = chaveTransacao;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setDeposito(double saldo) {
        this.saldo += saldo;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void setChequeContaCorrente(double cheque) {
        contaCorrente.setCheque(cheque);
    }

    //gets
    public String getEmail() {
        return this.email;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getChaveTransacao() {
        return chaveTransacao;
    }

    public double getChequeContaCorrente() {
        return contaCorrente.getCheque();
    }

    public String getNome() {
        return this.nome;
    }

    public ContaCorrente getContaCorrente() {
        return this.contaCorrente;
    }

    //Extrato
    public void setExtrato(double valor) {
        extrato.add(valor);
    }

    public void getExtrato() {
        for (Double values : extrato) {
            System.out.println("Valores depositados:" + values);
        }
    }


    @Override
    public String toString() {
        return "Dados\n" +
                "email:" + this.email + '\n' +
                "senha:" + this.senha + '\n'
                ;
    }
}
