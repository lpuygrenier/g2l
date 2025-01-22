package fr.el.g2l.referentiel.internal.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.el.g2l.referentiel.internal.db.models.UserDb;

@Repository
public interface UserRepository extends JpaRepository<UserDb, Long> {
    Optional<UserDb> findByUsername(String username);
}
