package engine;

import model.Banco;
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
        switch (esc) {
            case 1:
                AuthService.entrar();
                break;
            case 2:
                AuthService.criarConta();
                break;
            default:
                menu();
                break;
        }
    }

    public void menuBanco(Conta conta, ContaCorrente contaCorrente) {
        System.out.print("""
                -------    
                1:Depositar | 4:Saldo
                2:Sacar     | 5:Dados do usuario
                3:Extrato   | 6:logout
                -------\n""");


        byte menu = InputUtil.readByte();

        switch (menu) {
            case 1:
                //Deposito
                depositService.Depositar(conta, contaCorrente);
                break;
            case 2:
                //Saque
                saqueService.saque(conta, contaCorrente);
                break;
            case 3:
                //Extrato
                conta.getExtrato();
                menuBanco(conta, contaCorrente);
                break;
            case 4:
                //Saldo
                System.out.println(conta.getSaldo());
                menuBanco(conta, contaCorrente);
                break;
            case 5:
                //Dados do usuario
                Banco.validyLogin(conta,contaCorrente);
                menuBanco(conta, contaCorrente);
                break;
            case 6:
                //logout
                menu();
                break;
        }
    }
}
