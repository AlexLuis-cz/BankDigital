package service;

import model.Conta;

public interface Payments {
    default void transfer(Conta conta) {

    }

    default void lootMoney(Conta conta) {

    }
}
