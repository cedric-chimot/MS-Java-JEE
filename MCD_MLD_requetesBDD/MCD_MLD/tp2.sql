-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 27 oct. 2023 à 08:14
-- Version du serveur : 8.0.31
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tp2`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `numAgence` int NOT NULL AUTO_INCREMENT,
  `adresse` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `responsable` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`numAgence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `competences`
--

DROP TABLE IF EXISTS `competences`;
CREATE TABLE IF NOT EXISTS `competences` (
  `nomCompet` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `categorie` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`nomCompet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `contrats`
--

DROP TABLE IF EXISTS `contrats`;
CREATE TABLE IF NOT EXISTS `contrats` (
  `numContrat` int NOT NULL AUTO_INCREMENT,
  `dateDebut` date DEFAULT NULL,
  `dateFin` date DEFAULT NULL,
  `duree` int DEFAULT NULL,
  `numDevis` int DEFAULT NULL,
  PRIMARY KEY (`numContrat`),
  KEY `numDevis` (`numDevis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `demandeplacement`
--

DROP TABLE IF EXISTS `demandeplacement`;
CREATE TABLE IF NOT EXISTS `demandeplacement` (
  `numDemande` int NOT NULL AUTO_INCREMENT,
  `dateDemande` date DEFAULT NULL,
  `lieuIntervention` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `numEnt` int DEFAULT NULL,
  `numAgence` int DEFAULT NULL,
  `numDevis` int DEFAULT NULL,
  PRIMARY KEY (`numDemande`),
  KEY `numEnt` (`numEnt`),
  KEY `numAgence` (`numAgence`),
  KEY `numDevis` (`numDevis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

DROP TABLE IF EXISTS `devis`;
CREATE TABLE IF NOT EXISTS `devis` (
  `numDevis` int NOT NULL AUTO_INCREMENT,
  `dateDevis` date DEFAULT NULL,
  PRIMARY KEY (`numDevis`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `disposer`
--

DROP TABLE IF EXISTS `disposer`;
CREATE TABLE IF NOT EXISTS `disposer` (
  `numExpert` int NOT NULL,
  `nomCompet` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`numExpert`,`nomCompet`),
  KEY `nomCompet` (`nomCompet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `entrcliente`
--

DROP TABLE IF EXISTS `entrcliente`;
CREATE TABLE IF NOT EXISTS `entrcliente` (
  `numEnt` int NOT NULL AUTO_INCREMENT,
  `numSiret` int DEFAULT NULL,
  `nom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `adresse` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fax` int DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`numEnt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `experts`
--

DROP TABLE IF EXISTS `experts`;
CREATE TABLE IF NOT EXISTS `experts` (
  `numExpert` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prenom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `diplome` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prix` int DEFAULT NULL,
  `numAgence` int DEFAULT NULL,
  PRIMARY KEY (`numExpert`),
  KEY `experts_ibfk_1` (`numAgence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `necessiter`
--

DROP TABLE IF EXISTS `necessiter`;
CREATE TABLE IF NOT EXISTS `necessiter` (
  `nomCompet` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `numDemande` int NOT NULL,
  PRIMARY KEY (`nomCompet`,`numDemande`),
  KEY `numDemande` (`numDemande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `rapports`
--

DROP TABLE IF EXISTS `rapports`;
CREATE TABLE IF NOT EXISTS `rapports` (
  `numRapport` int NOT NULL AUTO_INCREMENT,
  `url` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dateRapport` date DEFAULT NULL,
  `numContrat` int DEFAULT NULL,
  PRIMARY KEY (`numRapport`),
  KEY `numContrat` (`numContrat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `realiser`
--

DROP TABLE IF EXISTS `realiser`;
CREATE TABLE IF NOT EXISTS `realiser` (
  `numExpert` int NOT NULL,
  `numContrat` int NOT NULL,
  PRIMARY KEY (`numExpert`,`numContrat`),
  KEY `numContrat` (`numContrat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contrats`
--
ALTER TABLE `contrats`
  ADD CONSTRAINT `contrats_ibfk_1` FOREIGN KEY (`numDevis`) REFERENCES `devis` (`numDevis`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `demandeplacement`
--
ALTER TABLE `demandeplacement`
  ADD CONSTRAINT `demandeplacement_ibfk_1` FOREIGN KEY (`numEnt`) REFERENCES `entrcliente` (`numEnt`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `demandeplacement_ibfk_2` FOREIGN KEY (`numAgence`) REFERENCES `agence` (`numAgence`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `demandeplacement_ibfk_3` FOREIGN KEY (`numDevis`) REFERENCES `devis` (`numDevis`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `disposer`
--
ALTER TABLE `disposer`
  ADD CONSTRAINT `disposer_ibfk_1` FOREIGN KEY (`nomCompet`) REFERENCES `competences` (`nomCompet`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `disposer_ibfk_2` FOREIGN KEY (`numExpert`) REFERENCES `experts` (`numExpert`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `experts`
--
ALTER TABLE `experts`
  ADD CONSTRAINT `experts_ibfk_1` FOREIGN KEY (`numAgence`) REFERENCES `agence` (`numAgence`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `necessiter`
--
ALTER TABLE `necessiter`
  ADD CONSTRAINT `necessiter_ibfk_1` FOREIGN KEY (`nomCompet`) REFERENCES `competences` (`nomCompet`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `necessiter_ibfk_2` FOREIGN KEY (`numDemande`) REFERENCES `demandeplacement` (`numDemande`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `rapports`
--
ALTER TABLE `rapports`
  ADD CONSTRAINT `rapports_ibfk_1` FOREIGN KEY (`numContrat`) REFERENCES `contrats` (`numContrat`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `realiser`
--
ALTER TABLE `realiser`
  ADD CONSTRAINT `realiser_ibfk_1` FOREIGN KEY (`numContrat`) REFERENCES `contrats` (`numContrat`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `realiser_ibfk_2` FOREIGN KEY (`numExpert`) REFERENCES `experts` (`numExpert`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
