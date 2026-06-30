package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class SaqueService {
    public void saque(Conta conta,ContaCorrente contaCorrente) {
        BankEngine engine = new BankEngine();
        double valor = InputUtil.readValorSaque("Valor que deseja sacar:");

        if (valor > conta.getSaldo()) {//Validation to check if the check or withdrawal has funds.
            if (valor > contaCorrente.getCheque()) {
                System.out.println("Não sera possivel fazer o saque");
                engine.menuBanco(conta,contaCorrente);
            } else {
                conta.setSaldo(conta.getSaldo() - valor);
                System.out.println("Saque De cheque Concluido!!");
                System.out.printf("Saque feito por:%s\n", conta.getNome());
                System.out.printf("Valor retirado:%.2f", valor);
                System.out.printf("\nSaldo Cheque Restante:%.2f", contaCorrente.getCheque());
            }
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque De saldo Concluido!!");
            System.out.printf("Saque feito por:%s\n", conta.getNome());
            System.out.printf("Valor retirado:%.2f", valor);
            System.out.printf("\nSaldo Restante:%.2f\n", conta.getSaldo());
        }
    }
}
