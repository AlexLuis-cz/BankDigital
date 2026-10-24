package service;

import engine.BankEngine;
import model.Banco;
import model.Conta;
import util.InputUtil;

public class TransactionService implements Payments {
    private final static BankEngine bankEngine = new BankEngine();
    private final static Banco BANCO = new Banco();

    public void creatKey(Conta conta) {
        InputUtil.breakLine();

        String newKey = InputUtil.readNome("Nova chave de transação:");
        conta.setChaveTransacao(newKey);

        final BankEngine bankEngine = new BankEngine();
        bankEngine.menuBank(conta);
    }

    @Override
    public void transfer(Conta conta) {
        InputUtil.breakLine();
        String chaveDestinatario = InputUtil.readNome("Digite a chave pix:");

        for (Conta destinatario : BANCO.getContas()) {
            if (destinatario == null) return;

            if (chaveDestinatario.equals(destinatario.getChaveTransacao())) {
                double valor = InputUtil.readValorSaque("valor transferencia:");
                if (conta.getSaldo() >= valor || conta.getChequeContaCorrente() >= valor) {
                    conta.setSaldo(conta.getSaldo() - valor);
                    destinatario.setSaldo(destinatario.getSaldo() + valor);
                    bankEngine.menuBank(conta);
                }
            }
        }
        System.out.println("Usuario não encontrado");
        bankEngine.menuBank(conta);
    }
}
