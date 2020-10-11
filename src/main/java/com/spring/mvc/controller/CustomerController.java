package com.spring.mvc.controller;

import com.spring.mvc.entity.Customer;
import com.spring.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("customer")
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") Long customerId, Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);

        return "redirect:/customer/list";
    }
}
