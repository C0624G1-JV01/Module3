package case_fruit.service.Impl;

import case_fruit.model.Account;
import case_fruit.repository.IAccountRepository;
import case_fruit.repository.Impl.AccountRepository;
import case_fruit.service.IAccountService;


public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public Account login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getsetPassword().equals(password)) {
            return account;
        }
        return null;
    }

    @Override
    public void addAccount(Account newAccount) {
        if (newAccount != null) {
            accountRepository.save(newAccount);
        }
    }

    @Override
    public void updateAccount(Account currentAccount) {
        if (currentAccount != null && currentAccount.getId() > 0) {
            accountRepository.update(currentAccount);
        }
    }
}
