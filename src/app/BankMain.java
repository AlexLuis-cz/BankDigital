package app;

import engine.BankEngine;
import service.AuthService;

public class BankMain {
    public static void main(String[] args) {
        BankEngine bankEngine = new BankEngine();
        bankEngine.menu();
    }
}
