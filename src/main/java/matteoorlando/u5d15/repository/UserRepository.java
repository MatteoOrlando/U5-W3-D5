package matteoorlando.u5d15.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    // implemento il metodo existsBy nello UserRepository per eseguire una query e
    // per verificare se esiste un utente con lo username specificato nel database
    boolean existsByUsername(String username);
}
