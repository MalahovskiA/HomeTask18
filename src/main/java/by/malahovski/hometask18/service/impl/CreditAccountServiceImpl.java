package by.malahovski.hometask18.service.impl;

import by.malahovski.hometask18.model.CreditAccount;
import by.malahovski.hometask18.repository.CreditAccountRepository;
import by.malahovski.hometask18.service.CreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {

    private final CreditAccountRepository creditAccountRepository;

    @Autowired
    public CreditAccountServiceImpl(CreditAccountRepository creditAccountRepository) {
        this.creditAccountRepository = creditAccountRepository;
    }

    @Override
    public Boolean addCreditAccount(CreditAccount newAccount) {
        return creditAccountRepository.addAccountToRepository(newAccount);
    }

    @Override
    public CreditAccount getCreditAccountById(Long id) {
        return creditAccountRepository.getAccountByIdInRepository(id);
    }

    @Override
    public Boolean deleteCreditAccount(Long id) {
        return creditAccountRepository.deleteAccountInRepository(id);
    }

    @Override
    public Boolean updateCreditAccount(CreditAccount creditAccount) {
        return creditAccountRepository.updateAccountInRepository(creditAccount);
    }

    @Override
    public Boolean updateCreditAccountBySum(Long id, BigDecimal sum) {
        return creditAccountRepository.updateAccountBySum(id, sum);
    }
}
