package by.malahovski.hometask18.service;

import by.malahovski.hometask18.model.CreditAccount;

import java.math.BigDecimal;


public interface CreditAccountService {
    Boolean addCreditAccount(CreditAccount newAccount);

    CreditAccount getCreditAccountById(Long id);

    Boolean deleteCreditAccount(Long id);

    Boolean updateCreditAccount(CreditAccount creditAccount);

    Boolean updateCreditAccountBySum(Long id, BigDecimal sum);
}
