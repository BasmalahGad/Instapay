package Transactions;

import Connections.BankAPI;
import UserInterface.InstapaySystem;
import UserProfile.WalletAccount;

public class WalletContext extends Context{
    private WalletAccount walletAccount;
    private BankAPI bankAPI;
    public WalletContext() {
        walletAccount = (WalletAccount) InstapaySystem.curUser.getInstapayProfile().getAccount();
        super.setBalance(bankAPI.getBalance(walletAccount.getPhoneNumber()));
    }

    @Override
    public void payBill() throws Exception {
        if(super.getBalance() >= super.getBillService().getBill().getAmount()){
            bankAPI.deposit(walletAccount.getPhoneNumber(), super.getBalance() - super.getBillService().getBill().getAmount());
            super.getBillService().deduct();
        }else{
            throw new Exception();
        }
    }
}
