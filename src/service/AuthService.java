package service;

import engine.BankEngine;
import model.Banco;
import model.Conta;
import model.ContaCorrente;
import util.InputUtil;

public class AuthService {
    private final Banco banco = new Banco();
    private static BankEngine bankEngine = new BankEngine();

    public void criarConta() {
        BankEngine engine = new BankEngine();
        String email = InputUtil.readNome("Email:");
        String senha = InputUtil.readSenha("Senha:");


        Conta conta = new Conta(email, senha);
        ContaCorrente contaCorrente = new ContaCorrente(conta);

        Banco.setContas(conta);
        engine.menuBank(conta, contaCorrente);
    }

    public void loginRequest() {
        String email = InputUtil.readNome("Email:");
        String senha = InputUtil.readSenha("Senha:");

        for (Conta value : banco.getContas()) {
            if (value == null) {
                System.out.println("Usuario ou senha incorretos");
                loginRequest();
            }

            assert value != null;
            if (email.equals(value.getEmail()) && senha.equals(value.getSenha())) {
                System.out.println("login feito com sucesso");
                ContaCorrente contaCorrente = new ContaCorrente(value);
                bankEngine.menuBank(value, contaCorrente);
                break;
            }
        }
    }
}
