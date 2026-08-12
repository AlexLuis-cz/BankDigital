package util;

import model.AccountType;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static String readNome(String mensagem) {
        System.out.print(mensagem);
        sc.nextLine();
        return sc.nextLine();
    }

    public static String readSenha(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static byte readByte() {
        return sc.nextByte();
    }

    public static double readValorSaque(String mensagem) {
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
                return AccountType.LEGAl_PERSON;
            case 2:
                return AccountType.INDIVIDUAL_ACCOUNT;
            default:
                readTypeAccount("Opção invalida tente novamente\n" +
                        "1:pessoa física\n" +
                        "2:pessoa jurídica\n");
                break;
        }
        return null;
    }
}
