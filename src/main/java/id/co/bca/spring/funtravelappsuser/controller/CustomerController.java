package id.co.bca.spring.funtravelappsuser.controller;

import id.co.bca.spring.funtravelappsuser.model.AccountModel;
import id.co.bca.spring.funtravelappsuser.model.CustomerModel;
import id.co.bca.spring.funtravelappsuser.repository.AccountSDJRepository;
import id.co.bca.spring.funtravelappsuser.repository.CustomerSDJRepository;
import id.co.bca.spring.funtravelappsuser.service.IAccountService;
import id.co.bca.spring.funtravelappsuser.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    @Qualifier("customerServiceJPA")
    private ICustomerService customerService;

    @Autowired
    @Qualifier("accountServiceJPA")
    private IAccountService accountService;

    @GetMapping("/all")
    public @ResponseBody List<CustomerModel> findAll() {
        return customerService.allCustomers();
    }

    @GetMapping("/allpage")
    public @ResponseBody List<CustomerModel> findAllPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return customerService.allCustomersPage(page, size);
    }

    @GetMapping("/id")
    public @ResponseBody CustomerModel getCustomer(@RequestParam("id") int id) {
        CustomerModel model = new CustomerModel();
        model.setId(id);
        return customerService.findTheCustomer(model);
    }

    @GetMapping("/add")
    public String addCustomer(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname,
                              @RequestParam("email") String email) {
        CustomerModel model = new CustomerModel();
        model.setId(0);
        model.setFirstName(firstname);
        model.setLastName(lastname);
        model.setEmail(email);
        customerService.insert(model);

        return "redirect:/customer/all";
    }

    @GetMapping("/addwithaccount")
    public String addCustomerWithAccount(@RequestParam("firstname") String firstname,
                                         @RequestParam("lastname") String lastname,
                                         @RequestParam("email") String email,
                                         @RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        AccountModel accountModel = new AccountModel();
        accountModel.setUsername(username);
        accountModel.setPassword(password);
        accountService.insert(accountModel);

        CustomerModel customerModel = new CustomerModel();
        customerModel.setFirstName(firstname);
        customerModel.setLastName(lastname);
        customerModel.setEmail(email);
        customerModel.setAccountModel(accountModel);
        customerService.insert(customerModel);

        return "redirect:/customer/all";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") int id,
                                 @RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastname,
                                 @RequestParam("email") String email) {
        CustomerModel model = new CustomerModel();
        model.setId(id);
        model.setFirstName(firstname);
        model.setLastName(lastname);
        model.setEmail(email);
        customerService.update(model);

        return "redirect:/customer/all";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        CustomerModel model = new CustomerModel();
        model.setId(id);
        customerService.delete(model);

        return "redirect:/customer/all";
    }

    @GetMapping("/login")
    public @ResponseBody AccountModel accountLogin(@RequestParam("username") String username,
                                                   @RequestParam("password") String password) {
        AccountModel accountModel = new AccountModel();
        accountModel.setUsername(username);
        accountModel.setPassword(password);
        return accountService.findTheAccount(accountModel);
    }
}
