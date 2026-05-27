package service;

import engine.BankEngine;
import model.ContaCorrente;
import util.InputUtil;

public class SaqueService {
    public void saque(ContaCorrente conta) {
        BankEngine engine = new BankEngine();
        ExtratoService extratoService = new ExtratoService();
        double valor = InputUtil.readValorSaque("Valor que deseja sacar:");

        if (valor > conta.getSaldo()) {//Validation to check if the check or withdrawal has funds.
            if (valor > conta.getCheque()) {
                System.out.println("Não sera possivel fazer o saque");
                engine.menuBanco(conta);
            } else {
                conta.setSaldo(conta.getSaldo() - valor);
                System.out.println("Saque De cheque Concluido!!");
                System.out.printf("Saque feito por:%s\n", conta.getNome());
                System.out.printf("Valor retirado:%.2f", valor);
                System.out.printf("\nSaldo Cheque Restante:%.2f", conta.getCheque());
                ExtratoService.setSaques(valor, conta);
            }
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque De saldo Concluido!!");
            System.out.printf("Saque feito por:%s\n", conta.getNome());
            System.out.printf("Valor retirado:%.2f", valor);
            System.out.printf("\nSaldo Restante:%.2f\n", conta.getSaldo());
            ExtratoService.setSaques(valor, conta);
        }
    }
}
