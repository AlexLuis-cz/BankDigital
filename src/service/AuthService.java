package service;

import engine.BankEngine;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class AuthService {
    BankEngine engine = new BankEngine();

    public void criarConta() {
        String nome = InputUtil.readNome("Nome:");
        String senha = InputUtil.readSenha("Senha:");
        engine.menuBanco(new Conta(nome, senha));
    }

    public void saque(ContaCorrente conta) {
        double valor = InputUtil.readValorSaque("Valor que deseja sacar:");

        if (valor > conta.getSaldo()) {//Validation to check if the check or withdrawal has funds.
            if (valor > conta.getCheque()) {
                System.out.println("Não sera possivel fazer o saque");
                engine.menuBanco(conta);
            } else {
                conta.setSaldo(conta.getSaldo() - valor);
                System.out.println("Saque De cheque Concluido!!");
                System.out.printf("Saque feito por:%s\n", conta.getNome());
                System.out.printf("Valor retirado:%.2f", valor);
                System.out.printf("\nSaldo Cheque Restante:%.2f", conta.getCheque());
            }
        } else {
            conta.setSaldo(conta.getSaldo() - valor);
            System.out.println("Saque De saldo Concluido!!");
            System.out.printf("Saque feito por:%s\n", conta.getNome());
            System.out.printf("Valor retirado:%.2f", valor);
            System.out.printf("\nSaldo Restante:%.2f\n", conta.getSaldo());
        }
    }
}
