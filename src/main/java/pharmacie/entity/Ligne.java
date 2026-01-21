package pharmacie.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
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
