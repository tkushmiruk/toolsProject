package ua.taras.kushmyruk.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.Repository.UserRepository;
import ua.taras.kushmyruk.domain.Role;
import ua.taras.kushmyruk.domain.User;
import ua.taras.kushmyruk.service.RegistrationService;
import ua.taras.kushmyruk.validators.RegistrationValidator;

import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final RegistrationValidator registrationValidator;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository, RegistrationValidator registrationValidator,
                                   PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.registrationValidator = registrationValidator;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registrate(String username, String password) {
        if (registrationValidator.isUserExist(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setEnabled(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
