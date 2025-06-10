package ru.netology.springauthorization.service;

import org.springframework.stereotype.Service;
import ru.netology.springauthorization.authorities.Authorities;
import ru.netology.springauthorization.exceptions.InvalidData;
import ru.netology.springauthorization.exceptions.UnauthorizedUser;
import ru.netology.springauthorization.repository.UserRepository;
import java.util.List;

@Service
public class AuthorizationService {private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidData("Имя пользователя или пароль не могут быть пустыми");
        }

        List<Authorities> authorities = userRepository.getUserAuthorities(user, password);
        if (authorities == null || authorities.isEmpty()) {
            throw new UnauthorizedUser("Пользователь '" + user + "' не найден или не имеет прав доступа");
        }

        return authorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}