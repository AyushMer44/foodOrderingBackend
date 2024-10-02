package com.ayush.Service;

import com.ayush.Model.Order;
import com.ayush.Response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {
    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
