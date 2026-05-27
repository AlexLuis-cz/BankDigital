package model;

public class Banco {
    private final String nome;
    private final int agencia;
    private Conta[] contas = new Conta[10];
    private int posicao = 0;


    public Banco(String nome, int agencia) {
        this.nome = nome;
        this.agencia = agencia;
    }

    public void setContas(Conta conta) {
        this.contas[posicao] = conta;
        posicao++;
    }

    public void mostrarContas() {
        System.out.printf("--------------Contas Criadas:%s--------------\n", this.nome);
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) return;
            System.out.println("Nome:" + contas[i].nome);
        }
    }
}
