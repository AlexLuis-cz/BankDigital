package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class SaqueService implements Payments {

    @Override
    public void lootMoney(Conta conta) {
        final BankEngine bankEngine = new BankEngine();
        conta = new ContaCorrente(conta);

        double valor = InputUtil.readValorSaque("Valor que deseja sacar:");
        if (conta instanceof ContaCorrente) {
            if (valor > conta.getSaldo()) { //Validation to check if the check or withdrawal has funds.

                if (valor > ((ContaCorrente) conta).getCheque()) {
                    System.out.println("Não sera possivel fazer o saque");

                    bankEngine.menuBank(conta);
                } else {
                    conta.setChequeContaCorrente(((ContaCorrente) conta).getCheque() - valor);
                    System.out.println("Saque De cheque Concluido!!");
                    System.out.printf("Saque feito por:%s\n", conta.getNome());
                    System.out.printf("Valor retirado:%.2f", valor);
                    System.out.printf("\nSaldo Cheque Restante:%.2f\n", ((ContaCorrente) conta).getCheque());

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
}
