package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repositories.BoutiqueRepository;
import tn.esprit.spring.Repositories.ClientRepository;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Genre;
@Service
public class ImpClientService {
	@Autowired
	ClientRepository CR;
	@Autowired
	BoutiqueRepository boutiqueRepository;
	public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques){
		
		List<Boutique> boutiques = boutiqueRepository.findAll();
		//ajouter les clients ci-dessous et affecter les aux boutiques crées dans la question
		
		for (Boutique boutique : boutiques) {
			for (Long id : idBoutiques) {
				if (boutique.getId().equals(id)) {
					boutique.getClients().add(client);
					CR.save(client);
				}
			}
		}
				
	}
	//afficher la liste de clients d’une boutique donnée
	public List<Client> listedeClients(Long idBoutique) {
		return CR.findByBoutiquesId(idBoutique);
	}
	//afficher la liste de clients pour chaque catégorie
	public List<Client> listeDeClientsParCategorie(Categorie categorie) {
		
		return CR.findByBoutiquesCategorie(categorie);
	}
	//toutes les 30s, permettant d’afficher nombre des clients par genre
	@Scheduled(cron = "*/30 * * * * *")
	void nbreClientParGenre() {
		int nbrFeminin = CR.getClientByGenre(Genre.FEMME);
		int nbrMasculin = CR.getClientByGenre(Genre.HOMME);
		System.out.println("Nombre des clients Feminins : " + nbrFeminin);
		System.out.println("Nombre des clients Masculins : " + nbrMasculin);

	}

}
