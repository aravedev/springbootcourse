package com.myServices;

import com.myModels.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface {
    public void test();

    public List<OrderModel> getOrders();

    // future methods

    // SearchOrders(String searchTerm)

    // addOrder(OrderModel newObj)

    // deleteOrder(Long id)

    // updateOrder(OrderModel updateMe)

    // getOneOrder(Long id)
}
