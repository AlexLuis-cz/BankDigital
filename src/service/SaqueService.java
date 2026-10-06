package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class SaqueService implements Payments {

    @Override
    public void lootMoney(Conta conta, ContaCorrente contaCorrente) {
        BankEngine bankEngine = new BankEngine();
        double valor = InputUtil.readValorSaque("Valor que deseja sacar:");

        if (valor > conta.getSaldo()) {//Validation to check if the check or withdrawal has funds.
            if (valor > conta.getChequeContaCorrente()) {
                System.out.println("Não sera possivel fazer o saque");
                bankEngine.menuBank(conta);
            } else {
                conta.setChequeContaCorrente(conta.getChequeContaCorrente() - valor);
                System.out.println("Saque De cheque Concluido!!");
                System.out.printf("Saque feito por:%s\n", conta.getNome());
                System.out.printf("Valor retirado:%.2f", valor);
                System.out.printf("\nSaldo Cheque Restante:%.2f\n", conta.getChequeContaCorrente());
                bankEngine.menuBank(conta);
            }
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque De saldo Concluido!!");
            System.out.printf("Saque feito por:%s\n", conta.getNome());
            System.out.printf("Valor retirado:%.2f", valor);
            System.out.printf("\nSaldo Restante:%.2f\n", conta.getSaldo());
            bankEngine.menuBank(conta);
        }
    }
}
