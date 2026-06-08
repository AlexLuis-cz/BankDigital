package engine;

import model.Conta;
import model.ContaCorrente;
import service.AuthService;
import service.DepositService;
import service.ExtratoService;
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

    public void menuBanco(Conta conta) {
        ContaCorrente contaCorrente = new ContaCorrente(conta);
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
                depositService.Depositar(contaCorrente);
                break;
            case 2:
                saqueService.saque(contaCorrente);
                break;
            case 3:
                ExtratoService.depositos(contaCorrente);
                menuBanco(conta);
                break;
            case 4:
                System.out.println("Saldo:" + conta.getSaldo());
                menuBanco(conta);
                break;
            case 5:
                menu();
                break;
        }
    }
}
