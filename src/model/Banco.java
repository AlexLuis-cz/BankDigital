package model;

import engine.BankEngine;

public class Banco {
    private static final Conta[] contas = new Conta[10];
    private static int posicao = 0;


    public Banco() {

    }

    public Conta[] getContas() {
        return contas;
    }

    public void loginRequest(String usuario, String senha) {
        BankEngine bankEngine = new BankEngine();
        usuario = usuario.substring(0, 1).toUpperCase() + usuario.substring(1).toLowerCase();

        for (Conta value : contas) {
            if(value ==null)return;
            if (usuario.equals(value.nome) && senha.equals(value.senha)) {
                Conta conta = new Conta(usuario, senha);
                ContaCorrente contaCorrente = new ContaCorrente(conta);

                System.out.println("login feito com sucesso");
                bankEngine.menuBanco(conta,contaCorrente);
            } else {
                System.out.println("Usuario ou senha incorretos");
                BankEngine.menu();
            }
        }
    }


    public static void setContas(Conta conta) {
        Banco.contas[posicao] = conta;
        posicao++;
    }
}
