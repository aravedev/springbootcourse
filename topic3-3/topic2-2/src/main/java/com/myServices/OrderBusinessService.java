package com.myServices;

import com.myModels.OrderModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//@Service // this annotation must be used when we are applying @Autowired in controllers classes.
public class OrderBusinessService implements  OrdersBusinessServiceInterface{

    @Override
    public void test() {
        System.out.println("OrderBusinessService is working");
    }

    @Override
    public List<OrderModel> getOrders() {

        // generate some orders
        // this version of the app will send a hard coded list of orders

        List<OrderModel> orders = new ArrayList<OrderModel>();

        orders.add(new OrderModel(0L,"000","Sky diving experience",1500.0f,1));
        orders.add(new OrderModel(1L,"001","Space X zero gravity",5500.0f,1));
        orders.add(new OrderModel(2L,"002","Zip line the Gran Canyon",500.0f,2));
        orders.add(new OrderModel(3L,"003","Violin Lessons Norway",2500.0f,2));
        orders.add(new OrderModel(4L,"004","Scuba dive jellyfish lake in Palau",1800.0f,2));
        orders.add(new OrderModel(5L,"005","Beach Resort Thailand",1100.0f,3));
        orders.add(new OrderModel(6L,"006","Nature experience in the Amazon",1600.0f,3));
        orders.add(new OrderModel(7L,"007","Africa Safari - share with lions",2800.0f,5));
        orders.add(new OrderModel(8L,"008","Lovely night in Paris",3500.0f,2));
        orders.add(new OrderModel(9L,"009","Disney World Orlando",11300.0f,6));
        orders.add(new OrderModel(10L,"010","Panaca Parque del Cafe",1000.0f,6));

        return orders;
    }
}
