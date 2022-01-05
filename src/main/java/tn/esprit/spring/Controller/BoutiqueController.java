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

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.service.ImpBoutiqueService;

@RestController
@RequestMapping("/Boutique")
public class BoutiqueController {
@Autowired
ImpBoutiqueService BS;
	//Ajouter et l’affecter au centre commercial crée dans la question
		@PostMapping("/add-Boutique/{idCentre}")
		@ResponseBody //trajaa retour
	void ajouterEtaffecterListeboutique (@RequestBody List<Boutique> lb, @PathVariable("idCentre") Long idCentre) {
		BS.ajouterEtaffecterListeboutique(lb, idCentre);
	}
		//afficher la liste des boutiques d’un centre commercial
		@GetMapping("/liste-boutique/{idCentre}")
		@ResponseBody
		List<Boutique> listedeBoutiques(@PathVariable("idCentre") Long idCentre){
			return BS.listedeBoutiques(idCentre);
		}
}
