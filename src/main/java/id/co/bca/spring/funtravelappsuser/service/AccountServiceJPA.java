package id.co.bca.spring.funtravelappsuser.service;

import id.co.bca.spring.funtravelappsuser.model.AccountModel;
import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import id.co.bca.spring.funtravelappsuser.repository.AccountSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceJPA implements IAccountService {

    @Autowired
    AccountSDJRepository sdjRepository;

    @Override
    public void insert(AccountModel account) {
        sdjRepository.save(account);
    }

    @Override
    public void update(AccountModel account) {
        sdjRepository.save(account);
    }

    @Override
    public void delete(AccountModel account) {
        sdjRepository.deleteById(account.getId());
    }

    @Override
    public AccountModel findTheAccount(AccountModel account) {
        return sdjRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
    }
}
