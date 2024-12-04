package com.massafra.club.dispatch.entities;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(collection = "fidemax_redemption")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FidemaxRedemption {

    @Indexed(name = "redemption_id")
    @JsonAlias({"id", "redemptionId"})
    @JsonProperty("redemptionId")
    private String id;

    @Indexed(name = "redemption_customer_id")
    private String customerId;

    @Indexed(name = "redemption_voucher")
    private String voucher;

    @Indexed(name = "redemption_date_received")
    private LocalDateTime dateReceived;

    private String name;

    private String email;

    private String gender;

    private String birthday;

    private String phone;

    private String rewardDescription;

    private BigDecimal pointsAmount;

    private BigDecimal amountRewards;

    private BigDecimal cashback;
}
