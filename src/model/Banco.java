package model;

import engine.BankEngine;

public class Banco {
    private static final Conta[] CONTAS = new Conta[100];
    private static int POSICAO = 0;


    public Banco() {

    }

    public Conta[] getContas() {
        return CONTAS;
    }

    public void loginRequest(String usuario, String senha) {
        BankEngine bankEngine = new BankEngine();
        usuario = usuario.substring(0, 1).toUpperCase() + usuario.substring(1).toLowerCase();

        for (Conta value : Banco.CONTAS) {
            if (value == null) {
                System.out.println("Usuario ou senha incorretos");
                BankEngine.menu();
            }

            if (usuario.equals(value.nome) && senha.equals(value.senha)) {
                ContaCorrente contaCorrente = new ContaCorrente(value);

                System.out.println("login feito com sucesso");
                bankEngine.menuBanco(value, contaCorrente);
            } else {
                System.out.println("Usuario ou senha incorretos");
                BankEngine.menu();
            }
        }
    }


    public static void setContas(Conta conta) {
        Banco.CONTAS[POSICAO] = conta;
        POSICAO++;
    }
}
