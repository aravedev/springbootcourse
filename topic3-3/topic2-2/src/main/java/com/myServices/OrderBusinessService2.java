package com.myServices;

import com.myModels.OrderModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service // this annotation must be used when we are applying @Autowired in controllers classes.
//@Primary
public class OrderBusinessService2 implements  OrdersBusinessServiceInterface{

    @Override
    public void test() {
        System.out.println("OrderBusinessService is working");
    }

    @Override
    public List<OrderModel> getOrders() {

        // generate some orders
        // this version of the app will send a hard coded list of orders

        List<OrderModel> orders = new ArrayList<OrderModel>();

        orders.add(new OrderModel(0L,"AAA","Pizza Hut",15.0f,1));
        orders.add(new OrderModel(1L,"AAB","Subway BBQ Ribs",16.2f,1));
        orders.add(new OrderModel(2L,"AAC","Apple pie",5.0f,2));
        orders.add(new OrderModel(2L,"AAC","Soft Drinks",5.0f,2));


        return orders;
    }
}
