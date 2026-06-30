package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class DepositService {
    public void Depositar(Conta conta, ContaCorrente contaCorrente) {
        BankEngine bankEngine = new BankEngine();

        double deposito = InputUtil.readValorDeposito("Valor de Deposito:");
        System.out.printf("Valor depositado:%.2f\n", deposito);
        conta.setSaldo(deposito);
        conta.setExtrato(deposito);

        bankEngine.menuBanco(conta,contaCorrente);
    }
}
