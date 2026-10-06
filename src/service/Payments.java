package service;

import model.Conta;
import model.ContaCorrente;

public interface Payments {
    default void transfer(Conta conta){

    }

    default void lootMoney(Conta conta, ContaCorrente contaCorrente){

    }
}
