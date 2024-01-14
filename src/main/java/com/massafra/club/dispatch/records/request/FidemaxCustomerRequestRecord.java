package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public record FidemaxCustomerRequestRecord(@JsonProperty("nome") String name,
                                           @JsonProperty("cpf") String cgc,
                                           @JsonFormat(pattern = "dd/MM/yyyy")
                                           @JsonSerialize(using = LocalDateSerializer.class)
                                           @JsonDeserialize(using = LocalDateDeserializer.class)
                                           @JsonProperty("nascimento")
                                           LocalDate birthDate,
                                           @JsonProperty("telefone") String phone,
                                           @JsonProperty("senha") String password,
                                           @JsonProperty("endereco") FidemaxCustomerAddressRequestRecord address) {
}
