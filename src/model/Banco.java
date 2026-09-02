package model;

import engine.BankEngine;
import util.InputUtil;

import java.util.Scanner;

public class Banco {
    private static final Conta[] CONTAS = new Conta[100];
    private static int POSICAO = 0;
    private static final BankEngine bankEngine = new BankEngine();

    public Banco() {

    }

    public Conta[] getContas() {
        return CONTAS;
    }

    public void validyLogin(Conta conta, ContaCorrente contaCorrente) {
        Scanner sc = new Scanner(System.in);
        String senha = sc.nextLine();

        if (senha.equals(conta.getSenha())) {
            System.out.println(conta);
        } else {
            System.out.println("Algo deu errado deseja tentar novamente?");
            byte option = InputUtil.readByte();
            switch (option) {
                case 1:
                    validyLogin(conta, contaCorrente);
                    break;
                case 2:
                    bankEngine.menuBank(conta, contaCorrente);
            }
        }
    }

    public static void setContas(Conta conta) {
        Banco.CONTAS[POSICAO] = conta;
        POSICAO++;
    }
}
