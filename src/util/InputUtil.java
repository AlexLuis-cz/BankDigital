package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    public static String readNome(String mensagem) {
        System.out.print(mensagem);
        sc.nextLine();
        return sc.nextLine();
    }

    public static String readSenha(String mensagem){
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static byte readByte() {
        return sc.nextByte();
    }

    public static double readValorSaque(String mensagem){
        System.out.print(mensagem);
        return sc.nextDouble();
    }
}
