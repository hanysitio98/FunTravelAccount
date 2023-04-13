package id.co.bca.spring.funtravelappsuser.service;

import id.co.bca.spring.funtravelappsuser.model.AccountModel;
import id.co.bca.spring.funtravelappsuser.model.CustomerModel;

public interface IAccountService {
    void insert(AccountModel account);
    void update(AccountModel account);
    void delete(AccountModel account);
    AccountModel findTheAccount(AccountModel account);
}
