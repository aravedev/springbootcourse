package com.myServices;

import com.myData.OrdersDataAccessInterface;
import com.myModels.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//@Service // this annotation must be used when we are applying @Autowired in controllers classes.
public class OrderBusinessService implements  OrdersBusinessServiceInterface{
    //
        // Remember that we must make reference our Interface : OrdersDataAccessInterface and not the OrdersFakeDAO
        // the interface is our blue print and it is the only one who handles our methods
        @Autowired
        OrdersDataAccessInterface ordersDAO;
    //

    @Override
    public void test() {
        System.out.println("OrderBusinessService is working");
    }

    @Override
    public OrderModel getById(long id) {
        return ordersDAO.getById(id);
    }

    @Override
    public List<OrderModel> getOrders() {

        return ordersDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        // Note: The business layer (logic) is OrdersFakeDao
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder);
    }

    @Override
    public boolean deleteOne(long id) {
        return ordersDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        return ordersDAO.updateOne(idToUpdate, updateOrder);
    }


    public void init() {
        System.out.println("Init method of the Orders Business Service");
    }


    public void destroy() {
        System.out.println("Destroy method of the Orders Business Service");
    }


}
