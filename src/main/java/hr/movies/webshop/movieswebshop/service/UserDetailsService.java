package hr.movies.webshop.movieswebshop.service;

import hr.movies.webshop.movieswebshop.model.User;
import hr.movies.webshop.movieswebshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        String[] roles = new String[user.getRoles().size()];

        for (int i = 0; i < user.getRoles().size(); i++) {
            roles[i] = user.getRoles().get(i).getName();
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
