package com.matrixglitch.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer count = 4;

    static {
        users.add(new User(1,"Avinash", LocalDate.now().minusYears(22)));
        users.add(new User(2,"Ganesh", LocalDate.now().minusYears(21)));
        users.add(new User(3,"Aaron", LocalDate.now().minusYears(23)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(count++);
        users.add(user);
        return user;
    }
}
