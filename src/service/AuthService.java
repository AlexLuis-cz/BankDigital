package service;

import engine.BankEngine;
import model.AccountType;
import model.Banco;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class AuthService {

    public static void criarConta() {
        BankEngine engine = new BankEngine();
        String nome = InputUtil.readNome("Nome:");
        String senha = InputUtil.readSenha("Senha:");

        AccountType accountType = InputUtil.readTypeAccount("Tipo da conta\n" +
                "1:pessoa física\n" +
                "2:pessoa jurídica");

        Conta conta = new Conta(nome, senha, accountType);
        ContaCorrente contaCorrente = new ContaCorrente(conta);

        Banco.setContas(conta);
        engine.menuBanco(conta, contaCorrente);
    }

    public static void Entrar() {
        Banco banco = new Banco();
        String usuario = InputUtil.readNome("Usuario:");
        String senha = InputUtil.readSenha("Senha:");
        banco.loginRequest(usuario, senha);
    }
}
