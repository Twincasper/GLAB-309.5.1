package com.perscholas.glab30951.controllerstwo;

import com.perscholas.glab30951.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @PostMapping("/users")
    public void printData(@RequestBody User user){
        System.out.println("Printing the user data:" + user);
    }

    @ModelAttribute("countries")
    public List<String> getUserCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("UK");
        countries.add("USA");
        countries.add("Japan");
        return countries;
    }

    @GetMapping("/Home")
    public String home(@ModelAttribute("countries") List<String> countries, Model model) {
        countries.add("Australia");
        countries.add("Canada");
        return "Home";
    }

    @ModelAttribute
    public void getUsers (Model model) {
        User u1 = new User(1,"haseeb","haseeb@gmail.com");
        User u2 = new User(2,"Josph","Josph@gmail.com");
        User u3 = new User(3,"Ameer","Ameer@gmail.com");
        List < User> myuser = new ArrayList < > ();
        myuser.add(u1);
        myuser.add(u2);
        myuser.add(u3);
        model.addAttribute("myuserAttribute", myuser);
    }
}
