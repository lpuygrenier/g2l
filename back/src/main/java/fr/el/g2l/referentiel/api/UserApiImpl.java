package fr.el.g2l.referentiel.api;

import java.util.Optional;

import org.springframework.stereotype.Controller;

import fr.el.g2l.common.dto.User;
import fr.el.g2l.referentiel.internal.db.mapper.UserMapper;
import fr.el.g2l.referentiel.internal.db.repository.UserRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserApiImpl implements UserApi {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username)
                             .map(userMapper::toDto);
    }

    @Override
    public User save(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
