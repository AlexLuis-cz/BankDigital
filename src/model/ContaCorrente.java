package model;

public class ContaCorrente extends Conta {
    private double cheque;
    private final Conta conta;

    public ContaCorrente(Conta conta) {
        super();
        this.conta = conta;
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
