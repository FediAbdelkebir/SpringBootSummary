package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repositories.BoutiqueRepository;
import tn.esprit.spring.Repositories.CentreCommRepository;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
@Service
public class ImpBoutiqueService implements IboutiqueService{
	@Autowired
	BoutiqueRepository boutiqueRepository;
	@Autowired
	CentreCommRepository CR;
	public Boutique addBoutique(Boutique c) {
		return boutiqueRepository.save(c);
	}

	public void deleteBoutique(Long id) {
		boutiqueRepository.deleteById(id);
	}
	
	public Boutique retrieveBoutique(Long id) {
		return boutiqueRepository.findById(id).orElse(null);
	}

	public Boutique updateBoutique(Boutique c) {
		Boutique boutique = boutiqueRepository.findById((long) c.getId()).orElse(null);
		
		return boutiqueRepository.save(boutique);
	}
	public void ajouterEtaffecterListeboutique (List<Boutique> lb, Long idCentre) {
		//ajouter à la fois la liste des boutiques suivante
		boutiqueRepository.saveAll(lb);
		
		//l’affecter au centre commercial crée dans la question
		CentreCommercial C=CR.findById(idCentre).orElse(null);
		C.getBoutiques().addAll(lb);
		CR.save(C);
	}
	//afficher la liste des boutiques d’un centre commercial
	public List<Boutique> listedeBoutiques(Long idCentre) {
		CentreCommercial centre = CR.findById(idCentre).orElse(null);
		return (List<Boutique>) centre.getBoutiques();
	}
}
