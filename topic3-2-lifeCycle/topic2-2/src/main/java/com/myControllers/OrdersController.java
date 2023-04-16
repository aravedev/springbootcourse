package com.myControllers;

import com.myModels.OrderModel;
import com.myServices.OrdersBusinessServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    // Good code! - Dependency injection
    // @Autowired
   // OrderBusinessService service;

    // Now, we want to swap between OrderBusinessService and OrderBusinessService, for this reason we must create the interface object
    OrdersBusinessServiceInterface service;

    // Good Code! Constructor - constructor injection - 2nd way, it works well with unit testing, but both ways are correct.
    // Now we are going to use the OrdersBusinessServiceInterface in our constructor instead of OrderBusinessService

    public OrdersController(OrdersBusinessServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public String showAllOrders(Model model){

        // Bad Code!: dependency - change later to dependency injection
        //OrderBusinessService service = new OrderBusinessService();

        List<OrderModel> orders = service.getOrders();

        // Sending these orders to our page
        model.addAttribute("title", "Here is what I want to do this summer");
        model.addAttribute("orders",orders);

        return "orders.html";
    }

}
