package pharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pharmacie.entity.Commande;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    @Override
    Optional<Commande> findById(Integer integer);
    List<Commande> findBySaisieLeAfter(Date date);

    /**
     * Calcule le nombre d'articles déjà commandés par un dispensaire
     * (la commande doit avoir déjà été envoyée)
     * @param codeDispensaire le code du dispensaire
     * @return le nombre total d'articles commandés et envoyés
     */
    @Query("SELECT COALESCE(SUM(ligne.quantite), 0) FROM Commande c "
            + "JOIN c.lignes ligne "
            + "WHERE c.dispensaire.code = :codeDispensaire "
            + "AND c.envoyeeLe IS NOT NULL")
    Long articlesCommandesParDispensaire(@Param("codeDispensaire") String codeDispensaire);

    /**
     * Trouve toutes les commandes en cours pour un dispensaire
     * Une commande est en cours si sa date d'envoi (envoyeeLe) n'est pas renseignée
     * @param codeDispensaire le code du dispensaire
     * @return la liste des commandes en cours
     */
    @Query("SELECT c FROM Commande c "
            + "WHERE c.dispensaire.code = :codeDispensaire "
            + "AND c.envoyeeLe IS NULL")
    List<Commande> commandesEnCoursParDispensaire(@Param("codeDispensaire") String codeDispensaire);
}
