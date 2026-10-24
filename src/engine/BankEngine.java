package engine;

import model.Conta;
import service.AuthService;
import service.DepositService;
import service.SaqueService;
import service.TransactionService;
import util.InputUtil;

import java.util.InputMismatchException;

public class BankEngine {
    private final SaqueService SAQUE_SERVICE = new SaqueService();
    private final DepositService DEPOSIT_SERVICE = new DepositService();
    private final AuthService AUTH_SERVICE = new AuthService();
    private final TransactionService TRANSACTION_SERVICE = new TransactionService();

    public void menu() {
        InputUtil.printMenuAccount();
        try {
            byte esc = InputUtil.readByte();
            InputUtil.breakLine();
            switch (esc) {
                case 1:
                    AUTH_SERVICE.loginRequest();
                    break;
                case 2:
                    AUTH_SERVICE.criarConta();
            }

        } catch (InputMismatchException e) {
            InputUtil.breakLine();
            menu();
        }
    }

    public void menuBank(Conta conta) {
        InputUtil.printMenuBank();

        while (true) {
            try {
                byte menu = InputUtil.readByte();

                switch (menu) {
                    case 1:
                        //Deposito
                        DEPOSIT_SERVICE.Depositar(conta);
                        break;
                    case 2:
                        //Saque
                        SAQUE_SERVICE.lootMoney(conta);
                        break;
                    case 3:
                        //Extrato
                        conta.getExtrato();
                        menuBank(conta);
                        break;
                    case 4:
                        //Saldo
                        System.out.println(conta.getSaldo());
                        menuBank(conta);
                        break;
                    case 5:
                        //Transferencia
                        TRANSACTION_SERVICE.transfer(conta);
                        menuBank(conta);
                        break;
                    case 6:
                        if (conta.getChaveTransacao() == null) {
                            System.out.println("Sem Chaves cadastradas.");
                            TRANSACTION_SERVICE.creatKey(conta);
                        } else {
                            System.out.println("Chave de transação cadastrada:" + conta.getChaveTransacao());
                            menuBank(conta);
                        }
                        break;
                    case 7:
                        //logout
                        menu();
                        break;
                    default:
                        System.out.println("invalid option");
                        menuBank(conta);
                }
            } catch (InputMismatchException e) {
                InputUtil.breakLine();
                menuBank(conta);
            }
        }
    }
}
