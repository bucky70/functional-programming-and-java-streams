package com.in28minutes.rest.webservices.restful_web_services;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    private static List<User> users=new ArrayList<>();
    private static int count=3;
    static{
        users.add(new User(1,"ADAM", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Eve",LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim",LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }
    public User findUserById(int id){
        Predicate<? super User> predicate=user -> { return user.getId().equals(id);};
       return  users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteUserById(int id){
        Predicate<? super User> predicate=user -> { return user.getId().equals(id);};
        users.removeIf(predicate);

    }
    public User save(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }
 }
