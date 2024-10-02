package com.ayush.Controller;

import com.ayush.Model.Order;
import com.ayush.Model.User;
import com.ayush.Request.OrderRequest;
import com.ayush.Response.PaymentResponse;
import com.ayush.Service.OrderService;
import com.ayush.Service.PaymentService;
import com.ayush.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req,
                                                       @RequestHeader("Authorization") String jwt)throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req,user);

        PaymentResponse paymentResponse = paymentService.createPaymentLink(order);

        return new ResponseEntity<>(paymentResponse,HttpStatus.CREATED);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrders(@RequestHeader("Authorization") String jwt)throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getUserOrders(user.getId());
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}
