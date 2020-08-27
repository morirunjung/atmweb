package th.go.rd.atm.service;

import org.mindrot.jbcrypt.BCrypt;

import org.springframework.stereotype.Service;
import th.go.rd.atm.data.CustomerRepository;
import th.go.rd.atm.model.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {
//    private ArrayList<Customer> customerList;
//    private List<Customer> customerList;
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


//    @PostConstruct
//    public void postConstruct() {
//        this.customerList = new ArrayList<>();
//    }

    public Customer findCustomer(int id) {
//        for (Customer customer : customerList) {
//            if (customer.getId() == id)
//                return customer;
//        }
        return repository.findById(id);
//        return null;
    }
    public Customer checkPin(Customer inputCustomer) {
        // 1. หา customer ที่มี id ตรงกับพารามิเตอร์
        Customer storedCustomer = findCustomer(inputCustomer.getId());

        // 2. ถ้ามี id ตรง ให้เช็ค pin ว่าตรงกันไหม โดยใช้ฟังก์ชันเกี่ยวกับ hash
        if (storedCustomer != null) {
            String storedPin = storedCustomer.getPin();
            if (BCrypt.checkpw(inputCustomer.getPin(), storedPin))
                return storedCustomer;
        }
        // 3. ถ้าไม่ตรง ต้องคืนค่า null
        return null;
    }


    public void createCustomer(Customer customer) {
        // .... hash pin ....
        String hashPin = hash(customer.getPin());
        customer.setPin(hashPin);
//        customerList.add(customer);
        repository.save(customer);
    }

    public List<Customer> getCustomers() {
//        return new ArrayList<>(this.customerList);
        return repository.findAll();
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }


}
