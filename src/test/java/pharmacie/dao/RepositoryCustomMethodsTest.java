package pharmacie.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import pharmacie.entity.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class RepositoryCustomMethodsTest {

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private MedicamentRepository medicamentRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private DispensaireRepository dispensaireRepository;
    @Autowired
    private LigneRepository ligneRepository;
    @Autowired
    private AdressePostaleRepository adressePostaleRepository;


    @Test // Ce test se base uniquement sur les données définies dans data.sql
    public void testMedicamentCustomMethods() {    
        Medicament indisponible = medicamentRepository.findByNom("Lévofloxacine 500mg").orElseThrow();
        Medicament disponible   = medicamentRepository.findByNom("Doliprane Effervescent 1g").orElseThrow();
    
        // Trouve tous les médicaments disponibles
        List<Medicament> disponibles = medicamentRepository.findByIndisponibleFalse();

        assertTrue(disponibles.contains(disponible));
        assertFalse(disponibles.contains(indisponible));        
        assertFalse(disponibles.isEmpty());
    }

    @Test // Ce test crée les enregistrements nécessaires
    public void testCategorieCustomMethods() {
        Categorie c1 = new Categorie();
        c1.setLibelle("AnalgesiquesTest");
        categorieRepository.save(c1);

        Categorie c2 = new Categorie();
        c2.setLibelle("AntibiotiquesTest");
        categorieRepository.save(c2);

        // findByLibelle
        Categorie found = categorieRepository.findByLibelle("AnalgesiquesTest");
        assertNotNull(found);
        assertEquals("AnalgesiquesTest", found.getLibelle());

        // findByLibelleContaining
        List<Categorie> list = categorieRepository.findByLibelleContaining("iquesTest");
        assertEquals(2, list.size());
        assertTrue(list.stream().anyMatch(cat -> cat.getLibelle().equals("AntibiotiquesTest")));
        assertTrue(list.stream().anyMatch(cat -> cat.getLibelle().equals("AnalgesiquesTest")));
    }

    @Test // Test de CommandeRepository.findBySaisieLeAfter(Date)
    public void testCommandeCustomMethods() {
        // Récupère toutes les commandes saisies après le 2025-01-03
        Date dateSaisie = new Date(125, 0, 3); // 3 janvier 2025
        
        List<Commande> commandesApres = commandeRepository.findBySaisieLeAfter(dateSaisie);
        
        assertNotNull(commandesApres);
        assertFalse(commandesApres.isEmpty());
        
        // Tous les résultats doivent avoir une date de saisie >= dateSaisie
        assertTrue(commandesApres.stream().allMatch(c -> c.getSaisieLe().getTime() >= dateSaisie.getTime()));
        
        // Vérifie qu'on a les commandes saisies après la date
        assertTrue(commandesApres.size() > 0);
    }

    @Test // Test de DispensaireRepository.findByAdresseRegion(String)
    public void testDispensaireCustomMethods() {
        // Trouve tous les dispensaires situés en Île-de-France (région présente dans data.sql)
        List<Dispensaire> dispensairesIleFrance = dispensaireRepository.findByAdresseRegion("Île-de-France");
        
        assertNotNull(dispensairesIleFrance);
        assertFalse(dispensairesIleFrance.isEmpty());
        
        // Vérifie qu'au moins 2 dispensaires sont en Île-de-France (Paris)
        assertEquals(2, dispensairesIleFrance.size());
        
        // Tous les dispensaires doivent être en Île-de-France
        assertTrue(dispensairesIleFrance.stream()
            .allMatch(d -> d.getAdresse().getRegion().equals("Île-de-France")));
    }

    @Test // Test de LigneRepository
    public void testLigneCustomMethods() {
        // Vérifie que les lignes peuvent être trouvées par Medicament
        Medicament morphine = medicamentRepository.findByNom("Morphine 10mg").orElseThrow();
        List<Ligne> lignesMorphine = new java.util.ArrayList<>();
        
        for(Ligne ligne : ligneRepository.findAll()) {
            if(ligne.getMedicament().equals(morphine)) {
                lignesMorphine.add(ligne);
            }
        }
        
        // La morphine doit être dans au moins une ligne de commande
        assertFalse(lignesMorphine.isEmpty());
        
        // Vérifie qu'on peut trouver une ligne par ID
        if(!lignesMorphine.isEmpty()) {
            Ligne premiereLigne = lignesMorphine.get(0);
            Optional<Ligne> ligneRecherchee = ligneRepository.findById(premiereLigne.getId());
            assertTrue(ligneRecherchee.isPresent());
            assertEquals(premiereLigne.getId(), ligneRecherchee.get().getId());
        }
    }

    @Test // Test de MedicamentRepository.findByNom()
    public void testMedicamentFindByNom() {
        // Test avec un médicament qui existe
        Optional<Medicament> morphine = medicamentRepository.findByNom("Morphine 10mg");
        assertTrue(morphine.isPresent());
        assertEquals("Morphine 10mg", morphine.get().getNom());
        
        // Test avec un médicament qui n'existe pas
        Optional<Medicament> inexistant = medicamentRepository.findByNom("Médicament inexistant");
        assertFalse(inexistant.isPresent());
    }
}