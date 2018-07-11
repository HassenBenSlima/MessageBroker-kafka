package spark.fr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import spark.fr.dao.ClientRepository;
import spark.fr.entities.Client;

@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> listProduits() {
		System.out.println("Hassen *****************************");

		List<Client> clients = clientRepository.findAll();
		System.out.println("Hassen *****************************Anis");
		return clients;
	}

	@GetMapping(value = "/clients/{idClient}")
	public Client getClient(@PathVariable Long idClient) {
		return clientRepository.findById(idClient).get();
	}

}
