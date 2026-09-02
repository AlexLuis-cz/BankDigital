package model;

public enum AccountType {
    INDIVIDUAL_ACCOUNT("Pessoa fisica", 1),
    LEGAl_PERSON("Pessoa juridica", 2);

    private final int typeNumber;
    private final String typeAccount;


    AccountType(String typeAccount, int typeNumber) {
        this.typeNumber = typeNumber;
        this.typeAccount = typeAccount;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public String getTipoDaConta() {
        return this.typeAccount;
    }
}
