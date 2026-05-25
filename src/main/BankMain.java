package main;

import model.Banco;
import model.Conta;
import model.ContaCorrente;
import service.CreatContService;

public class BankMain {
    public static void main(String[] args) {
        CreatContService creatCont = new CreatContService();
        creatCont.criarConta();


        Banco banco = new Banco("Nuubank",0064);
        Banco banco2 = new Banco("Bradesco",1200);
        Conta conta = new Conta("marcela",banco);
        Conta conta2 = new Conta("marcelo",banco2);
        banco.setContas(conta);
        banco.setContas(conta2);

        ContaCorrente contaCorrente = new ContaCorrente(conta);

        contaCorrente.setSaldo(300);
        contaCorrente.saque(200);
        banco.mostrarContas();
        banco2.mostrarContas();
    }
}
