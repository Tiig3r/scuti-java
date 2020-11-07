-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 15 août 2020 à 14:09
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `scuti`
--

-- --------------------------------------------------------

--
-- Structure de la table `catalog_featured_pages`
--

CREATE TABLE `catalog_featured_pages` (
  `slot_id` int(11) NOT NULL,
  `image` varchar(70) NOT NULL,
  `caption` varchar(130) NOT NULL,
  `type` enum('page_name','page_id','product_name') NOT NULL,
  `expire_timestamp` int(11) NOT NULL,
  `page_name` varchar(30) NOT NULL,
  `page_id` int(11) NOT NULL,
  `product_name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `catalog_featured_pages`
--

INSERT INTO `catalog_featured_pages` (`slot_id`, `image`, `caption`, `type`, `expire_timestamp`, `page_name`, `page_id`, `product_name`) VALUES
(1, 'feature_cata_vert_india20_tiger.png', 'Rare Tigre du Bengale', 'page_name', -1, 'cccccc', 0, ''),
(2, 'feature_cata_hort_india20_bun3.png', 'Pack Festival Indien', 'page_name', -1, 'cccccc', 0, ''),
(3, 'feature_cata_hort_santo17_bun2.png', 'Village de Fira', 'page_name', -1, 'cccccc', 0, ''),
(4, 'feature_cata_hort_india20_newclothing.png', 'Vêtements Palais indien', 'page_name', -1, 'cccccc', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `catalog_pages`
--

CREATE TABLE `catalog_pages` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL DEFAULT -1,
  `page_layout` enum('default_3x3','club_buy','club_gift','frontpage','spaces','recycler','recycler_info','recycler_prizes','trophies','plasto','marketplace','marketplace_own_items','spaces_new','soundmachine','guilds','guild_furni','info_duckets','info_rentables','info_pets','roomads','single_bundle','sold_ltd_items','badge_display','bots','pets','pets2','pets3','productpage1','room_bundle','recent_purchases','default_3x3_color_grouping','guild_forum','vip_buy','info_loyalty','loyalty_vip_buy','collectibles','petcustomization','frontpage_featured') CHARACTER SET latin1 NOT NULL DEFAULT 'default_3x3',
  `caption_save` varchar(25) CHARACTER SET latin1 NOT NULL,
  `caption` varchar(128) CHARACTER SET latin1 NOT NULL,
  `icon_color` int(5) NOT NULL DEFAULT 1,
  `icon_image` int(5) NOT NULL DEFAULT 1,
  `min_rank` int(5) NOT NULL DEFAULT 1,
  `order_num` int(5) NOT NULL DEFAULT 1,
  `room_id` int(5) NOT NULL DEFAULT 0,
  `visible` enum('0','1') CHARACTER SET latin1 NOT NULL DEFAULT '1',
  `enabled` enum('0','1') CHARACTER SET latin1 NOT NULL DEFAULT '1',
  `page_headline` varchar(1024) CHARACTER SET latin1 NOT NULL,
  `page_text1` text CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `catalog_pages`
--

INSERT INTO `catalog_pages` (`id`, `parent_id`, `page_layout`, `caption_save`, `caption`, `icon_color`, `icon_image`, `min_rank`, `order_num`, `room_id`, `visible`, `enabled`, `page_headline`, `page_text1`) VALUES
(1, -1, 'frontpage', 'frontpage', 'Accueil', 1, 213, 1, 1, 0, '1', '1', 'catalog_frontpage_headline_shop_FR', 'Zebi c\'est la page d\'accueil tkt frer'),
(2, -1, 'default_3x3', 'frontpage', 'Mobi', 1, 202, 1, 2, 0, '1', '1', 'catalog_hot_header_en', 'tkt c la page d mobis enft :drooling_face:'),
(3, -1, 'pets2', 'frontpage', 'Animaux', 1, 8, 1, 4, 0, '1', '1', 'catalog_pet_headline1_fr', 'machala ça marche trop bien wala ame doux lila enft'),
(4, -1, 'default_3x3', 'frontpage', 'Vêtement', 1, 213, 1, 3, 0, '0', '1', '', NULL),
(5, -1, 'default_3x3', 'frontpage', 'Abonnements', 1, 213, 1, 5, 0, '0', '1', '', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `name` int(11) NOT NULL,
  `description` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `room_id` int(11) NOT NULL DEFAULT 0,
  `item_id` int(11) DEFAULT 0,
  `wall_pos` varchar(20) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `x` int(11) NOT NULL DEFAULT 0,
  `y` int(11) NOT NULL DEFAULT 0,
  `z` double(10,6) NOT NULL DEFAULT 0.000000,
  `rot` int(11) NOT NULL DEFAULT 0,
  `extra_data` varchar(1024) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `wired_data` varchar(256) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `limited_data` varchar(10) CHARACTER SET latin1 NOT NULL DEFAULT '0:0',
  `guild_id` int(32) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `sso` int(11) NOT NULL,
  `credits` int(11) NOT NULL,
  `pixels` int(11) NOT NULL,
  `diamonds` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `sso`, `credits`, `pixels`, `diamonds`) VALUES
(1, 'Tig3r', 0, 1000, 5, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `catalog_featured_pages`
--
ALTER TABLE `catalog_featured_pages`
  ADD UNIQUE KEY `slot_id` (`slot_id`);

--
-- Index pour la table `catalog_pages`
--
ALTER TABLE `catalog_pages`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `catalog_pages`
--
ALTER TABLE `catalog_pages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_id` (`user_id`,`room_id`) USING BTREE,
  ADD KEY `itemsdata` (`room_id`,`item_id`) USING BTREE,
  ADD KEY `user_id` (`user_id`) USING BTREE,
  ADD KEY `extra_data` (`extra_data`) USING BTREE,
  ADD KEY `wired_data` (`wired_data`) USING BTREE,
  ADD KEY `id` (`id`) USING BTREE;