package model;

public enum AccountType {
    INDIVIDUAL_ACCOUNT(1),
    LEGAl_PERSON(2);

    private final int typeNumber;

    AccountType(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }
}
