package pharmacie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.List;
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"COMMANDE_NUMERO", "MEDICAMENT_REFERENCE"})})
public class Ligne {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
    private Integer id;
    private short quantite;
    @ManyToOne(optional = false)
    private Commande commande;
    @ManyToOne(optional = false)
    private Medicament medicament;
}
