package Transactions;

import Connections.BankAPI;
import Connections.WalletAPI;
import UserInterface.InstapaySystem;
import UserProfile.WalletAccount;

public class WalletBillPaymentMethod extends BillPaymentMethod {
    private WalletAccount walletAccount;
    private WalletAPI walletAPI;

    public WalletAccount getWalletAccount() {
        return walletAccount;
    }

    public void setWalletAccount(WalletAccount walletAccount) {
        this.walletAccount = walletAccount;
    }

    public WalletAPI getWalletAPI() {
        return walletAPI;
    }

    public void setWalletAPI(WalletAPI walletAPI) {

        this.walletAPI = walletAPI;
        initialize();
    }

    public WalletBillPaymentMethod() {

    }

    private void initialize(){
        walletAccount = (WalletAccount) InstapaySystem.curUser.getAccount();
        super.setBalance(walletAPI.getBalance(walletAccount.getPhoneNumber()));
    }
    @Override
    public void payBill() throws Exception {
        if(super.getBalance() >= super.getBillService().getBill().getAmount()){
            walletAPI.deposit(walletAccount.getPhoneNumber(), super.getBalance() - super.getBillService().getBill().getAmount());
            super.getBillService().deduct();
        }else{
            throw new Exception();
        }
    }
}
