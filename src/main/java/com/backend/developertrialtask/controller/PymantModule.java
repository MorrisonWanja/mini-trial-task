package com.backend.developertrialtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.developertrialtask.service.PayPalService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("/payments")
public class PymantModule {
	@Autowired
    private PayPalService payPalService;

    @PostMapping("/create")
    public String createPayment(@RequestParam("tier") String tier,
                                @RequestParam("branches") int branches) throws PayPalRESTException {
        double basePrice = 0;
        double additionalBranchPrice = 1;
        double totalPrice = 0;

        // Define subscription tier prices
        if ("Starter".equals(tier)) basePrice = 1;
        else if ("Pro".equals(tier)) basePrice = 3;
        else if ("Enterprise".equals(tier)) basePrice = 5;

        // Calculate total price
        totalPrice = basePrice + (branches > 1 ? (branches - 1) * additionalBranchPrice : 0);

        // Create payment
        Payment payment = payPalService.createPayment(totalPrice, "GBP", tier + " Subscription");

        return "Payment created. Approve the payment here: " + payment.getLinks().get(1).getHref();
    }

    @GetMapping("/success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
            	return "Payment successful: " + payment.getState();
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
    
    
    @GetMapping("/cancel")
    public String paymentCancel() {
        return "Payment was cancelled.";
    }

}
