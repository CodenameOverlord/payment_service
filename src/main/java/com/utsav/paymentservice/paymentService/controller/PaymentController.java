package com.utsav.paymentservice.paymentService.controller;

import com.stripe.exception.StripeException;
import com.utsav.paymentservice.paymentService.dtos.CreatePaymentLinkReqDto;
import com.utsav.paymentservice.paymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkReqDto reqDto) throws StripeException {
        return paymentService.createPaymentLink(reqDto.getOrderId());

    }
}
