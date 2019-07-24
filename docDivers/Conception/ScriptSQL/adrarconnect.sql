-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 22 juil. 2019 à 13:19
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `adrarconnect`
--
CREATE DATABASE IF NOT EXISTS `adrarconnect` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `adrarconnect`;

-- --------------------------------------------------------

--
-- Structure de la table `avancementinscription`
--

DROP TABLE IF EXISTS `avancementinscription`;
CREATE TABLE IF NOT EXISTS `avancementinscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `avancementinscription`
--

INSERT INTO `avancementinscription` (`id`, `nom`) VALUES
(1, 'inscription'),
(2, 'infos personnelles'),
(3, 'documents'),
(4, 'inscription information collective'),
(5, 'participation information collective');

-- --------------------------------------------------------

--
-- Structure de la table `centredeformation`
--

DROP TABLE IF EXISTS `centredeformation`;
CREATE TABLE IF NOT EXISTS `centredeformation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numeroVoie` varchar(50) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `complementAdresse` varchar(255) DEFAULT NULL,
  `cp` varchar(50) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `coordoneeX` varchar(255) DEFAULT NULL,
  `coordoneeY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `documents`
--

DROP TABLE IF EXISTS `documents`;
CREATE TABLE IF NOT EXISTS `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base64` longtext NOT NULL,
  `etat` int(11) NOT NULL DEFAULT '0',
  `id_users` int(11) NOT NULL,
  `id_typeDocument` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `documents_users_FK` (`id_users`),
  KEY `documents_typeDocument0_FK` (`id_typeDocument`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;


--
-- Structure de la table `faq`
--

DROP TABLE IF EXISTS `faq`;
CREATE TABLE IF NOT EXISTS `faq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) NOT NULL,
  `reponse` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(255) NOT NULL,
  `urlPhoto` varchar(255) NOT NULL,
  `html` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Structure de la table `infocollective`
--

DROP TABLE IF EXISTS `infocollective`;
CREATE TABLE IF NOT EXISTS `infocollective` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` bigint(20) NOT NULL,
  `nbreMaxParticipant` int(11) NOT NULL DEFAULT '15',
  `complet` tinyint(1) NOT NULL DEFAULT '0',
  `id_centreDeFormation` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `infoCollective_centreDeFormation_FK` (`id_centreDeFormation`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Structure de la table `typedocument`
--

DROP TABLE IF EXISTS `typedocument`;
CREATE TABLE IF NOT EXISTS `typedocument` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `typedocument`
--

INSERT INTO `typedocument` (`id`, `nom`) VALUES
(1, 'photo'),
(2, 'CV'),
(3, 'lettre de motivation'),
(4, 'prescription PE');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `ddn` bigint(20) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `numeroPe` varchar(50) DEFAULT NULL,
  `mdp` varchar(255) NOT NULL,
  `numeroVoie` varchar(50) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `complementAdresse` varchar(255) DEFAULT NULL,
  `cp` varchar(50) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `dev` tinyint(1) DEFAULT '0',
  `reseau` tinyint(1) DEFAULT '0',
  `admin` tinyint(1) DEFAULT '0',
  `idSessionConnexion` varchar(255) DEFAULT NULL,
  `ID_infoCollective` int(11) NOT NULL DEFAULT '0',
  `ID_avancementInscription` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `users_infoCollective_FK` (`ID_infoCollective`),
  KEY `users_avancementInscription_FK` (`ID_avancementInscription`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;


--
-- Structure de la table `webview`
--

DROP TABLE IF EXISTS `webview`;
CREATE TABLE IF NOT EXISTS `webview` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `html` text NOT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `documents`
--
ALTER TABLE `documents`
  ADD CONSTRAINT `documents_typeDocument0_FK` FOREIGN KEY (`id_typeDocument`) REFERENCES `typedocument` (`id`),
  ADD CONSTRAINT `documents_users_FK` FOREIGN KEY (`id_users`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `infocollective`
--
ALTER TABLE `infocollective`
  ADD CONSTRAINT `infoCollective_centreDeFormation_FK` FOREIGN KEY (`id_centreDeFormation`) REFERENCES `centredeformation` (`id`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_avancementInscription_FK` FOREIGN KEY (`ID_avancementInscription`) REFERENCES `avancementinscription` (`id`),
  ADD CONSTRAINT `users_infoCollective_FK` FOREIGN KEY (`ID_infoCollective`) REFERENCES `infocollective` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
