package com.massafra.club.dispatch.dto.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UnlinkAccountDTO {

    private String name;
    private String cgc;
    private LocalDate birthDate;
    private String phone;
    private String password;
    private String address;
}
