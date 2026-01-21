package pharmacie.dao;

/**
 * Projection pour les résultats de requête donnant le nombre d'unités commandées par médicament
 */
public interface UnitesParMedicament {
    String getNom();
    Long getUnites();
}
