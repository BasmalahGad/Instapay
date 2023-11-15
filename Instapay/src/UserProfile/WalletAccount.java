package UserProfile;

public class WalletAccount extends Account{
    WalletProvider walletProvider;
    String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    public WalletAccount(String walletNumber, String walletPassword) {
        super();
    }

    public WalletProvider getWalletProvider() {
        return walletProvider;
    }

    public void setWalletProvider(WalletProvider walletProvider) {
        this.walletProvider = walletProvider;
    }


}
