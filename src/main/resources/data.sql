-- Données de base pour le projet Pharmacie
-- Dispensaire (Etablissements de santé qui passent commande de médicaments)
-- Le fichier est chargé au démarrage de l''application

-- Insertion des catégories de médicaments
INSERT INTO CATEGORIE (CODE, LIBELLE, DESCRIPTION) VALUES
                                                       (DEFAULT, 'Antalgiques et Antipyrétiques', 'Médicaments contre la douleur et la fièvre'), -- code : 1
                                                       (DEFAULT, 'Anti-inflammatoires', 'Médicaments réduisant l''inflammation'), -- code : 2
                                                       (DEFAULT, 'Antibiotiques', 'Médicaments pour traiter les infections bactériennes'),
                                                       (DEFAULT, 'Antihypertenseurs', 'Médicaments pour traiter l''hypertension artérielle'),
                                                       (DEFAULT, 'Antidiabétiques', 'Médicaments pour traiter le diabète'),
                                                       (DEFAULT, 'Antihistaminiques', 'Médicaments pour traiter les allergies'),
                                                       (DEFAULT, 'Vitamines et Compléments', 'Suppléments nutritionnels'),
                                                       (DEFAULT, 'Médicaments Cardiovasculaires', 'Médicaments pour le cœur et la circulation'),
                                                       (DEFAULT, 'Médicaments Gastro-intestinaux', 'Médicaments pour les troubles digestifs'),
                                                       (DEFAULT, 'Médicaments Respiratoires', 'Médicaments pour les troubles respiratoires');


-- Catégorie 1: Antalgiques et Antipyrétiques
INSERT INTO MEDICAMENT (REFERENCE, NOM, QUANTITE_PAR_UNITE, PRIX_UNITAIRE, UNITES_EN_STOCK, UNITES_COMMANDEES, NIVEAU_DE_REAPPRO, INDISPONIBLE, IMAGEURL, CATEGORIE_CODE) VALUES
                                                                                                                                                                   (DEFAULT, 'Morphine 10mg', 'Boîte de 14 comprimés', 25.80, 80, 0, 15, false, 'https://images.unsplash.com/photo-1550572017-edd951aa8f72?w=400', 1),
                                                                                                                                                                   (DEFAULT, 'Doliprane Effervescent 1g', 'Boîte de 8 comprimés', 3.50, 280, 0, 30, false, 'https://images.unsplash.com/photo-1587854692152-cbe660dbde88?w=400', 1),
                                                                                                                                                                   (DEFAULT, 'Efferalgan Vitamine C', 'Boîte de 16 comprimés', 4.20, 220, 0, 25, false, 'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=400', 1);

-- Catégorie 2: Anti-inflammatoires
INSERT INTO MEDICAMENT (REFERENCE, NOM, QUANTITE_PAR_UNITE, PRIX_UNITAIRE, UNITES_EN_STOCK, UNITES_COMMANDEES, NIVEAU_DE_REAPPRO, INDISPONIBLE, IMAGEURL, CATEGORIE_CODE) VALUES
                                                                                                                                                                   (DEFAULT, 'Étodolac 400mg', 'Boîte de 14 comprimés', 12.50, 110, 0, 15, false, 'https://images.unsplash.com/photo-1471864190281-a93a3070b6de?w=400', 2),
                                                                                                                                                                   (DEFAULT, 'Flurbiprofène 100mg', 'Boîte de 30 comprimés', 10.80, 130, 0, 16, false, 'https://images.unsplash.com/photo-1550572017-edd951aa8f72?w=400', 2);

-- Catégorie 3: Antibiotiques (2 médicaments indisponbibles)
INSERT INTO MEDICAMENT (REFERENCE, NOM, QUANTITE_PAR_UNITE, PRIX_UNITAIRE, UNITES_EN_STOCK, UNITES_COMMANDEES, NIVEAU_DE_REAPPRO, INDISPONIBLE, IMAGEURL, CATEGORIE_CODE) VALUES
                                                                                                                                                                   (DEFAULT, 'Lévofloxacine 500mg', 'Boîte de 7 comprimés', 15.80, 160, 0, 18, true, 'https://images.unsplash.com/photo-1628771065518-0d82f1938462?w=400', 3),
                                                                                                                                                                   (DEFAULT, 'Clindamycine 300mg', 'Boîte de 16 gélules', 13.20, 140, 0, 16, true, 'https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400', 3);

-- Catégorie 4: Antihypertenseurs
INSERT INTO MEDICAMENT (REFERENCE, NOM, QUANTITE_PAR_UNITE, PRIX_UNITAIRE, UNITES_EN_STOCK, UNITES_COMMANDEES, NIVEAU_DE_REAPPRO, INDISPONIBLE, IMAGEURL, CATEGORIE_CODE) VALUES
                                                                                                                                                                   (DEFAULT, 'Lisinopril 10mg', 'Boîte de 30 comprimés', 8.50, 200, 0, 20, false, 'https://images.unsplash.com/photo-1550572017-edd951aa8f72?w=400', 4),
                                                                                                                                                                   (DEFAULT, 'Amlodipine 5mg', 'Boîte de 30 comprimés', 9.20, 180, 0, 18, false, 'https://images.unsplash.com/photo-1587854692152-cbe660dbde88?w=400', 4);

-- Catégorie 5: Antidiabétiques
INSERT INTO MEDICAMENT (REFERENCE, NOM, QUANTITE_PAR_UNITE, PRIX_UNITAIRE, UNITES_EN_STOCK, UNITES_COMMANDEES, NIVEAU_DE_REAPPRO, INDISPONIBLE, IMAGEURL, CATEGORIE_CODE) VALUES
                                                                                                                                                                   (DEFAULT, 'Metformine 500mg', 'Boîte de 60 comprimés', 6.80, 300, 0, 30, false, 'https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=400', 5);

-- Insertion des dispensaires (établissements de santé)
-- Adresses sont maintenant intégrées dans la table DISPENSAIRE
INSERT INTO DISPENSAIRE (CODE, NOM, CONTACT, FONCTION, TELEPHONE, FAX, ADRESSE, VILLE, REGION, CODE_POSTAL, PAYS) VALUES
                                                                                        ('DSP001', 'Hôpital Central Paris', 'Dr. Jean Dupont', 'Responsable Pharmacie', '01-45-38-22-05', '01-45-38-22-99', '123 Boulevard de la République', 'Paris', 'Île-de-France', '75001', 'France'),
                                                                                        ('DSP002', 'Clinique Lyon Nord', 'Mme Sophie Martin', 'Directrice Administrative', '04-72-25-19-86', '04-72-25-19-87', '456 Rue de Lyon', 'Lyon', 'Auvergne-Rhône-Alpes', '69000', 'France'),
                                                                                        ('DSP003', 'Centre Médical Marseille', 'Dr. Pierre Bernard', 'Chef de Service', '04-91-38-48-50', '04-91-38-48-51', '789 Avenue de la Liberté', 'Marseille', 'Provence-Alpes-Côte d''Azur', '13000', 'France'),
                                                                                        ('DSP004', 'Dispensaire Toulouse', 'Mme Marie Leclerc', 'Coordonnatrice', '05-61-53-28-22', '05-61-53-28-23', '321 Rue Jean Jaurès', 'Toulouse', 'Occitanie', '31000', 'France'),
                                                                                        ('DSP005', 'Polyclinique Sorbonne', 'Dr. François Rousseau', 'Pharmacien en Chef', '01-55-27-98-00', '01-55-27-98-01', '654 Boulevard Saint-Germain', 'Paris', 'Île-de-France', '75005', 'France');

-- Insertion des commandes
-- Adresses sont maintenant intégrées dans la table COMMANDE
INSERT INTO COMMANDE (NUMERO, SAISIE_LE, ENVOYEE_LE, PORT, DISTINATAIRE, REMISE, DISPENSAIRE_CODE, ADRESSE, VILLE, REGION, CODE_POSTAL, PAYS) VALUES
                                                                                                                   (DEFAULT, CAST('2024-12-01 10:30:00' AS TIMESTAMP), CAST('2024-12-05 14:00:00' AS TIMESTAMP), 15.50, 'Hôpital Central Paris', 10.00, 'DSP001', '123 Boulevard de la République', 'Paris', 'Île-de-France', '75001', 'France'),
                                                                                                                   (DEFAULT, CAST('2025-01-03 09:15:00' AS TIMESTAMP), NULL, 20.00, 'Clinique Lyon Nord', 5.00, 'DSP002', '456 Rue de Lyon', 'Lyon', 'Auvergne-Rhône-Alpes', '69000', 'France'),
                                                                                                                   (DEFAULT, CAST('2025-01-05 11:45:00' AS TIMESTAMP), CAST('2025-01-08 16:30:00' AS TIMESTAMP), 18.75, 'Centre Médical Marseille', 8.50, 'DSP003', '789 Avenue de la Liberté', 'Marseille', 'Provence-Alpes-Côte d''Azur', '13000', 'France'),
                                                                                                                   (DEFAULT, CAST('2025-01-07 14:20:00' AS TIMESTAMP), NULL, 22.00, 'Dispensaire Toulouse', 0.00, 'DSP004', '321 Rue Jean Jaurès', 'Toulouse', 'Occitanie', '31000', 'France'),
                                                                                                                   (DEFAULT, CAST('2025-01-10 08:00:00' AS TIMESTAMP), CAST('2025-01-12 10:00:00' AS TIMESTAMP), 12.50, 'Polyclinique Sorbonne', 15.00, 'DSP005', '654 Boulevard Saint-Germain', 'Paris', 'Île-de-France', '75005', 'France');

-- Insertion des lignes de commande
-- Commande 1: Morphine et Étodolac
INSERT INTO LIGNE (QUANTITE, COMMANDE_NUMERO, MEDICAMENT_REFERENCE) VALUES
                                                                         (5, 1, 1),
                                                                         (3, 1, 4);

-- Commande 2: Doliprane et Flurbiprofène
INSERT INTO LIGNE (QUANTITE, COMMANDE_NUMERO, MEDICAMENT_REFERENCE) VALUES
                                                                         (10, 2, 2),
                                                                         (8, 2, 5);

-- Commande 3: Efferalgan, Lévofloxacine et Lisinopril
INSERT INTO LIGNE (QUANTITE, COMMANDE_NUMERO, MEDICAMENT_REFERENCE) VALUES
                                                                         (7, 3, 3),
                                                                         (4, 3, 6),
                                                                         (6, 3, 7);

-- Commande 4: Metformine et Amlodipine
INSERT INTO LIGNE (QUANTITE, COMMANDE_NUMERO, MEDICAMENT_REFERENCE) VALUES
                                                                         (12, 4, 9),
                                                                         (5, 4, 8);

-- Commande 5: Morphine, Clindamycine et Metformine
INSERT INTO LIGNE (QUANTITE, COMMANDE_NUMERO, MEDICAMENT_REFERENCE) VALUES
                                                                         (3, 5, 1),
                                                                         (2, 5, 7),
                                                                         (8, 5, 9);
