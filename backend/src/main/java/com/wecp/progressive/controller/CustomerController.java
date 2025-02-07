package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

@Autowired
CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException  {
       return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
       
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId) throws SQLException {
        return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) throws SQLException {
        return new ResponseEntity<>(customerService.addCustomer(customers),HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable int customerId, @RequestBody Customers customers) throws SQLException {
        customerService.updateCustomer(customers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) throws SQLException {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   // @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomerSortedByName() throws SQLException{
        return new ResponseEntity<>(customerService.getAllCustomersSortedByName(),HttpStatus.OK);
    }
    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
        return null;
    }
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersArraylist(){
        return new ResponseEntity<>(customerService.getAllCustomersFromArrayList(),HttpStatus.OK);
    }

    // @ExceptionHandler(SQLException.class)
    // public String handleException(SQLException msg){
    //     return msg.getMessage();
    // }
}
