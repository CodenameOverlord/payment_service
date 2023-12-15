package com.utsav.paymentservice.paymentService.paymentGateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String generatePaymentLink(Long amount) throws StripeException;
}
