package service;

import engine.BankEngine;
import model.Conta;
import util.InputUtil;

public class DepositService {
    public void depositar(Conta conta) {

        double deposito = InputUtil.readValorDeposito("Valor de Deposito:");

        if(deposito <= 0){
            System.out.println("Valor de deposito invalido");
            depositar(conta);
        }

        System.out.printf("Valor depositado:%.2f\n", deposito);
        conta.setDeposito(deposito);
        conta.setExtrato(deposito);
    }
}
