package matteoorlando.u5d15.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import matteoorlando.u5d15.service.AuthService;
import org.springframework.http.ResponseEntity;

import javax.management.relation.Role;
import java.util.Set;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles;
    // Metodo per la registrazione di un nuovo utente
    public ResponseEntity<?> register() {
        AuthService authService = new AuthService(); // Questo è solo un esempio, non è una pratica consigliata!
        return authService.registerUser((org.apache.catalina.User) this);
    }

    // Metodo per il login dell'utente
    public ResponseEntity<?> login() {
        AuthService authService = new AuthService(); // Questo è solo un esempio, non è una pratica consigliata!
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(this.username);
        loginRequest.setPassword(this.password);
        return authService.loginUser(loginRequest);
    }


}
