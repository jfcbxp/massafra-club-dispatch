package com.massafra.club.dispatch.controller;


import com.massafra.club.dispatch.records.request.FidemaxCustomerRedemptionRequestRecord;
import com.massafra.club.dispatch.services.FidemaxRedemptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customers")
public class FidemaxRedemptionController {

    private final FidemaxRedemptionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public URI createRedemption(
            @RequestBody
            @Valid
            FidemaxCustomerRedemptionRequestRecord request) {

        service.createRedemption(request);

        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.voucher()).toUri();
    }
}