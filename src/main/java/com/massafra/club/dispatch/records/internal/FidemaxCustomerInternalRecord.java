package com.massafra.club.dispatch.records.internal;

import java.time.LocalDate;

public record FidemaxCustomerInternalRecord(String name,
                                            String cgc,
                                            String email,
                                            LocalDate birthDate,
                                            String phone,
                                            String password,
                                            String street,
                                            String zipCode,
                                            String neighborhood,
                                            String complement) {
}
