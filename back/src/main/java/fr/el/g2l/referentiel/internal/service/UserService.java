package fr.el.g2l.referentiel.internal.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.el.g2l.referentiel.generated.api.model.User;
import fr.el.g2l.referentiel.internal.db.mapper.UserMapper;
import fr.el.g2l.referentiel.internal.db.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                            .map(userMapper::toDto);
    }
}
