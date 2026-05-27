package service;

import model.ContaCorrente;

public class ExtratoService {
    private static double[] saques = new double[100];
    private static double[] depositos = new double[100];
    private static int proximo = 0;

    public static void saques(ContaCorrente conta) {
        for (int i = 0; i < proximo; i++) {
            System.out.print("Valores sacados:" + ExtratoService.saques[i]);
        }
    }

    public double[] getSaques() {
        return saques;
    }

    public static void setSaques(double valorSacado, ContaCorrente conta) {
        if (proximo < saques.length) {
            saques[proximo] = valorSacado;
            proximo++;
        } else {
            proximo = 0;
        }
    }

    //depositos
    public static void depositos(ContaCorrente conta) {
        for (int i = 0; i < proximo; i++) {
            System.out.println("Valores Depositados:" + ExtratoService.depositos[i]);
        }
    }

    public double[] getDepositos() {
        return saques;
    }

    public static void setDepositos(double depositado, ContaCorrente conta) {
        if (proximo < saques.length) {
            depositos[proximo] = depositado;
            proximo++;
        } else {
            proximo = 0;
        }
    }


}
