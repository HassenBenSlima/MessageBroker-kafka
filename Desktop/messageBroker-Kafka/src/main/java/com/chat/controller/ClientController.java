package com.chat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.ClientRepository;
import com.chat.entities.Client;

@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> listProduits() {
		return clientRepository.findAll();
	}

	@GetMapping(value = "/clients/{idClient}")
	public Client getClient(@PathVariable Long idClient) {
		Client cltValue = null;
		Optional<Client> clt = clientRepository.findById(idClient);
		if (clt.isPresent()) {
			cltValue = clt.get();
			return cltValue;
		}
		return cltValue;
	}

	@GetMapping(value = "/client")
	public Client getClientByNameAndPassword(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "pwd", defaultValue = "") String password) {
		return clientRepository.findByNameAndPassword(name, password);
	}

	@PostMapping("/saveClient")
	public Client saveClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}

}
