package service;

import engine.BankEngine;
import model.Banco;
import model.Conta;
import util.InputUtil;

public class TransactionService implements Payments {
    private final static BankEngine bankEngine = new BankEngine();

    public void creatKey(Conta conta) {
        InputUtil.breakLine();

        String newKey = InputUtil.readNome("Nova chave de transação:");
        conta.setChaveTransacao(newKey);

        bankEngine.menuBank(conta);
    }

    @Override
    public void transfer(Conta conta) {
        Banco BANCO = AuthService.getBANCO();

        InputUtil.breakLine();
        String chaveDestinatario = InputUtil.readNome("Digite a chave pix:");

        for (Conta destinatario : BANCO.getContas()) {

            if (chaveDestinatario.equals(destinatario.getChaveTransacao())) {
                double valor = InputUtil.readValorTransfer("valor transferencia:");

                //caso o valor digitado seja negativo ou 0
                if (valor <= 0) {
                    System.out.println("Valor invalido");
                    transfer(conta);
                }

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
