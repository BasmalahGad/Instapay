package UserProfile;

public class BankAccount extends Account{
    String creditCardNumber;
    BankName bankName;

    public BankAccount(String creditCardNumber, String creditCardPassword) {
        this.creditCardNumber = creditCardNumber;
        super.setAccountPassword(creditCardPassword);
    }

    public BankName getBankName() {
        return bankName;
    }

    public void setBankName(BankName bankName) {
        this.bankName = bankName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

}
