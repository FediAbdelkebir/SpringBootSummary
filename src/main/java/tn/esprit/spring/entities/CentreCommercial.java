package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 


@Getter 
@Setter 
@NoArgsConstructor 
@ToString 
@AllArgsConstructor 
@EqualsAndHashCode
public class CentreCommercial implements Serializable { 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id; 
      private String nom; 
      private String login; 
      private String Adresse; 
      private String password; 
      
      @OneToMany(cascade = CascadeType.ALL, mappedBy="centreCommercial")
      private Set<Boutique> boutiques;
      
      
}
