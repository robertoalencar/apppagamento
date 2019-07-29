package br.com.orube;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.orube.domain.Cliente;
import br.com.orube.domain.User;
import br.com.orube.repository.ClienteRepository;
import br.com.orube.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    ClienteRepository clientes;

    @Autowired
    UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

	log.debug("initializing clientes data ...");
	Arrays.asList("Roberto", "Arthur", "Gabriel")
		.forEach(v -> this.clientes.saveAndFlush(Cliente.builder().nome(v).build()));
	
	log.debug("printing all clientes ...");
	this.clientes.findAll().forEach(c -> log.debug(" Cliente :" + c.toString()));

	this.users.save(User.builder().username("user").password(this.passwordEncoder.encode("password"))
		.roles(Arrays.asList("ROLE_USER")).build());

	this.users.save(User.builder().username("admin").password(this.passwordEncoder.encode("password"))
		.roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN")).build());

	log.debug("printing all users ...");
	this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));

    }
}
