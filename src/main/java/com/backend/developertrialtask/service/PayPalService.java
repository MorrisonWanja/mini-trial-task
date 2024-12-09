package com.backend.developertrialtask.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PayPalService {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode}")
    private String mode;

    // Create APIContext on the fly for each request
    private APIContext getAPIContext() {
        return new APIContext(clientId, clientSecret, mode);
    }

    // Create a payment with PayPal
    public Payment createPayment(Double totalAmount, String currency, String description) throws PayPalRESTException {
        Amount amount = new Amount();
        amount.setTotal(String.format("%.2f", totalAmount));
        amount.setCurrency(currency);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(description);

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setTransactions(Arrays.asList(transaction));

        // Define return and cancel URLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setReturnUrl("http://localhost:8080/payment-success");
        redirectUrls.setCancelUrl("http://localhost:8080/payment-cancel");
        payment.setRedirectUrls(redirectUrls);

        // Execute the payment creation
        return payment.create(getAPIContext());
    }

    // Execute the payment after the user approves it
    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);

        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        // Execute the payment
        return payment.execute(getAPIContext(), paymentExecution);
    }
}

