package id.co.bca.spring.funtravelappsuser.service;

import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import java.util.List;

public interface ICustomerService {
    void insert(CustomerModel customer);
    void update(CustomerModel customer);
    void delete(CustomerModel customer);
    CustomerModel findTheCustomer(CustomerModel customer);
    List<CustomerModel> allCustomers();
    List<CustomerModel> allCustomersPage(int page, int size);
}
