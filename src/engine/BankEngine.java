package engine;

import model.Conta;
import model.ContaCorrente;
import service.AuthService;
import util.InputUtil;

public class BankEngine {
    AuthService authService = new AuthService();

    public void menu() {
        System.out.println("""
                1:Entrar
                2:Criar""");
        byte esc = InputUtil.readByte();
        if (esc == 2) {
            authService.criarConta();
        }
    }

    public void menuBanco(Conta conta) {
        ContaCorrente contaCorrente = new ContaCorrente(conta);
        System.out.println("""
                1:Depositar
                2:Sacar
                """);
        byte menu = InputUtil.readByte();

        if(menu == 2){
            authService.saque(contaCorrente);
        }
    }
}
