package util;

import model.AccountType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static String readNome(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static String readSenha(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static byte readByte() {
        try {
            return sc.nextByte();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    public static String breakLine() {
        return sc.nextLine();
    }

    public static double readValorSaque(String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    public static double readValorTransfer(String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    public static double readValorDeposito(String mensagem) {
        System.out.print(mensagem);
        return sc.nextDouble();
    }

    public static AccountType readTypeAccount(String mensagem) {
        System.out.println(mensagem);
        byte value = InputUtil.readByte();

        switch (value) {
            case 1:
                return AccountType.INDIVIDUAL_ACCOUNT;
            case 2:
                return AccountType.LEGAl_PERSON;
            default:
                readTypeAccount("Opção invalida tente novamente\n" +
                        "1:pessoa física\n" +
                        "2:pessoa jurídica\n");
                break;
        }
        return null;
    }

    public static void printMenuBank() {
        System.out.print("""
                -------    
                1:Depositar | 4:Saldo
                2:Sacar     | 5:Transferencia
                3:Extrato   | 6:Chaves
                            | 7:logout
                -------\n""");
    }

    public static void printMenuAccount() {
        System.out.print("""
                --------
                1:login
                2:create Account
                --------
                """);
    }
}
