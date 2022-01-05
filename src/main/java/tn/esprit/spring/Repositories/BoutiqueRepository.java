package tn.esprit.spring.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;

@Repository
public interface BoutiqueRepository  extends JpaRepository<Boutique, Long>  {

	List<Boutique> findByCentreCommercial(CentreCommercial centre);

}
