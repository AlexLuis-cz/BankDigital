package model;

public class ContaCorrente extends Conta {
    private double cheque;
    private final Conta conta;

    public ContaCorrente(Conta conta){
        super();
        this.conta = conta;
    }
    //depositos
    public void setCheque(double cheque){
        this.cheque = cheque;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    //gets
    public double getCheque(){
        return this.cheque;
    }
    public double getSaldo(){
        System.out.println("Saldo:"+this.saldo);
        return this.saldo;
    }

    public double conta(){
        return conta.saldo;
    }


    public void saque(double valor){
        if(valor > this.saldo){//Validation to check if the check or withdrawal has funds.
            if(valor > cheque){
                System.out.println("Não sera possivel fazer o saque");
            }
            else{
                this.cheque -= valor;
                System.out.println("Saque De cheque Concluido!!");
                System.out.printf("Saque feito por:%s\n",conta.nome);
                System.out.printf("Valor retirado:%.2f",valor);
                System.out.printf("\nSaldo Cheque Restante:%.2f",this.cheque);
            }
        }else{
            this.saldo -= valor;
            System.out.println("Saque De saldo Concluido!!");
            System.out.printf("Saque feito por:%s\n",conta.nome);
            System.out.printf("Valor retirado:%.2f",valor);
            System.out.printf("\nSaldo Restante:%.2f\n",this.saldo);
        }
    }
}
