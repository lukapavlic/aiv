package si.um.feri.bank.vao;

import si.um.feri.bank.Constants;
import java.math.BigDecimal;

public class PremiumBankAccount extends BankAccount {

    public PremiumBankAccount(String iban) {
        super(iban);
    }

    private double allowedLimit=Constants.ALLOWED_LIMIT_PREMIUM_ACCOUNT;

    @Override
    public BigDecimal depositMoney(BigDecimal amount) {
        log.info("Thank you. It was a pleasure to work with you.");
        super.depositMoney(amount);
        return currentBalance;
    }

    @Override
    public void donate(String purpose, double amount) {
        log.info("I donate "+ amount +" for "+ purpose);
        withdrawMoney(new BigDecimal(amount),"Donation: "+ purpose);
    }

    public double getAllowedLimit() {
        return allowedLimit;
    }

    public void setAllowedLimit(double allowedLimit) {
        this.allowedLimit = allowedLimit;
    }

    @Override
    public String toString() {
        return "PremiumBankAccount{" +
                "allowedLimit=" + allowedLimit +
                "} -> "+super.toString();
    }

}
