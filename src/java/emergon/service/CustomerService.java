package emergon.service;

import emergon.dao.CustomerDao;
import emergon.entity.Customer;
import java.util.List;

public class CustomerService {
    CustomerDao cdao = new CustomerDao();
    
    public List<Customer> getCustomers(){
        return cdao.findAll();
    }
}
