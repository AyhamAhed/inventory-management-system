package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Exceptions.ForbiddenException;
import com.Springpro.Springpro.Exceptions.UnauthorizedException;
import com.Springpro.Springpro.Model.entity.CustomerModel;
import com.Springpro.Springpro.Service.CustomerService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/allData")
    public ResponseEntity<List<CustomerModel>> getAllCustomers() {
        List<CustomerModel> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/allDataById")
    public ResponseEntity<CustomerModel> getCustomerById(@RequestParam Integer id) {
        CustomerModel customers = customerService.getCustomerById(id);
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/insertCustomer")
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customer) {
        CustomerModel createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @PutMapping("/updateCustomerById")
    public ResponseEntity<CustomerModel> updateCustomer(@RequestParam Integer id, @RequestBody CustomerModel customer) {
        CustomerModel updatedCustomer = customerService.updateCustomer(id, customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteCustomerById")
    public ResponseEntity<Void> deleteCustomer(@RequestParam Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/updateCustomerPartially/{id}")
    public ResponseEntity<CustomerModel> partiallyUpdateCustomer(@PathVariable Integer id, @RequestBody CustomerModel customerUpdates) {
        CustomerModel updatedCustomer = customerService.partiallyUpdateCustomer(id, customerUpdates);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
//    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customer) {
//        try {
//            CustomerModel createdCustomer = customerService.createCustomer(customer);
//            // Return 201 Created status code with the created customer
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
//        } catch (BadRequestException e) {
//            // Return 400 Bad Request status code if there's an issue with the request body
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        } catch (UnauthorizedException e) {
//            // Return 401 Unauthorized status code if the request is not authorized
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        } catch (ForbiddenException e) {
//            // Return 403 Forbidden status code if the user is not allowed to create a customer
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//        } catch (ResourceNotFoundException e) {
//            // Return 404 Not Found status code if the resource is not found
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        } catch (Exception e) {
//            // Return 500 Internal Server Error status code for any other unexpected error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
