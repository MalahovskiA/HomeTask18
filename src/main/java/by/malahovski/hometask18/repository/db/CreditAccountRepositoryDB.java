package by.malahovski.hometask18.repository.db;

import by.malahovski.hometask18.model.AccountCurrency;
import by.malahovski.hometask18.model.CreditAccount;
import by.malahovski.hometask18.repository.CreditAccountRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreditAccountRepositoryDB implements CreditAccountRepository {

    private static Long lastId;

    Map<Long, CreditAccount> accounts = new HashMap<>();

    {
        accounts.put(1L, new CreditAccount(1L, "Ivan Ivanov", BigDecimal.valueOf(1_000_000), AccountCurrency.BYN));
        accounts.put(2L, new CreditAccount(2L, "Ivan Ivanov", BigDecimal.valueOf(7_000.50), AccountCurrency.EUR));
        accounts.put(3L, new CreditAccount(3L, "Petr Petrov", BigDecimal.valueOf(15_000.10), AccountCurrency.USD));
        accounts.put(4L, new CreditAccount(4L, "Arseni Rubak", BigDecimal.valueOf(18_000_000.25), AccountCurrency.RUB));
        lastId = 4L;
    }

    @Override
    public Boolean addAccountToRepository(CreditAccount creditAccount) {
        if (accounts.containsValue(creditAccount)) {
            return false;
        } else {
            Long id = ++lastId;
            creditAccount.setId(id);
            accounts.put(id, creditAccount);
            return true;
        }
    }

    @Override
    public CreditAccount getAccountByIdInRepository(Long id) {
        return accounts.get(id);
    }

    @Override
    public Boolean deleteAccountInRepository(Long id) {
        if (accounts.containsKey(id)) {
            accounts.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateAccountInRepository(CreditAccount creditAccount) {
        Long id = creditAccount.getId();
        if (accounts.containsKey(id)) {
            creditAccount.setId(id);
            accounts.put(id, creditAccount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateAccountBySum(Long id, BigDecimal sum) {
        if (accounts.containsKey(id)) {
            BigDecimal currentSum = accounts.get(id).getAccountAmount();
            currentSum = currentSum.add(sum);
            accounts.get(id).setAccountAmount(currentSum);
            return true;
        }
        return false;
    }
}
