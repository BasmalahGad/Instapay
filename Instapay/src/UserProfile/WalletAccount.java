package UserProfile;

public class WalletAccount extends Account{
    WalletProvider walletProvider;
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public WalletAccount(String walletNumber, String walletPassword) {
        this.phoneNumber = walletNumber;
        super.setAccountPassword(walletPassword);
    }

    public WalletProvider getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(WalletProvider walletProvider) {
        this.walletProvider = walletProvider;
    }


}
