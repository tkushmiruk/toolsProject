package ua.taras.kushmyruk.service.serviceImpl;

import org.springframework.stereotype.Service;
import ua.taras.kushmyruk.service.LoginService;

@Service
public class LoginServiceImpl  implements LoginService {
    @Override
    public boolean login(String username, String password) {
    return true;
    }
}
