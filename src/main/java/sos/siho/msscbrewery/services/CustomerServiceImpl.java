package sos.siho.msscbrewery.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sos.siho.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(customerId)
                .name("Saul Osbaldo Aponte Lopez").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return new CustomerDto().builder()
                .id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Update Customer....");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Delete Customer....");
    }
}
