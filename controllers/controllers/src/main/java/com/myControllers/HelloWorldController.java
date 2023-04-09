package com.myControllers;

import com.myModels.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {
    // return a string from a /test1 url

    @GetMapping("/test1")
    @ResponseBody // send the respond back to the client, there is not test1 html
    public String printHello(){
        return "Hello Danny! Congrats you are learning a lot!";
    }

    @GetMapping("/test2")
    public String showHelloPage(Model model){
        //attributeName:"message" is the name of the variable given in our html-> th:text ="${message}"
        //attributeValue: is the value that we will replace on our html, it will change from Hello Controllers Web Page to Have a great day!
        model.addAttribute("message", "Have a great day!");
        model.addAttribute("rating",99);
        model.addAttribute("report","Some great news from the station");
        return "helloPage";
    }

    @GetMapping("/test3")
    public ModelAndView printHelloAgain(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Have a super day");
        mv.addObject("rating",55);
        mv.setViewName("helloPage");
        return mv;
    }

    @GetMapping("/test4")
    public String showHelloPage4(@RequestParam("message") String message , Model model){
       // model.addAttribute("message", "Have a great day!");
        model.addAttribute("message",message); // we get the message from the url browser using the ?message=Danny
        model.addAttribute("rating",99);
        model.addAttribute("report","Some great news from the station");
        return "helloPage";
    }

    @GetMapping("/people")
    public String showFriends(Model model){

        List<Person> friends = new ArrayList<Person>();

        //Adding some friends
        friends.add(new Person(0,"Danny",32,59.2f));
        friends.add(new Person(1,"Sergio",26,70f));
        friends.add(new Person(2,"Johana",32,51.2f));
        friends.add(new Person(3,"Kudzai",22,80.3f));
        friends.add(new Person(4,"Melania",20,49.5f));

        System.out.println(friends);

        // our attribute on thymleaf is called people and is binded to List of friends
        model.addAttribute("people",friends);

        return "printFriends";
    }

    @GetMapping("/peopleJson")
    @ResponseBody // we are returning directly to the server, we arent dealing with the template
    public List<Person> showFriendsJson(){

        List<Person> friends = new ArrayList<Person>();

        //Adding some friends
        friends.add(new Person(0,"Danny",32,59.2f));
        friends.add(new Person(1,"Sergio",26,70f));
        friends.add(new Person(2,"Johana",32,51.2f));
        friends.add(new Person(3,"Kudzai",22,80.3f));
        friends.add(new Person(4,"Melania",20,49.5f));

        // this time we arent using thymleaf

        return friends;
    }

}
