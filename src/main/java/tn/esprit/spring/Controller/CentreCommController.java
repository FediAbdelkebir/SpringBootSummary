package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.service.ImpBoutiqueService;
import tn.esprit.spring.service.ImpCentreComm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Centre")
public class CentreCommController {
	@Autowired
	ImpCentreComm AutoCentre;
		
	//http://localhost:8086/SpringMvc/Centre/add-Centre
	@PostMapping("/add-Centre")
	@ResponseBody //trajaa retour
public void ajouCentre(@RequestBody CentreCommercial Centre) {
	AutoCentre.ajouCentre(Centre);
	
}
	
}
