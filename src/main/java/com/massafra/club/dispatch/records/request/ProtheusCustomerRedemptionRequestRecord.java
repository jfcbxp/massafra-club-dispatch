package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProtheusCustomerRedemptionRequestRecord(@JsonProperty("metodo") String method,
                                                      @JsonProperty("content") FidemaxCustomerRedemptionRequestRecord request) {
}
