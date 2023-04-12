package id.co.bca.spring.funtravelappsuser.repository;

import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import java.util.List;

public interface ICustomerRepository {
    void create(CustomerModel customer);
    List<CustomerModel> retrieveAll();
    CustomerModel retrieveUnique(CustomerModel customer);
    void update(CustomerModel customer);
    void deleteUnique(CustomerModel customer);
}
