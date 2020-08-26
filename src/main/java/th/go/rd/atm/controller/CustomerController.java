package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<>();

    //@RequestMapping("/customer")
    @GetMapping("/customer")
    public String getCustomerPage(Model model) {

//        ArrayList<Customer> customers = new ArrayList<>();
//        customers.add("Peter");
//        customers.add("Nancy");
//        customers.add("Rick");

//        customers.add(new Customer(1,"Peter",1234));
//        customers.add(new Customer(2,"Nancy",2345));
//        customers.add(new Customer(3,"Rick",3456));

        model.addAttribute("allCustomers", customers);
        return "customer";
    }
    @PostMapping("customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customers.add(customer);
        model.addAttribute("allCustomers", customers);
        return "redirect:customer";
    }

}
