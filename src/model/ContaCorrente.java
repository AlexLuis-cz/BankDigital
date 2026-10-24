package model;

public class ContaCorrente extends Conta {
    private double cheque;

    public ContaCorrente(Conta conta) {
        super(conta);
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
