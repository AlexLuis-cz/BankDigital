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
                1:Entrar
                2:Criar
                """);
        byte esc = InputUtil.readByte();
        if(esc == 1){
            AuthService.Entrar();
        }
        else if (esc == 2) {
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
                4:Sair
                -------""");
        System.out.println();

        byte menu = InputUtil.readByte();
        if (menu == 1) {
            depositService.Depositar(contaCorrente);
        } else if (menu == 2) {
            saqueService.saque(contaCorrente);
        } else if (menu == 3) {
            ExtratoService.depositos(contaCorrente);
            menuBanco(conta);
        }else if(menu == 4){
            menu();
        }
    }
}
