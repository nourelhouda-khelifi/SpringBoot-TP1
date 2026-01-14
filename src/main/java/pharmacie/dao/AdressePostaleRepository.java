package pharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pharmacie.entity.AdressePostale;

public interface AdressePostaleRepository extends JpaRepository<AdressePostale, Integer> {
}
