package com.massafra.club.dispatch.converters;


import com.massafra.club.dispatch.records.internal.FidemaxCustomerInternalRecord;
import com.massafra.club.dispatch.records.request.FidemaxCustomerAddressRequestRecord;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRequestRecord;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class FidemaxCustomerConverter extends AbstractConverter<FidemaxCustomerInternalRecord, FidemaxCustomerRequestRecord> {
    @Override
    protected FidemaxCustomerRequestRecord convert(FidemaxCustomerInternalRecord fidemaxCustomer) {
        var customerAddress = new FidemaxCustomerAddressRequestRecord(fidemaxCustomer.street(), fidemaxCustomer.zipCode(), fidemaxCustomer.neighborhood(), fidemaxCustomer.complement());

        return new FidemaxCustomerRequestRecord(fidemaxCustomer.name(),
                fidemaxCustomer.cgc(),
                fidemaxCustomer.birthDate(),
                fidemaxCustomer.phone(),
                fidemaxCustomer.password(),
                customerAddress);
    }
}