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
  `dev` tinyint(1) DEFAULT NULL,
  `reseau` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `idSessionConnexion` varchar(255) DEFAULT NULL,
  `ID_infoCollective` int(11) DEFAULT NULL,
  `ID_avancementInscription` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `users_infoCollective_FK` (`ID_infoCollective`),
  KEY `users_avancementInscription_FK` (`ID_avancementInscription`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*ALTER TABLE `users` CHANGE `ID_avancementInscription` `ID_avancementInscription` INT(11) NULL DEFAULT '1';*/

--
-- modification de la table formation
--
ALTER TABLE `formation` CHANGE `url-photo` `urlPhoto` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
ALTER TABLE `formation` CHANGE `html` `html` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

--
-- modification de la table centre de formation
--
ALTER TABLE `centredeformation` CHANGE `complementAdresse` `complementAdresse` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;

--
-- modification de la table info collective
--
ALTER TABLE `infocollective` CHANGE `nbreMaxParticipant` `nbreMaxParticipant` INT(11) NOT NULL DEFAULT '15', CHANGE `complet` `complet` TINYINT(1) NOT NULL DEFAULT '0';

--
-- modif de la table document
--

ALTER TABLE `documents` CHANGE `chemin` `base64` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;