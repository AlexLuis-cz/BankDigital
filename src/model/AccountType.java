package model;

public enum AccountType {
    INDIVIDUAL_ACCOUNT("Pessoa fisica",1),
    LEGAl_PERSON("Pessoa juridica",2);

    private final int typeNumber;
    private final String tipoDaConta;


    AccountType(String tipoDaConta,int typeNumber) {
        this.typeNumber = typeNumber;
        this.tipoDaConta = tipoDaConta;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public String getTipoDaConta(){
        return this.tipoDaConta;
    }
}
