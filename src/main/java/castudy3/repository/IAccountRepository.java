package castudy3.repository;

import castudy3.model.Account;

public interface IAccountRepository {
    Account findByUsername(String username);

    void save(Account newAccount);

    void update(Account currentAccount);
}
