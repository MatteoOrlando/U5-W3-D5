package matteoorlando.u5d15.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface SecurityConfiguration {
    void configure(AuthenticationManagerBuilder auth) throws Exception;

    @Bean
    PasswordEncoder passwordEncoder();
}
