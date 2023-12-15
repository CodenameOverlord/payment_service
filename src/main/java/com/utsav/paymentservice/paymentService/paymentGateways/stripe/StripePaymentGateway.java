package com.utsav.paymentservice.paymentService.paymentGateways.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.utsav.paymentservice.paymentService.paymentGateways.PaymentGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway implements PaymentGateway {
    @Value("${stripe.secretKey}")
    private String stripeSecretKey;

    @Override
    public String generatePaymentLink(Long amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;
        ProductCreateParams productCreateParams =
                ProductCreateParams
                        .builder()
                        .setName("GenericProduct")
                        .build();
        Product product = Product.create(productCreateParams);


        PriceCreateParams priceCreateParams = PriceCreateParams.builder()
                .setCurrency("inr")
                .setUnitAmount(amount)
                .setProduct(product.getId())
                .build();
        Price price = Price.create(priceCreateParams);


        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
    }
}
