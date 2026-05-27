package service;

import engine.BankEngine;
import model.ContaCorrente;
import util.InputUtil;

public class DepositService {
    public void Depositar(ContaCorrente conta) {
        BankEngine bankEngine = new BankEngine();

        double deposito = InputUtil.readValorDeposito("Valor de Deposito:");
        System.out.printf("Valor depositado:%.2f\n", deposito);
        ExtratoService.setDepositos(deposito, conta);
        conta.setSaldo(deposito);

        bankEngine.menuBanco(conta);
    }
}
