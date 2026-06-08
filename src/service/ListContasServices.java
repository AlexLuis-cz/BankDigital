package service;

import model.Banco;
import model.Conta;

public class ListContasServices {
    public static void showAccount(Banco bank) {
        System.out.println("--------------Contas Criadas:%s--------------\n");
        for (Conta conta : bank.getContas()) {
            if (conta == null) return;
            System.out.println("Name:" + conta.getNome());
        }
    }
}
