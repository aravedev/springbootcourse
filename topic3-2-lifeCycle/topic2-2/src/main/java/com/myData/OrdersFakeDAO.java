package com.myData;

import com.myModels.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
* This class is where we manage our list data for the moment, because we dont have a DB :
* This is a Data Service.
* */

@Repository // Is used for data access.
public class OrdersFakeDAO implements OrdersDataAccessInterface {

    List<OrderModel> orders = new ArrayList<OrderModel>();

    // Constructor
    public OrdersFakeDAO() {

        // The constructor will have a default list of objects

        orders.add(new OrderModel(0L, "000", "Sky diving experience", 1500.0f, 1));
        orders.add(new OrderModel(1L, "001", "Space X zero gravity", 5500.0f, 1));
        orders.add(new OrderModel(2L, "002", "Zip line the Gran Canyon", 500.0f, 2));
        orders.add(new OrderModel(3L, "003", "Violin Lessons Norway", 2500.0f, 2));
        orders.add(new OrderModel(4L, "004", "Scuba dive jellyfish lake in Palau", 1800.0f, 2));
        orders.add(new OrderModel(5L, "005", "Beach Resort Thailand", 1100.0f, 3));
        orders.add(new OrderModel(6L, "006", "Nature experience in the Amazon", 1600.0f, 3));
        orders.add(new OrderModel(7L, "007", "Africa Safari - share with lions", 2800.0f, 5));
        orders.add(new OrderModel(8L, "008", "Lovely night in Paris", 3500.0f, 2));
        orders.add(new OrderModel(9L, "009", "Disney World Orlando", 11300.0f, 6));
        orders.add(new OrderModel(10L, "010", "Panaca Parque del Cafe", 1000.0f, 6));
    }

    @Override
    public OrderModel getById(long id) {

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                return orders.get(i);
            }
        }

        // if nothing was found return null
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        // given a search term. create a list of items whose description is similar to the word we are searching for.

        // Creating a List foundItems that stores the results.
        /*
        List<OrderModel> foundItems = new ArrayList<OrderModel>();


        for(int i=0; i<orders.size(); i++){
            if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())){
                foundItems.add(orders.get(i));
            }
        }
        */

        // Let's use functional programming
        List<OrderModel> foundItems = orders.stream().filter(order -> order.getProductName().toLowerCase().contains(searchTerm.toLowerCase())).collect(Collectors.toList());

        return foundItems;
    }

    @Override
    public long addOne(OrderModel newOrder) {
        boolean success = orders.add(newOrder);

        if (success) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public boolean deleteOne(long id) {

        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == idToUpdate) {
                orders.set(i, updateOrder);
                return orders.get(i);
            }
        }
        // nothing found
        return null;
    }

}