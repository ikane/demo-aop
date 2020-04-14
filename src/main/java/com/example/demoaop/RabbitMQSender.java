package com.example.demoaop;

import com.example.demoaop.domain.Customer;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;
    private final Exchange exchange;

    public RabbitMQSender(RabbitTemplate rabbitTemplate, Exchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void createCustomer(Customer customer) {
        String routingKey = "customer.routingkey";
        this.rabbitTemplate.convertAndSend(this.exchange.getName(), routingKey, customer);
    }
}
