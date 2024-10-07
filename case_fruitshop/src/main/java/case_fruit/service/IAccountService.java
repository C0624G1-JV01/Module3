package case_fruit.service;

import case_fruit.model.Account;

public interface IAccountService {
    Account login(String username, String password);

    void addAccount(Account newAccount);

    void updateAccount(Account currentAccount);
}
