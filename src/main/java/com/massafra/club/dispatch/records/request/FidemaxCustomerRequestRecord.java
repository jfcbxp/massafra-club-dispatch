package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FidemaxCustomerRequestRecord(@JsonProperty("nome") String name,
                                           @JsonProperty("cpf") String cgc,
                                           @JsonProperty("telefone") String phone,
                                           @JsonProperty("senha") String password,
                                           @JsonProperty("endereco") FidemaxCustomerAddressRequestRecord address) {
}
