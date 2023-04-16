package com.dataValidation.topic22;

import com.myServices.OrderBusinessService;
import com.myServices.OrdersBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

// we are creating a configuration file, to indicate Spring boot which Service must be run (orderBusinessService 1 or 2)

@Configuration
public class SpringConfig {


    @Bean(name="ordersBusinessService" , initMethod = "init" , destroyMethod = "destroy") // init and destroy are in OrdersBusinessServiceInterface, they are methods
    // returning an interface, if we use this process we must get rid of @Service annotation in both OrderBusinessService
    @RequestScope // this means that our Bean is executed once and after of that it is destroyed.
    //@SessionScope // only works for the time the user has a session active, if we close the session or close the page, the bean is destroyed. Used for shopping cards
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new OrderBusinessService();
    }
}
