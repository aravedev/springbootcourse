package com.myServices;

import com.myModels.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface {
    public void test();
    public void init();
    public void destroy();

    public OrderModel getById(long id);
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String searchTerm);

    public long addOne(OrderModel newOrder); // this will be implemented when we use a DB

    public boolean deleteOne(long id);

    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);
}
