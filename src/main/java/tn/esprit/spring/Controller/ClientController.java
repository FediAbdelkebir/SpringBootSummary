package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.service.ImpClientService;


@RestController
@RequestMapping("/Client")
public class ClientController {
	@Autowired
	ImpClientService CS;
	//http://localhost:8086/SpringMvc/Client/add-Client
		@PostMapping("/add-Client")
		@ResponseBody //trajaa retour
	void ajouterEtAffecterClientBoutiques(@RequestBody Client client,  @RequestParam(value="idBoutiques") List<Long> idBoutiques) {
			CS.ajouterEtAffecterClientBoutiques(client, idBoutiques);
		}
		//afficher la liste de clients d’une boutique donnée
		@GetMapping("/list-client/{idBoutique}")
		@ResponseBody
		List<Client> listedeClients(@PathVariable("idBoutique") Long idBoutique){
			return CS.listedeClients(idBoutique);
		}
		//afficher la liste de clients pour chaque catégorie
		@GetMapping("/liste-clientParCategorie/{categorie}")
		List<Client> listeDeClientsParCategorie(@PathVariable("categorie") Categorie categorie){
			return CS.listeDeClientsParCategorie(categorie);
		}
}
