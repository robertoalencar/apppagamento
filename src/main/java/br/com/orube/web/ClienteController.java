package br.com.orube.web;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.orube.domain.Cliente;
import br.com.orube.repository.ClienteRepository;

@RestController
@RequestMapping("/apppagamento/cliente")
public class ClienteController {

    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
	this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity all() {
	return ok(this.repository.findAll());
    }

    @PostMapping("")
    public ResponseEntity save(@RequestBody ClienteForm form, HttpServletRequest request) {

	Cliente saved = this.repository.save(Cliente.builder().nome(form.getNome()).build());
	return created(ServletUriComponentsBuilder.fromContextPath(request).path("/apppagamento/cliente/{id}")
		.buildAndExpand(saved.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {

	return ok(this.repository.findById(id).orElseThrow(() -> new ClienteNotFoundException()));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ClienteForm form) {

	Cliente existed = this.repository.findById(id).orElseThrow(() -> new ClienteNotFoundException());
	existed.setNome(form.getNome());

	this.repository.save(existed);
	return noContent().build();
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

	Cliente existed = this.repository.findById(id).orElseThrow(() -> new ClienteNotFoundException());
	this.repository.delete(existed);
	return noContent().build();
    }
}
