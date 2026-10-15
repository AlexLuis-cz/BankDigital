package model;

public class ContaCorrente extends Conta {
    private double cheque;

    public ContaCorrente(Conta conta) {
        super(conta.nome, conta.email, conta.senha);
        this.saldo = conta.getSaldo();
    }

    //depositos
    public void setCheque(double cheque) {
        this.cheque = cheque;
    }

    //gets
    public double getCheque() {
        return this.cheque;
    }
}
