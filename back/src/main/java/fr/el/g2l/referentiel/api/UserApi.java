package fr.el.g2l.referentiel.api;

import java.util.Optional;

import fr.el.g2l.referentiel.generated.api.model.User;

public interface UserApi {
    Optional<User> findByUsername(String username);
}
