package com.massafra.club.dispatch.mapper;

import com.massafra.club.dispatch.entities.FidemaxRedemption;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRedemptionRequestRecord;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface FidemaxRedemptionMapper {

    FidemaxRedemptionMapper INSTANCE = Mappers.getMapper(FidemaxRedemptionMapper.class);

    FidemaxRedemption redemptionRequestToRedemption(FidemaxCustomerRedemptionRequestRecord fidemaxCustomerRedemptionRequestRecord);

    FidemaxCustomerRedemptionRequestRecord redemptionToRedemptionRequest(FidemaxRedemption fidemaxRedemption);
}
