package matteoorlando.u5d15.service;
//import matteoorlando.u5d15.entities.Role;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collections;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Metodo con cui registro uno User
    public ResponseEntity<?> registerUser(User user) {
        // Check if user already exists
        if (userService.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        // codifico password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        userService.saveUser(user);

        // Return success response
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    // Metodo per log in
    public ResponseEntity<?> loginUser(String username, String password) {

        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        // controllo se la password fornita corrisponde a quella salvata dall'utente
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.UNAUTHORIZED);
        }

        // se la pass corrispone
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }
}
