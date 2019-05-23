-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Jeu 23 Mai 2019 à 16:14
-- Version du serveur :  10.1.26-MariaDB-0+deb9u1
-- Version de PHP :  7.0.33-0+deb9u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ldnr_tchat`
--

-- --------------------------------------------------------

--
-- Structure de la table `tchat`
--

CREATE TABLE `tchat` (
  `id_tchat` int(10) NOT NULL,
  `date_message` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userName` varchar(40) NOT NULL,
  `message` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `tchat`
--

INSERT INTO `tchat` (`id_tchat`, `date_message`, `userName`, `message`) VALUES
(26, '2019-05-23 12:37:06', 'coucou', 'je suis une personne'),
(27, '2019-05-23 12:39:08', 'test', 'coucou'),
(28, '2019-05-23 12:39:55', 'autre moi', 'toiiiiiiiii'),
(29, '2019-05-23 12:40:05', 'elle', 'quoi????'),
(30, '2019-05-23 12:40:17', 'lui', '�y!'),
(31, '2019-05-23 12:40:51', 'moi', 'allez, bye!'),
(32, '2019-05-23 12:40:54', 'moi', 'allez, bye!'),
(33, '2019-05-23 12:41:37', 'moi', 'allez, bye!'),
(34, '2019-05-23 13:51:18', 'rror', 'allez, bye!'),
(35, '2019-05-23 13:51:28', 'un autre', 'coucou'),
(36, '2019-05-23 13:51:34', 'poiuuoijioj', 'qsg');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `tchat`
--
ALTER TABLE `tchat`
  ADD PRIMARY KEY (`id_tchat`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `tchat`
--
ALTER TABLE `tchat`
  MODIFY `id_tchat` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;