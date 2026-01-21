package pharmacie.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdressePostale {

    @NotBlank(message = "L'adresse ne peut pas être vide")
    @Size(min = 5, max = 150, message = "L'adresse doit contenir entre 5 et 150 caractères")
    private String adresse;

    @NotBlank(message = "La ville ne peut pas être vide")
    @Size(min = 2, max = 50, message = "La ville doit contenir entre 2 et 50 caractères")
    private String ville;

    @NotBlank(message = "La région ne peut pas être vide")
    @Size(min = 2, max = 50, message = "La région doit contenir entre 2 et 50 caractères")
    private String region;

    @NotBlank(message = "Le code postal ne peut pas être vide")
    @Pattern(regexp = "^[0-9]{5}$", message = "Le code postal doit contenir exactement 5 chiffres")
    private String codePostal;

    @NotBlank(message = "Le pays ne peut pas être vide")
    @Size(min = 2, max = 50, message = "Le pays doit contenir entre 2 et 50 caractères")
    private String pays;
}
