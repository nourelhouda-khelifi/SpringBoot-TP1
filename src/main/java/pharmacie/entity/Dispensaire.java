package pharmacie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispensaire {

    @Id
    @Setter(AccessLevel.NONE) // la clé est fournie manuellement, On ne veut pas de "setter"
    private String code;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nom;

    @NotBlank(message = "Le contact ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le contact doit contenir entre 2 et 100 caractères")
    private String contact;

    @NotBlank(message = "La fonction ne peut pas être vide")
    @Size(min = 2, max = 50, message = "La fonction doit contenir entre 2 et 50 caractères")
    private String fonction;

    @NotBlank(message = "Le téléphone ne peut pas être vide")
    @Pattern(regexp = "^[0-9\\s\\-\\+\\(\\)]+$", message = "Le téléphone doit contenir uniquement des chiffres et caractères spéciaux")
    @Size(min = 8, max = 20, message = "Le téléphone doit contenir entre 8 et 20 caractères")
    private String telephone;

    @NotBlank(message = "Le fax ne peut pas être vide")
    @Pattern(regexp = "^[0-9\\s\\-\\+\\(\\)]+$", message = "Le fax doit contenir uniquement des chiffres et caractères spéciaux")
    @Size(min = 8, max = 20, message = "Le fax doit contenir entre 8 et 20 caractères")
    private String fax;

    @OneToMany(
        mappedBy = "dispensaire",
        cascade = CascadeType.REMOVE
    )
    @ToString.Exclude
    private List<Commande> commandes;

    @Embedded
    private AdressePostale adresse;
}
