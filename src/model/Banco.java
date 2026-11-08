package model;

import engine.BankEngine;
import util.InputUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private final ArrayList<Conta> contas = new ArrayList<Conta>();
    private static final BankEngine bankEngine = new BankEngine();

    public Banco() {

    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public static void validyLogin(Conta conta) {
        Scanner sc = new Scanner(System.in);
        String senha = sc.nextLine();

        if (senha.equals(conta.getSenha())) {
            System.out.println(conta);
        } else {
            System.out.println("Algo deu errado deseja tentar novamente?");
            byte option = InputUtil.readByte();
            switch (option) {
                case 1:
                    validyLogin(conta);
                    break;
                case 2:
                    bankEngine.menuBank(conta);
            }
        }
    }

    public void setContas(Conta conta) {
        contas.add(conta);
    }
}
