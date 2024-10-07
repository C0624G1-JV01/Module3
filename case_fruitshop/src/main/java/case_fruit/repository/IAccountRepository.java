package case_fruit.repository;


import case_fruit.model.Account;

public interface IAccountRepository {
    Account findByUsername(String username);

    void save(Account newAccount);

    void update(Account currentAccount);
}