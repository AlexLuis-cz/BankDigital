package model;

public class Banco {
    private final String nome;
    private static final Conta[] contas = new Conta[10];
    private static int posicao = 0;


    public Banco(String nome) {
        this.nome = nome;
    }

    public static void setContas(Conta conta) {
        Banco.contas[posicao] = conta;
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
