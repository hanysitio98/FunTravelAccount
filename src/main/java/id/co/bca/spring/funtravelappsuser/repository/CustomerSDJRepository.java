package id.co.bca.spring.funtravelappsuser.repository;

import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CustomerSDJRepository {
    CustomerModel findCustomerById(Integer aInteger);
    List<CustomerModel> findAllByOrderByLastName();
    Page<CustomerModel> findAllByOrderByEmail(Pageable pageable);
}
