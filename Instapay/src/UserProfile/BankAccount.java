package UserProfile;

public class BankAccount extends Account{
    String creditCardNumber;
    String creditCardPassword;
    BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardPassword() {
        return creditCardPassword;
    }

    public void setCreditCardPassword(String creditCardPassword) {
        this.creditCardPassword = creditCardPassword;
    }


}
