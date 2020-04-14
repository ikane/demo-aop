package com.example.demoaop;

import com.example.demoaop.domain.Address;
import com.example.demoaop.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {
        DomainService.class,
        LoggingAspect.class,
        AnnotationAwareAspectJAutoProxyCreator.class })
class LoggingAspectTest {

    @MockBean
    private RabbitMQSender sender;

    @Autowired
    private DomainService domainService;


    @SpyBean
    LoggingAspect loggingAspect;

    @Test
    void profileAllMethods() throws Throwable {

        Customer customer = Customer.builder().name("Ibrahima KANE")
                .email("irahima.kane@carrefour.com")
                .address(Address.builder().street("1 rue Antoine de Saint Exupery").zipCode("94270").country("FRANCE").build())
                .build();

        domainService.getDomainObjectById(1L);
        //domainService.publish(customer);

        //verify(sender).createCustomer(customer);

        verify(loggingAspect).profileAllMethods(any());
    }

    @Test
    void ppublishMethods() throws Throwable {

        Customer customer = Customer.builder().name("Ibrahima KANE")
                                    .email("irahima.kane@carrefour.com")
                                    .address(Address.builder().street("1 rue Antoine de Saint Exupery").zipCode("94270").country("FRANCE").build())
                                    .build();


        domainService.publish(customer);

        verify(sender).createCustomer(customer);
        verify(loggingAspect).testAfterReturning(any());
    }
}