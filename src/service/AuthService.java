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
        String nome = InputUtil.readNome("Nome:");
        String email = InputUtil.readNome("Email:");
        String senha = InputUtil.readSenha("Senha:");


        Conta conta = new Conta(nome,email, senha);
        ContaCorrente contaCorrente = new ContaCorrente();
        conta.setContaCorrente(contaCorrente);

        Banco.setContas(conta);
        engine.menuBank(conta);
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
                bankEngine.menuBank(value);
                break;
            }
        }
    }
}
