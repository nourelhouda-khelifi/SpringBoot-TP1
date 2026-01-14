package pharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pharmacie.entity.Commande;
import pharmacie.entity.Ligne;
import pharmacie.entity.Medicament;

import java.util.Optional;

public interface LigneRepository extends JpaRepository<Ligne, Integer> {

    Optional<Ligne> findByMedicament(Medicament medicament);
    Optional<Ligne> findById(Integer id);
    Optional<Ligne>findByCommande(Commande commande);
}
