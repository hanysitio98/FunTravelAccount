package id.co.bca.spring.funtravelappsuser.repository;

import id.co.bca.spring.funtravelappsuser.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSDJRepository extends JpaRepository<AccountModel, Integer> {
    AccountModel findAccountById(Integer aInteger);
    AccountModel findAccountByUsernameAndPassword(String username, String password);
}
