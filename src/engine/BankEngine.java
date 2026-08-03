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
        switch(esc){
            case 1:
                AuthService.Entrar();
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
                2:Sacar     | 5:Saldo cheque
                3:Extrato   | 6:logout
                -------\n""");


        byte menu = InputUtil.readByte();

        switch (menu) {
            case 1:
                //depositar
                depositService.Depositar(conta, contaCorrente);
                break;
            case 2:
                //sacar
                saqueService.saque(conta, contaCorrente);
                break;
            case 3:
                //extrato
                conta.getExtrato();
                menuBanco(conta, contaCorrente);
                break;
            case 4:
                //saldo
                System.out.println(conta);
                menuBanco(conta, contaCorrente);
                break;
            case 5:
                //saldo cheque
                System.out.println("Saldo de cheque:" + contaCorrente.getCheque());
                menuBanco(conta, contaCorrente);
                break;
            case 6:
                //logout
                menu();
                break;
        }
    }
}
