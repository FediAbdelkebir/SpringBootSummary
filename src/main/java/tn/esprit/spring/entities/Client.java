package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Client implements Serializable{ 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String nom;
	 @Enumerated(EnumType.ORDINAL)
	 private Genre genre; 
	 @ManyToMany(cascade = CascadeType.ALL ,mappedBy ="clients" )
		private Set<Boutique> boutiques;

}
