package id.co.bca.spring.funtravelappsuser.repository;

import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CustomerSDJRepository extends JpaRepository<CustomerModel, Integer> {
    CustomerModel findCustomerById(Integer aInteger);
    List<CustomerModel> findAllByOrderByLastName();
    Page<CustomerModel> findAllByOrderByEmail(Pageable pageable);

    /*
    @Query(nativeQuery = true, value = "SELECT CONCAT(c.first_name, ' ', c.last_name) as name, " +
            "c.email as email, a.username as username, a.password as password FROM customer as c LEFT JOIN account as a ON c.account_id = a.id;")
    List<CustomerWithAccount> findCustomerByIdWithAccount();
    */
}
