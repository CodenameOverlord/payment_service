package com.utsav.paymentservice.paymentService.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import com.utsav.paymentservice.paymentService.paymentGateways.PaymentGateway;
import com.utsav.paymentservice.paymentService.paymentGateways.stripe.StripePaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private StripePaymentGateway stripePaymentGateway;

    public String createPaymentLink(Long orderId) throws StripeException {
        return stripePaymentGateway.generatePaymentLink(10000L);
    }
}
