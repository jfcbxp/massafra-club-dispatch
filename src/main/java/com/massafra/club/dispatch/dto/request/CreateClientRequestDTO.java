package com.massafra.club.dispatch.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Builder
@Data
public class CreateClientRequestDTO {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cpf")
    private String cgc;

    @JsonProperty("sexo")
    private String gender;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonProperty("nascimento")
    private LocalDate birthDate;

    @JsonProperty("telefone")
    private String phone;

    @JsonProperty("senha")
    private String password;

    @JsonProperty("endereco")
    private CreateAddressClientRequestDTO address;


}
