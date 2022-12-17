package by.malahovski.hometask18.repository;

import by.malahovski.hometask18.model.CreditAccount;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface CreditAccountRepository {

    Boolean addAccountToRepository(CreditAccount creditAccount);

    CreditAccount getAccountByIdInRepository(Long id);

    Boolean deleteAccountInRepository(Long id);

    Boolean updateAccountInRepository(CreditAccount creditAccount);

    Boolean updateAccountBySum(Long id, BigDecimal sum);
}
