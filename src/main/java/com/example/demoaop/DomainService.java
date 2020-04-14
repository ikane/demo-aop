package com.example.demoaop;

import com.example.demoaop.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DomainService {

    private final RabbitMQSender rabbitMQSender;

    public DomainService(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    public void publish(Customer customer) {
        rabbitMQSender.createCustomer(customer);
    }

    public Object getDomainObjectById(Long id)
    {
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            //do some logging
        }
        return id;
    }
}
