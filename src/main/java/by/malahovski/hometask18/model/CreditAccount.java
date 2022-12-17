package by.malahovski.hometask18.model;

import java.math.BigDecimal;

public class CreditAccount {

    private Long id;
    private String creditAccountHolder;
    private BigDecimal accountAmount;
    private AccountCurrency  accountCurrency;

    public CreditAccount(Long id, String creditAccountHolder, BigDecimal accountAmount, AccountCurrency accountCurrency) {
        this.id = id;
        this.creditAccountHolder = creditAccountHolder;
        this.accountAmount = accountAmount;
        this.accountCurrency = accountCurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditAccountHolder() {
        return creditAccountHolder;
    }

    public void setCreditAccountHolder(String creditAccountHolder) {
        this.creditAccountHolder = creditAccountHolder;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public AccountCurrency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(AccountCurrency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
}
