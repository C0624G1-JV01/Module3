package castudy3.service;

import castudy3.model.Account;

public interface IAccountService {
    Account login(String username, String password);

    void addAccount(Account newAccount);

    void updateAccount(Account currentAccount);
}
