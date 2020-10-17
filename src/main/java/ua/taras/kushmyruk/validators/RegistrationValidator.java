package ua.taras.kushmyruk.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.taras.kushmyruk.Repository.UserRepository;
import ua.taras.kushmyruk.domain.User;

@Component
public class RegistrationValidator {
    UserRepository userRepository;

    @Autowired
    public RegistrationValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean isUserExist(String username) {
        User userFromBd = userRepository.findByUsername(username);
        return userFromBd == null ? true : false;
    }
}
