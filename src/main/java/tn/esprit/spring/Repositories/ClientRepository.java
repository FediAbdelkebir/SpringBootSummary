package tn.esprit.spring.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Genre;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>  {

	List<Client> findByBoutiquesId(Long idBoutique);
	
	//@Query(" select clients from boutiques c GROUP BY c.categorie where c.categorie=:categorie")
	List<Client> findByBoutiquesCategorie(@Param("categorie")Categorie categorie);
	
	@Query(" select count(c) from Client c where c.genre=:genre")
	int getClientByGenre(@Param("genre") Genre genre);
}
