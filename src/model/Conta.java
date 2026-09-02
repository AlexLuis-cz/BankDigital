package model;

public class Conta {
    protected String email;
    protected String nome;
    protected String senha;
    protected double saldo;
    protected String chaveTransacao;
    protected AccountType accountType;
    protected double[] extrato = new double[100];

    private byte prox = 0;

    public Conta(String nome, String senha, AccountType accountType) {
        this.nome = nome;
        this.senha = senha;
        this.accountType = accountType;
    }

    public Conta(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Conta() {

    }

    //sets
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setChaveTransacao(String chaveTransacao){
        this.chaveTransacao = chaveTransacao;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setDeposito(double saldo) {
        this.saldo += saldo;
    }

    //gets
    public String getEmail(){
        return this.email;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getChaveTransacao(){
        return chaveTransacao;
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
        return "Dados\n" +
                "email:" + this.email + '\n' +
                "senha:" + this.senha + '\n'
                ;
    }
}
