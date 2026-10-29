package engine;

import model.Conta;
import service.AuthService;
import service.DepositService;
import service.SaqueService;
import service.TransactionService;
import util.InputUtil;

public class BankEngine {
    private final SaqueService SAQUE_SERVICE = new SaqueService();
    private final DepositService DEPOSIT_SERVICE = new DepositService();
    private final AuthService AUTH_SERVICE = new AuthService();
    private final TransactionService TRANSACTION_SERVICE = new TransactionService();

    public void menu() {
        InputUtil.printMenuAccount();

        byte esc = InputUtil.readByte();
        InputUtil.breakLine();

        switch (esc) {
            case 1:
                AUTH_SERVICE.loginRequest();
                break;
            case 2:
                AUTH_SERVICE.criarConta();
                break;
            default:
                menu();
                break;
        }
    }

    public void menuBank(Conta conta) {
        while (true) {
            InputUtil.printMenuBank();
            byte menu = InputUtil.readByte();

            switch (menu) {
                case 1:
                    //Deposito
                    DEPOSIT_SERVICE.depositar(conta);
                    break;
                case 2:
                    //Saque
                    SAQUE_SERVICE.lootMoney(conta);
                    break;
                case 3:
                    //Extrato
                    conta.getExtrato();
                    break;
                case 4:
                    //Saldo
                    System.out.println("Saldo:" + conta.getSaldo());
                    break;
                case 5:
                    //Transferencia
                    TRANSACTION_SERVICE.transfer(conta);
                    break;
                case 6:
                    if (conta.getChaveTransacao() == null) {
                        System.out.println("Sem Chaves cadastradas.");
                        TRANSACTION_SERVICE.creatKey(conta);
                    } else {
                        System.out.println("Chave de transação cadastrada:" + conta.getChaveTransacao());
                    }
                    break;
                case 7:
                    //logout
                    menu();
                    break;
                default:
                    System.out.println("invalid option");
                    InputUtil.breakLine();
                    break;
            }
        }
    }
}
