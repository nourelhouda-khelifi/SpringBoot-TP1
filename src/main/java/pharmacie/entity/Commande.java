package pharmacie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, On ne veut pas de "setter"
    private Integer numero;

    @NotNull(message = "La date de saisie est obligatoire")
    @PastOrPresent(message = "La date de saisie ne peut pas être dans le futur")
    @Column(nullable = false)
    private Date saisieLe;

    @PastOrPresent(message = "La date d'envoi ne peut pas être dans le futur")
    @Column(nullable = true)
    private Date envoyeeLe;

    @NotNull(message = "Le port est obligatoire")
    @DecimalMin(value = "0.0", message = "Le port ne peut pas être négatif")
    @Column(nullable = false)
    private BigDecimal port;

    @NotBlank(message = "Le destinataire est obligatoire")
    @Size(min = 2, max = 255, message = "Le destinataire doit contenir entre 2 et 255 caractères")
    @Column(nullable = false)
    private String distinataire;

    @NotNull(message = "La remise est obligatoire")
    @DecimalMin(value = "0.0", message = "La remise ne peut pas être négative")
    @DecimalMax(value = "100.0", message = "La remise ne peut pas dépasser 100")
    @Column(nullable = false)
    private BigDecimal remise;

    @OneToMany(
        mappedBy = "commande",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @ToString.Exclude
    private List<Ligne> lignes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dispensaire_code")
    @ToString.Exclude
    private Dispensaire dispensaire;

    @OneToOne(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        optional = false
    )
    @JoinColumn(name = "adresse_id", nullable = false)
    @ToString.Exclude
    private AdressePostale adresse;






}
