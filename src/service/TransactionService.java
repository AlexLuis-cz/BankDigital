package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class TransactionService {
    public void creatKey(Conta conta, ContaCorrente contaCorrente){
       String newKey = InputUtil.readNome("Nova chave de transação:");
       conta.setChaveTransacao(newKey);
       final BankEngine bankEngine = new BankEngine();
       bankEngine.menuBank(conta, contaCorrente);
    }

    public void transfer(Conta conta, ContaCorrente contaCorrente){

    }
}
