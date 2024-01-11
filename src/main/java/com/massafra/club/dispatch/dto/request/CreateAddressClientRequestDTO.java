package com.massafra.club.dispatch.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateAddressClientRequestDTO {

    @JsonProperty("cep")
    private String zipCode;

    @JsonProperty("numero")
    private String number;

    @JsonProperty("rua")
    private String streetName;

    @JsonProperty("bairro")
    private String neighborhood;

    @JsonProperty("complemento")
    private String reference;


}
