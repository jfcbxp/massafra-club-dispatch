package com.massafra.club.dispatch.converters;


import com.massafra.club.dispatch.records.internal.FidemaxLoyaltynternalRecord;
import com.massafra.club.dispatch.records.request.FidemaxLoyaltyRequestRecord;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class FidemaxOrderConverter extends AbstractConverter<FidemaxLoyaltynternalRecord, FidemaxLoyaltyRequestRecord> {
    @Override
    protected FidemaxLoyaltyRequestRecord convert(FidemaxLoyaltynternalRecord loyalty) {
        return new FidemaxLoyaltyRequestRecord(
                loyalty.cgc(),
                loyalty.phone(),
                loyalty.points(),
                loyalty.type(),
                loyalty.id(),
                loyalty.rollback()
        );
    }
}