package service;

import engine.BankEngine;
import model.Banco;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class AuthService {

    public void criarConta() {
        BankEngine engine = new BankEngine();
        String nome = InputUtil.readNome("Nome:");
        String senha = InputUtil.readSenha("Senha:");
        Conta conta = new Conta(nome, senha);

        Banco.setContas(conta);
        engine.menuBanco(conta);
    }
}
