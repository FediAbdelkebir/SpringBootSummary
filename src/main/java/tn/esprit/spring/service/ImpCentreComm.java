package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repositories.BoutiqueRepository;
import tn.esprit.spring.Repositories.CentreCommRepository;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
@Service
public class ImpCentreComm implements IcentreComm {

	@Autowired 
	CentreCommRepository centrecomm;
	@Autowired
	BoutiqueRepository AutoBoutique;

	@Override
	public void ajouCentre(CentreCommercial centre) {
		//Creation Boutique
		Boutique B1 = new Boutique();
		AutoBoutique.save(B1);
		//Creation Centre
		centrecomm.save(centre);
	}

}
