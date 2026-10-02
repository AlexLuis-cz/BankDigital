package engine;

import model.Banco;
import model.Conta;
import model.ContaCorrente;
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
        System.out.print("""
                --------
                1:login
                2:create Account
                --------
                """);
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
        Banco banco = new Banco();
        System.out.print("""
                -------    
                1:Depositar | 4:Saldo
                2:Sacar     | 5:Transferencia
                3:Extrato   | 6:Chaves
                            | 7:logout
                -------\n""");
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

                break;
            case 6:
                if(conta.getChaveTransacao() == null){
                    System.out.println("Sem Chaves cadastradas.");
                    TRANSACTION_SERVICE.creatKey(conta);
                }else{
                    System.out.println("Chave de transação cadastrada:"+conta.getChaveTransacao());
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
    }
}
