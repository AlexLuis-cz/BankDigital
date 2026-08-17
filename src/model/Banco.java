package model;

import engine.BankEngine;
import util.InputUtil;

import java.util.Scanner;

public class Banco {
    private static final Conta[] CONTAS = new Conta[100];
    private static int POSICAO = 0;
    private static BankEngine bankEngine;

    public Banco() {

    }

    public Conta[] getContas() {
        return CONTAS;
    }

    public void loginRequest(String usuario, String senha) {
        usuario = usuario.substring(0, 1).toUpperCase() + usuario.substring(1).toLowerCase();

        for (Conta value : Banco.CONTAS) {
            if (value == null) {
                System.out.println("Usuario ou senha incorretos");
                BankEngine.menu();
            }

            assert value != null;
            if (usuario.equals(value.nome) && senha.equals(value.senha)) {
                ContaCorrente contaCorrente = new ContaCorrente(value);

                System.out.println("login feito com sucesso");
                bankEngine.menuBanco(value, contaCorrente);
            } else {
                System.out.println("Usuario ou senha incorretos");
                BankEngine.menu();
            }
        }
    }

    public static void validyLogin(Conta conta, ContaCorrente contaCorrente){
        Scanner sc = new Scanner(System.in);
        String senha = sc.nextLine();

        if(senha.equals(conta.getSenha())){
            System.out.println(conta);
        }else{
            System.out.println("Algo deu errado deseja tentar novamente?");
            byte option = InputUtil.readByte();
            switch (option){
                case 1:
                    validyLogin(conta,contaCorrente);
                    break;
                case 2:
                    bankEngine.menuBanco(conta,contaCorrente);
            }
        }
    }

    public static void setContas(Conta conta) {
        Banco.CONTAS[POSICAO] = conta;
        POSICAO++;
    }
}
