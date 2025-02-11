package fr.el.g2l.referentiel.api;

import java.util.Optional;

import org.springframework.modulith.NamedInterface;

import fr.el.g2l.common.dto.User;

@NamedInterface
public interface UserApi {
    Optional<User> findByUsername(String username);
    User save(User user);
}
