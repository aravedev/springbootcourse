package com.dataValidation.topic22;

import com.myServices.OrderBusinessService;
import com.myServices.OrderBusinessService2;
import com.myServices.OrdersBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// we are creating a configuration file, to indicate Spring boot which Service must be run (orderBusinessService 1 or 2)

@Configuration
public class SpringConfig {


    @Bean(name="ordersBusinessService")
    // returning a interface, if we use this process we must get rid of @Service annotation in both OrderBusinessService
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new OrderBusinessService2();
    }
}
