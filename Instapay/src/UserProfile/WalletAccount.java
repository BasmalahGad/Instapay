package UserProfile;

public class WalletAccount extends Account{
    WalletProvider walletProvider;

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
