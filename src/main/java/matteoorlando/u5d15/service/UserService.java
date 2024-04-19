package matteoorlando.u5d15.service;

import matteoorlando.u5d15.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Metodo utilizzato per trovare un Utente in base allo username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
