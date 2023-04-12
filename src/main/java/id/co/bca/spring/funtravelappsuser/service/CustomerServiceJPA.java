package id.co.bca.spring.funtravelappsuser.service;

import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import id.co.bca.spring.funtravelappsuser.repository.CustomerSDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceJPA implements ICustomerService {

    @Autowired
    CustomerSDJRepository sdjRepository;

    @Override
    public void insert(CustomerModel customer) {
        // sdjRepository.save(customer);
    }

    @Override
    public void update(CustomerModel customer) {
        // sdjRepository.save(customer);
    }

    @Override
    public void delete(CustomerModel customer) {
        // sdjRepository.deleteById(customer.getId());
    }

    @Override
    public CustomerModel findTheCustomer(CustomerModel customer) {
        return sdjRepository.findCustomerById(customer.getId());
    }

    @Override
    public List<CustomerModel> allCustomer() {
        return sdjRepository.findAllByOrderByLastName();
    }

    @Override
    public List<CustomerModel> allCustomerPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return sdjRepository.findAll(pageable).getContent();
    }
}
