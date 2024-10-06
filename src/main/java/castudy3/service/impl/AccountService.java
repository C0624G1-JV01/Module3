package castudy3.service.impl;

import castudy3.model.Account;
import castudy3.repository.IAccountRepository;
import castudy3.repository.impl.AccountRepository;
import castudy3.service.IAccountService;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public Account login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
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
