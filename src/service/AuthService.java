package service;

import engine.BankEngine;
import model.Banco;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class AuthService {

    public static void criarConta() {
        BankEngine engine = new BankEngine();
        String nome = InputUtil.readNome("Nome:");
        String senha = InputUtil.readSenha("Senha:");
        Conta conta = new Conta(nome, senha);

        Banco.setContas(conta);
        engine.menuBanco(conta);
    }

    public static void Entrar() {
        Banco banco = new Banco();
        String usuario = InputUtil.readNome("Usuario:");
        String senha = InputUtil.readSenha("Senha:");
        banco.loginRequest(usuario, senha);
    }
}
