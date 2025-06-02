package ru.netology.springauthorization.reposytory;

import org.springframework.stereotype.Repository;
import ru.netology.springauthorization.authorities.Authorities;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("admin".equals(user) && "admin123".equals(password)) {
            return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("user".equals(user) && "user123".equals(password)) {
            return List.of(Authorities.READ);
        } else if ("guest".equals(user) && "guest123".equals(password)) {
            return Collections.emptyList();
        }
        return null;
    }
}
