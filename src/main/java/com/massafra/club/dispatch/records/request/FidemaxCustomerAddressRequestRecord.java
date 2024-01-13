package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FidemaxCustomerAddressRequestRecord(@JsonProperty("rua") String street,
                                                  @JsonProperty("cep") String zipCode,
                                                  @JsonProperty("bairro") String neighborhood,
                                                  @JsonProperty("complemento") String complement) {
}
