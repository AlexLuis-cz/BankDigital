package model;

public enum AccountType {
    INDIVIDUAL_ACCOUNT("Pessoa fisica", 1),
    LEGAl_PERSON("Pessoa juridica", 2);

    private final String TYPE_ACCOUNT;
    private final int TYPE_NUMBER;


    AccountType(String TYPE_ACCOUNT, int TYPE_NUMBER) {
        this.TYPE_ACCOUNT = TYPE_ACCOUNT;
        this.TYPE_NUMBER = TYPE_NUMBER;
    }

    public int getTypeNumber() {
        return TYPE_NUMBER;
    }

    public String getTipoDaConta() {
        return this.TYPE_ACCOUNT;
    }
}
