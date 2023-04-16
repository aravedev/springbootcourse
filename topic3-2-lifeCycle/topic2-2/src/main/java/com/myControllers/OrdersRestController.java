package com.myControllers;

import com.myModels.OrderModel;
import com.myServices.OrdersBusinessServiceInterface;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // for RestAPI
@RequestMapping("/api/v1/orders")
public class OrdersRestController {

    // Good code! - Dependency injection
    // @Autowired
   // OrderBusinessService service;

    // Now, we want to swap between OrderBusinessService and OrderBusinessService, for this reason we must create the interface object
    OrdersBusinessServiceInterface service;

    // Good Code! Constructor - constructor injection - 2nd way, it works well with unit testing, but both ways are correct.
    // Now we are going to use the OrdersBusinessServiceInterface in our constructor instead of OrderBusinessService

    public OrdersRestController(OrdersBusinessServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public List<OrderModel> showAllOrders(){

        // Bad Code!: dependency - change later to dependency injection
        //OrderBusinessService service = new OrderBusinessService();

        List<OrderModel> orders = service.getOrders();


        return orders;
    }

    @GetMapping("/search/{searchTerm}")
    //@PathVariable() tales the {searchTerm} from our browser and paste it as parameter for our function
    // name="searchTerm" and we are creating a variable called searchTerm to store that information and pass it.
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String term){

        // Bad Code!: dependency - change later to dependency injection
        //OrderBusinessService service = new OrderBusinessService();

        List<OrderModel> orders = service.searchOrders(term);


        return orders;
    }

    @PostMapping("/") // Adding something to a database
    //@RequestBody binds the Object passed by form or whatever place and transform it as JSON and is send it to our DB
    public long addOrder(@RequestBody OrderModel model){
        return service.addOne(model);
    }

    // Find specific object
    @GetMapping("/{id}")
    public OrderModel getById(@PathVariable(name="id") long id){
        return service.getById(id);
    }

    //Delete object
    @GetMapping("/delete/{id}")
    public boolean deleteOne(@PathVariable(name="id") long id){
        return service.deleteOne(id);
    }

    // Update
    @PutMapping("/update/{id}")
    public OrderModel updateOne(@RequestBody OrderModel model ,@PathVariable(name="id") long id){
        return service.updateOne(id, model );
    }



}
