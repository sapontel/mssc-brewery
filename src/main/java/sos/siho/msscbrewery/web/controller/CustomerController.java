package sos.siho.msscbrewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sos.siho.msscbrewery.services.CustomerService;
import sos.siho.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path="/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable(value = "customerId")UUID cutstomerId){
        return new ResponseEntity<>(customerService.getCustomerById(cutstomerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        //TODO add hostname to url now
        headers.add("Location", "/api/v1/customer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable(value = "customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("customerId") UUID customerId) {
        this.customerService.deleteById(customerId);
    }

}
