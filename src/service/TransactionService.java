package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class TransactionService implements Payments{
    public void creatKey(Conta conta){
       String newKey = InputUtil.readNome("Nova chave de transação:");
       conta.setChaveTransacao(newKey);
       final BankEngine bankEngine = new BankEngine();
       bankEngine.menuBank(conta);
    }

    @Override
    public void transfer(Conta conta){

    }
}
