package pharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pharmacie.entity.Commande;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    @Override
    Optional<Commande> findById(Integer integer);
    List<Commande> findBySaisieLeAfter(Date date);


}
