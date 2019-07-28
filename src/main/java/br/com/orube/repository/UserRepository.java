package br.com.orube.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orube.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
