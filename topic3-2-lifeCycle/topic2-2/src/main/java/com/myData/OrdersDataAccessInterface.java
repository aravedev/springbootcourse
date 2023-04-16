package com.myData;

import com.myModels.OrderModel;

import java.util.List;

public interface OrdersDataAccessInterface {

    // Here we are going to create our CRUD APP blue print

    public OrderModel getById(long id);
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String searchTerm);

    public long addOne(OrderModel newOrder); // this will be implemented when we use a DB

    public boolean deleteOne(long id);

    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);

}
