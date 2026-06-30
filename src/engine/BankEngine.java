package engine;

import model.Conta;
import model.ContaCorrente;
import service.AuthService;
import service.DepositService;
import service.SaqueService;
import util.InputUtil;

public class BankEngine {
    SaqueService saqueService = new SaqueService();
    DepositService depositService = new DepositService();

    public static void menu() {
        System.out.print("""
                --------
                1:Entrar
                2:Criar
                --------
                """);
        byte esc = InputUtil.readByte();
        if (esc == 1) {
            AuthService.Entrar();
        } else if (esc == 2) {
            AuthService.criarConta();
        }
    }

    public void menuBanco(Conta conta, ContaCorrente contaCorrente) {
        System.out.print("""
                -------
                1:Depositar
                2:Sacar
                3:Extrato
                4:Saldo
                5:Sair
                -------\n""");


        byte menu = InputUtil.readByte();

        switch (menu) {
            case 1:
                depositService.Depositar(conta,contaCorrente);
                break;
            case 2:
                saqueService.saque(conta,contaCorrente);
                break;
            case 3:
                conta.getExtrato();
                menuBanco(conta,contaCorrente);
                break;
            case 4:
                System.out.println(conta);
                menuBanco(conta,contaCorrente);
                break;
            case 5:
                menu();
                break;
        }
    }
}
