package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CentreCommercial;

@Repository
public interface CentreCommRepository  extends JpaRepository<CentreCommercial, Long>  {

}
