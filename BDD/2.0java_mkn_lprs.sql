-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 15 jan. 2024 à 09:17
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `java_mkn_lprs`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ref_fournisseur` bigint NOT NULL,
  `ref_gestionnaireStock` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_commande_fournisseur` (`ref_fournisseur`),
  KEY `fr_commande_gestionnaireStock` (`ref_gestionnaireStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commandequantite`
--

DROP TABLE IF EXISTS `commandequantite`;
CREATE TABLE IF NOT EXISTS `commandequantite` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ref_commande` bigint NOT NULL,
  `ref_fourniture` bigint NOT NULL,
  `quantite` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_commandequantite_commande` (`ref_commande`),
  KEY `fr_commandequantite_fichefourniture` (`ref_fourniture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `demandefourniture`
--

DROP TABLE IF EXISTS `demandefourniture`;
CREATE TABLE IF NOT EXISTS `demandefourniture` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `raison` varchar(255) NOT NULL,
  `quantite_demande` varchar(255) NOT NULL,
  `fourniture_demande` varchar(255) NOT NULL,
  `valide` tinyint(1) NOT NULL DEFAULT '0',
  `ref_ficheFourniture` bigint NOT NULL,
  `ref_professeur` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_demandefourniture_professeur` (`ref_professeur`),
  KEY `fr_demandefourniture_ficheFourniture` (`ref_ficheFourniture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `dossierinscription`
--

DROP TABLE IF EXISTS `dossierinscription`;
CREATE TABLE IF NOT EXISTS `dossierinscription` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `filiere` varchar(255) NOT NULL,
  `motivation` varchar(255) NOT NULL,
  `ref_ficheEtudiant` bigint NOT NULL,
  `ref_secretaire` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_dossierinscription_ficheetudiant` (`ref_ficheEtudiant`),
  KEY `fr_dossierinscription_ficheetudiant_secretaire` (`ref_secretaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ficheetudiant`
--

DROP TABLE IF EXISTS `ficheetudiant`;
CREATE TABLE IF NOT EXISTS `ficheetudiant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `dernier_diplome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `ref_secretaire` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_ficheetudiant_users` (`ref_secretaire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fichefourniture`
--

DROP TABLE IF EXISTS `fichefourniture`;
CREATE TABLE IF NOT EXISTS `fichefourniture` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `quantite` varchar(255) NOT NULL,
  `ref_gestionnaireStock` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_fichefourniture_gestionnairestock` (`ref_gestionnaireStock`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournitureprix`
--

DROP TABLE IF EXISTS `fournitureprix`;
CREATE TABLE IF NOT EXISTS `fournitureprix` (
  `ref_fournisseur` bigint NOT NULL,
  `ref_fourniture` bigint NOT NULL,
  `prix` varchar(255) NOT NULL,
  KEY `fr_fournitureprix_fournisseur` (`ref_fournisseur`),
  KEY `fr_fournitureprix_fourniture` (`ref_fourniture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
CREATE TABLE IF NOT EXISTS `rendezvous` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_rendez_vous` datetime NOT NULL,
  `ref_dossierInscription` bigint NOT NULL,
  `ref_professeur` bigint NOT NULL,
  `ref_salle` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fr_rendezvous_dossierInscription` (`ref_dossierInscription`),
  KEY `fr_rendezvous_users` (`ref_professeur`),
  KEY `fr_rendezvous_salle` (`ref_salle`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` bigint NOT NULL,
  `numero` varchar(255) NOT NULL,
  `disponible` tinyint(1) NOT NULL DEFAULT '1',
  KEY `idx_salle_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profil` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `ref_fournisseur` FOREIGN KEY (`ref_fournisseur`) REFERENCES `fournisseur` (`id`),
  ADD CONSTRAINT `ref_gestionnaireStock` FOREIGN KEY (`ref_gestionnaireStock`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `commandequantite`
--
ALTER TABLE `commandequantite`
  ADD CONSTRAINT `ref_commande` FOREIGN KEY (`ref_commande`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `ref_fourniture` FOREIGN KEY (`ref_fourniture`) REFERENCES `fichefourniture` (`id`);

--
-- Contraintes pour la table `demandefourniture`
--
ALTER TABLE `demandefourniture`
  ADD CONSTRAINT `fk_ref_professeur` FOREIGN KEY (`ref_professeur`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `ref_fichefourniture` FOREIGN KEY (`ref_ficheFourniture`) REFERENCES `fichefourniture` (`id`);

--
-- Contraintes pour la table `dossierinscription`
--
ALTER TABLE `dossierinscription`
  ADD CONSTRAINT `fk_ref_ficheetudiant` FOREIGN KEY (`ref_ficheEtudiant`) REFERENCES `ficheetudiant` (`id`),
  ADD CONSTRAINT `fk_ref_secretaire` FOREIGN KEY (`ref_secretaire`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `ficheetudiant`
--
ALTER TABLE `ficheetudiant`
  ADD CONSTRAINT `ref_secretaire` FOREIGN KEY (`ref_secretaire`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `fichefourniture`
--
ALTER TABLE `fichefourniture`
  ADD CONSTRAINT `fichefourniture_ibfk_1` FOREIGN KEY (`id`) REFERENCES `rendezvous` (`ref_dossierInscription`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fournitureprix`
--
ALTER TABLE `fournitureprix`
  ADD CONSTRAINT `fk_ref_fournisseur` FOREIGN KEY (`ref_fournisseur`) REFERENCES `fournisseur` (`id`),
  ADD CONSTRAINT `fk_ref_fourniture` FOREIGN KEY (`ref_fourniture`) REFERENCES `fichefourniture` (`id`);

--
-- Contraintes pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD CONSTRAINT `ref_dossierInscription` FOREIGN KEY (`ref_dossierInscription`) REFERENCES `dossierinscription` (`id`),
  ADD CONSTRAINT `ref_professeur` FOREIGN KEY (`ref_professeur`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `ref_salle` FOREIGN KEY (`ref_salle`) REFERENCES `salle` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
