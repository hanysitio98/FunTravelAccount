package id.co.bca.spring.funtravelappsuser.service;

import id.co.bca.spring.funtravelappsuser.model.AccountModel;
import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import id.co.bca.spring.funtravelappsuser.repository.AccountSDJRepository;
import id.co.bca.spring.funtravelappsuser.repository.CustomerSDJRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountAndCustomerService {

    @Autowired
    AccountSDJRepository accountSDJRepository;

    @Autowired
    CustomerSDJRepository customerSDJRepository;

    @Transactional
    public void addCustomerToAccountWithTransactional(CustomerModel customerModel, int accountId) {
        customerSDJRepository.save(customerModel);
        AccountModel accountModel = accountSDJRepository.findAccountById(Integer.valueOf(accountId));
        accountSDJRepository.save(accountModel);
        customerModel.setAccountModel(accountModel);
        customerSDJRepository.save(customerModel);
    }
}
