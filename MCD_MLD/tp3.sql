-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 27 oct. 2023 à 13:31
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
-- Base de données : `tp3`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `numAgence` int NOT NULL AUTO_INCREMENT,
  `magasin` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`numAgence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `codeClient` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `nom` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rue` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ville` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `numAgence` int DEFAULT NULL,
  PRIMARY KEY (`codeClient`),
  KEY `numAgence` (`numAgence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `numCom` int NOT NULL AUTO_INCREMENT,
  `dateCom` date DEFAULT NULL,
  `codeClient` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`numCom`),
  KEY `codeClient` (`codeClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `composer`
--

DROP TABLE IF EXISTS `composer`;
CREATE TABLE IF NOT EXISTS `composer` (
  `numBL` int NOT NULL,
  `refProd` int NOT NULL,
  `qteLivree` int DEFAULT NULL,
  PRIMARY KEY (`numBL`,`refProd`),
  KEY `refProd` (`refProd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `concerner`
--

DROP TABLE IF EXISTS `concerner`;
CREATE TABLE IF NOT EXISTS `concerner` (
  `numCom` int NOT NULL,
  `refProd` int NOT NULL,
  `qteCom` int DEFAULT NULL,
  `prixUnit` int DEFAULT NULL,
  PRIMARY KEY (`numCom`,`refProd`),
  KEY `refProd` (`refProd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `numFact` int NOT NULL AUTO_INCREMENT,
  `dateFact` date DEFAULT NULL,
  PRIMARY KEY (`numFact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `livraison`
--

DROP TABLE IF EXISTS `livraison`;
CREATE TABLE IF NOT EXISTS `livraison` (
  `numBL` int NOT NULL AUTO_INCREMENT,
  `dateBL` date DEFAULT NULL,
  `numFact` int DEFAULT NULL,
  `numCom` int DEFAULT NULL,
  PRIMARY KEY (`numBL`),
  KEY `numFact` (`numFact`),
  KEY `numCom` (`numCom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `refProd` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tauxTVA` int DEFAULT NULL,
  PRIMARY KEY (`refProd`),
  KEY `tauxTVA` (`tauxTVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

DROP TABLE IF EXISTS `tva`;
CREATE TABLE IF NOT EXISTS `tva` (
  `codeTVA` int NOT NULL AUTO_INCREMENT,
  `taux` int DEFAULT NULL,
  PRIMARY KEY (`codeTVA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`numAgence`) REFERENCES `agence` (`numAgence`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`codeClient`) REFERENCES `client` (`codeClient`);

--
-- Contraintes pour la table `composer`
--
ALTER TABLE `composer`
  ADD CONSTRAINT `composer_ibfk_1` FOREIGN KEY (`numBL`) REFERENCES `livraison` (`numBL`),
  ADD CONSTRAINT `composer_ibfk_2` FOREIGN KEY (`refProd`) REFERENCES `produit` (`refProd`);

--
-- Contraintes pour la table `concerner`
--
ALTER TABLE `concerner`
  ADD CONSTRAINT `concerner_ibfk_1` FOREIGN KEY (`numCom`) REFERENCES `commande` (`numCom`),
  ADD CONSTRAINT `concerner_ibfk_2` FOREIGN KEY (`refProd`) REFERENCES `produit` (`refProd`);

--
-- Contraintes pour la table `livraison`
--
ALTER TABLE `livraison`
  ADD CONSTRAINT `livraison_ibfk_1` FOREIGN KEY (`numFact`) REFERENCES `facture` (`numFact`),
  ADD CONSTRAINT `livraison_ibfk_2` FOREIGN KEY (`numCom`) REFERENCES `commande` (`numCom`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`tauxTVA`) REFERENCES `tva` (`codeTVA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
