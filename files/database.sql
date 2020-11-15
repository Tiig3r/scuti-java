-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : Dim 15 nov. 2020 à 15:47
-- Version du serveur :  5.7.24
-- Version de PHP : 7.4.11

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
  `parent_id` int(11) NOT NULL DEFAULT '-1',
  `page_layout` enum('default_3x3','club_buy','club_gift','frontpage','spaces','recycler','recycler_info','recycler_prizes','trophies','plasto','marketplace','marketplace_own_items','spaces_new','soundmachine','guilds','guild_furni','info_duckets','info_rentables','info_pets','roomads','single_bundle','sold_ltd_items','badge_display','bots','pets','pets2','pets3','productpage1','room_bundle','recent_purchases','default_3x3_color_grouping','guild_forum','vip_buy','info_loyalty','loyalty_vip_buy','collectibles','petcustomization','frontpage_featured') CHARACTER SET latin1 NOT NULL DEFAULT 'default_3x3',
  `caption_save` varchar(25) CHARACTER SET latin1 NOT NULL,
  `caption` varchar(128) CHARACTER SET latin1 NOT NULL,
  `icon_color` int(5) NOT NULL DEFAULT '1',
  `icon_image` int(5) NOT NULL DEFAULT '1',
  `min_rank` int(5) NOT NULL DEFAULT '1',
  `order_num` int(5) NOT NULL DEFAULT '1',
  `room_id` int(5) NOT NULL DEFAULT '0',
  `visible` enum('0','1') CHARACTER SET latin1 NOT NULL DEFAULT '1',
  `enabled` enum('0','1') CHARACTER SET latin1 NOT NULL DEFAULT '1',
  `page_headline` varchar(1024) CHARACTER SET latin1 NOT NULL,
  `page_text1` text CHARACTER SET latin1
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
-- Structure de la table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `room_id` int(11) NOT NULL DEFAULT '0',
  `item_id` int(11) DEFAULT '0',
  `wall_pos` varchar(20) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `x` int(11) NOT NULL DEFAULT '0',
  `y` int(11) NOT NULL DEFAULT '0',
  `z` double(10,6) NOT NULL DEFAULT '0.000000',
  `rot` int(11) NOT NULL DEFAULT '0',
  `extra_data` varchar(1024) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `wired_data` varchar(256) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `limited_data` varchar(10) CHARACTER SET latin1 NOT NULL DEFAULT '0:0',
  `guild_id` int(32) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Déchargement des données de la table `items`
--

INSERT INTO `items` (`id`, `user_id`, `room_id`, `item_id`, `wall_pos`, `x`, `y`, `z`, `rot`, `extra_data`, `wired_data`, `limited_data`, `guild_id`) VALUES
(1, 0, 1, 2567, '', 3, 0, 0.000000, 0, '', '', '0:0', 0),
(2, 0, 1, 2643, '', 9, 0, 0.000000, 0, '', '', '0:0', 0),
(3, 0, 1, 2567, '', 6, 0, 0.000000, 0, '', '', '0:0', 0),
(4, 0, 3, 3400, '', 3, 14, 1.000000, 0, '', '', '0:0', 0),
(5, 0, 3, 3401, '', 3, 17, 1.000000, 0, '', '', '0:0', 0),
(6, 0, 4, 3433, '', 3, 11, 1.000000, 0, '', '', '0:0', 0),
(7, 0, 4, 3434, '', 6, 9, 1.000000, 0, '', '', '0:0', 0);

-- --------------------------------------------------------

--
-- Structure de la table `items_base`
--

CREATE TABLE `items_base` (
  `id` int(11) UNSIGNED NOT NULL,
  `sprite_id` int(11) NOT NULL DEFAULT '0',
  `public_name` varchar(56) NOT NULL DEFAULT '',
  `item_name` varchar(70) NOT NULL,
  `type` varchar(3) NOT NULL DEFAULT 's',
  `width` int(11) NOT NULL DEFAULT '1',
  `length` int(11) NOT NULL DEFAULT '1',
  `stack_height` double(4,2) NOT NULL DEFAULT '0.00',
  `allow_stack` tinyint(1) NOT NULL DEFAULT '1',
  `allow_sit` tinyint(1) NOT NULL DEFAULT '0',
  `allow_lay` tinyint(1) NOT NULL DEFAULT '0',
  `allow_walk` tinyint(1) NOT NULL DEFAULT '0',
  `allow_gift` tinyint(1) NOT NULL DEFAULT '1',
  `allow_trade` tinyint(1) NOT NULL DEFAULT '1',
  `allow_recycle` tinyint(1) NOT NULL DEFAULT '0',
  `allow_marketplace_sell` tinyint(1) NOT NULL DEFAULT '0',
  `allow_inventory_stack` tinyint(1) NOT NULL DEFAULT '1',
  `interaction_type` varchar(500) NOT NULL DEFAULT 'default',
  `interaction_modes_count` int(13) NOT NULL DEFAULT '1',
  `vending_ids` varchar(255) NOT NULL DEFAULT '0',
  `multiheight` varchar(50) NOT NULL DEFAULT '0',
  `customparams` varchar(256) NOT NULL DEFAULT '',
  `effect_id_male` int(3) NOT NULL DEFAULT '0',
  `effect_id_female` int(3) NOT NULL DEFAULT '0',
  `clothing_on_walk` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Déchargement des données de la table `items_base`
--

INSERT INTO `items_base` (`id`, `sprite_id`, `public_name`, `item_name`, `type`, `width`, `length`, `stack_height`, `allow_stack`, `allow_sit`, `allow_lay`, `allow_walk`, `allow_gift`, `allow_trade`, `allow_recycle`, `allow_marketplace_sell`, `allow_inventory_stack`, `interaction_type`, `interaction_modes_count`, `vending_ids`, `multiheight`, `customparams`, `effect_id_male`, `effect_id_female`, `clothing_on_walk`) VALUES
(2567, 2567, 'exe_rug', 'exe_rug', 's', 3, 3, 0.00, 1, 0, 0, 0, 1, 1, 0, 0, 1, 'default', 1, '0', '0', '', 0, 0, ''),
(2643, 2643, 'exe_bardesk', 'exe_bardesk', 's', 1, 1, 1.00, 1, 0, 0, 0, 1, 1, 0, 0, 1, 'default', 1, '0', '0', '', 0, 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL DEFAULT '0',
  `owner_name` varchar(255) NOT NULL DEFAULT '',
  `name` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `state` enum('open','locked','password') NOT NULL DEFAULT 'open',
  `users_max` int(11) NOT NULL DEFAULT '25',
  `thickness_wall` int(11) NOT NULL DEFAULT '8',
  `wall_height` int(11) NOT NULL DEFAULT '1',
  `thickness_floor` int(11) NOT NULL DEFAULT '8',
  `heightmap` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rooms`
--

INSERT INTO `rooms` (`id`, `owner_id`, `owner_name`, `name`, `description`, `password`, `state`, `users_max`, `thickness_wall`, `wall_height`, `thickness_floor`, `heightmap`) VALUES
(1, 1, 'Tig3r', 'Tig3r\'s room', 'The room of tig3r!', '', 'open', 0, 0, 1, 8, 1),
(3, 1, 'Tig3r', 'Model test', 'The room of tig3r!', '', 'open', 0, 0, 1, 16, 2),
(4, 1, 'Tig3r', 'Model test 2', 'The room of tig3r!', '', 'open', 0, 0, 1, 8, 3),
(5, 1, 'Tig3r', 'More complex model', 'The room of tig3r!', '', 'open', 0, 0, 1, 1, 4),
(6, 1, 'Tig3r', 'dddddddddd', 'dddddd', '', 'open', 10, 0, 1, 0, 1),
(7, 1, 'Tig3r', 'model 7', '', '', 'open', 10, 8, 1, 8, 7),
(8, 1, 'Tig3r', 'my room', '', '', 'open', 10, 8, 1, 8, 21),
(9, 1, 'Tig3r', 'is back', '', '', 'open', 50, 8, 1, 8, 24);

-- --------------------------------------------------------

--
-- Structure de la table `room_models`
--

CREATE TABLE `room_models` (
  `id` int(11) NOT NULL,
  `door_x` int(11) NOT NULL,
  `door_y` int(11) NOT NULL,
  `door_dir` int(11) NOT NULL,
  `heightmap` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `room_models`
--

INSERT INTO `room_models` (`id`, `door_x`, `door_y`, `door_dir`, `heightmap`) VALUES
(1, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxx000000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxx00000000\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(2, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxx0000000\r\nxxxxx0000000\r\nxxxxx0000000\r\nxxxxx0000000\r\n000000000000\r\nx00000000000\r\nx00000000000\r\nx00000000000\r\nx00000000000\r\nx00000000000\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(3, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxx0000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(4, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxx0000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxxxxxxxxxxx\r\n'),
(5, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxx0000000000\r\nxx0000000000\r\nx00000000000\r\nxx0000000000\r\nxx0000000000\r\nxx0000000000\r\nxx0000000000\r\nxx0000000000\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(6, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxxxx0000x\r\nxxxxxxx0000x\r\nxxx00000000x\r\nxxx00000000x\r\nxx000000000x\r\nxxx00000000x\r\nx0000000000x\r\nx0000000000x\r\nx0000000000x\r\nx0000000000x\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(7, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxx00000\r\nxxxxxxx00000\r\nxxxxxxx00000\r\nxx1111000000\r\nxx1111000000\r\nx11111000000\r\nxx1111000000\r\nxx1111000000\r\nxxxxxxx00000\r\nxxxxxxx00000\r\nxxxxxxx00000\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(8, 1, 1, 1, 'xxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxx111111x\r\nxxxxx111111x\r\nxxxx1111111x\r\nxxxxx111111x\r\nxxxxx111111x\r\nxxxxx000000x\r\nxxxxx000000x\r\nxxx00000000x\r\nxxx00000000x\r\nxxx00000000x\r\nxxx00000000x\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\nxxxxxxxxxxxx\r\n'),
(9, 1, 1, 1, 'xxxxxxxxxxxxxxxxx\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\n00000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nx0000000000000000\r\nxxxxxxxxxxxxxxxxx\r\n'),
(10, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxx0000000000\r\nxxxxxxxxxxx0000000000\r\nxxxxxxxxxxx0000000000\r\nxxxxxxxxxxx0000000000\r\nxxxxxxxxxxx0000000000\r\nxxxxxxxxxxx0000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\n000000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx0000000000xxxxxxxxxx\r\nx0000000000xxxxxxxxxx\r\nx0000000000xxxxxxxxxx\r\nx0000000000xxxxxxxxxx\r\nx0000000000xxxxxxxxxx\r\nx0000000000xxxxxxxxxx\r\nxxxxxxxxxxxxxxxxxxxxx\r\n'),
(11, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxxxxxxxx00000000\r\nxxxxxxxxxxxxxxxxx00000000\r\nxxxxxxxxxxxxxxxxx00000000\r\nxxxxxxxxxxxxxxxxx00000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nx000000000000000000000000\r\nx000000000000000000000000\r\nx000000000000000000000000\r\nx000000000000000000000000\r\n0000000000000000000000000\r\nx000000000000000000000000\r\nx000000000000000000000000\r\nx000000000000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(12, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxx\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\n000000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nx00000000xxxx00000000\r\nxxxxxxxxxxxxxxxxxxxxx\r\n'),
(13, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nx0000000000000000000000000000\r\nx0000000000000000000000000000\r\nx0000000000000000000000000000\r\nx0000000000000000000000000000\r\n00000000000000000000000000000\r\nx0000000000000000000000000000\r\nx0000000000000000000000000000\r\nx0000000000000000000000000000\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxx00000000xxxxxxxxxx\r\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(14, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxx\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx000000xxxxxxxx000000\r\nx000000x000000x000000\r\nx000000x000000x000000\r\nx000000x000000x000000\r\nx000000x000000x000000\r\nx000000x000000x000000\r\nx000000x000000x000000\r\nx000000xxxxxxxx000000\r\nx00000000000000000000\r\n000000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nx00000000000000000000\r\nxxxxxxxxxxxxxxxxxxxxx\r\n'),
(15, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx11111111xxxx\r\nxxxxxxxxxxxxx00000000xxxx\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nx111111100000000000000000\r\nx111111100000000000000000\r\nx111111100000000000000000\r\n1111111100000000000000000\r\nx111111100000000000000000\r\nx111111100000000000000000\r\nx111111100000000000000000\r\nx111111100000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxx0000000000000000\r\nxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(16, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxx\r\nxxxxxxx222222222222\r\nxxxxxxx222222222222\r\nxxxxxxx222222222222\r\nxxxxxxx222222222222\r\nxxxxxxx222222222222\r\nxxxxxxx222222222222\r\nxxxxxxx22222222xxxx\r\nxxxxxxx11111111xxxx\r\nx222221111111111111\r\nx222221111111111111\r\nx222221111111111111\r\nx222221111111111111\r\nx222221111111111111\r\nx222221111111111111\r\nx222221111111111111\r\nx222221111111111111\r\nx2222xx11111111xxxx\r\nx2222xx00000000xxxx\r\nx2222xx000000000000\r\nx2222xx000000000000\r\nx2222xx000000000000\r\nx2222xx000000000000\r\n22222xx000000000000\r\nx2222xx000000000000\r\nxxxxxxxxxxxxxxxxxxx\r\n'),
(17, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxx22222222\r\nxxxxxxxxxxx22222222\r\nxxxxxxxxxxx22222222\r\nxxxxxxxxxx222222222\r\nxxxxxxxxxxx22222222\r\nxxxxxxxxxxx22222222\r\nx222222222222222222\r\nx222222222222222222\r\nx222222222222222222\r\nx222222222222222222\r\nx222222222222222222\r\nx222222222222222222\r\nx2222xxxxxxxxxxxxxx\r\nx2222xxxxxxxxxxxxxx\r\nx2222211111xx000000\r\nx222221111110000000\r\nx222221111110000000\r\nx2222211111xx000000\r\nxx22xxx1111xxxxxxxx\r\nxx11xxx1111xxxxxxxx\r\nx1111xx1111xx000000\r\nx1111xx111110000000\r\nx1111xx111110000000\r\nx1111xx1111xx000000\r\nxxxxxxxxxxxxxxxxxxx\r\n'),
(18, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxx33333333333333\r\nxxxxxxxxxxx33333333333333\r\nxxxxxxxxxxx33333333333333\r\nxxxxxxxxxx333333333333333\r\nxxxxxxxxxxx33333333333333\r\nxxxxxxxxxxx33333333333333\r\nxxxxxxx333333333333333333\r\nxxxxxxx333333333333333333\r\nxxxxxxx333333333333333333\r\nxxxxxxx333333333333333333\r\nxxxxxxx333333333333333333\r\nxxxxxxx333333333333333333\r\nx4444433333xxxxxxxxxxxxxx\r\nx4444433333xxxxxxxxxxxxxx\r\nx44444333333222xx000000xx\r\nx44444333333222xx000000xx\r\nxxx44xxxxxxxx22xx000000xx\r\nxxx33xxxxxxxx11xx000000xx\r\nxxx33322222211110000000xx\r\nxxx33322222211110000000xx\r\nxxxxxxxxxxxxxxxxx000000xx\r\nxxxxxxxxxxxxxxxxx000000xx\r\nxxxxxxxxxxxxxxxxx000000xx\r\nxxxxxxxxxxxxxxxxx000000xx\r\nxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(19, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx222222222222222222222222222x\r\nx222222222222222222222222222x\r\n2222222222222222222222222222x\r\nx222222222222222222222222222x\r\nx2222xxxxxx222222xxxxxxx2222x\r\nx2222xxxxxx111111xxxxxxx2222x\r\nx2222xx111111111111111xx2222x\r\nx2222xx111111111111111xx2222x\r\nx2222xx11xxx1111xxxx11xx2222x\r\nx2222xx11xxx0000xxxx11xx2222x\r\nx22222111x00000000xx11xx2222x\r\nx22222111x00000000xx11xx2222x\r\nx22222111x00000000xx11xx2222x\r\nx22222111x00000000xx11xx2222x\r\nx22222111x00000000xx11xx2222x\r\nx22222111x00000000xx11xx2222x\r\nx2222xx11xxxxxxxxxxx11xx2222x\r\nx2222xx11xxxxxxxxxxx11xx2222x\r\nx2222xx111111111111111xx2222x\r\nx2222xx111111111111111xx2222x\r\nx2222xxxxxxxxxxxxxxxxxxx2222x\r\nx2222xxxxxxxxxxxxxxxxxxx2222x\r\nx222222222222222222222222222x\r\nx222222222222222222222222222x\r\nx222222222222222222222222222x\r\nx222222222222222222222222222x\r\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(20, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxx\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\n11111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nx1111100000000000000000x\r\nxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(21, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxx\r\nx222221111111111111x\r\nx222221111111111111x\r\n2222221111111111111x\r\nx222221111111111111x\r\nx222221111111111111x\r\nx222221111111111111x\r\nxxxxxxxx1111xxxxxxxx\r\nxxxxxxxx0000xxxxxxxx\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx00000000000x000000x\r\nx00000000000x000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nxxxxxxxx00000000000x\r\nx000000x00000000000x\r\nx000000x0000xxxxxxxx\r\nx00000000000x000000x\r\nx00000000000x000000x\r\nx00000000000x000000x\r\nx00000000000x000000x\r\nxxxxxxxx0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nxxxxxxxxxxxxxxxxxxxx\r\n'),
(22, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx2222xx1111111111xx11111111\r\nx2222xx1111111111xx11111111\r\n222222111111111111111111111\r\nx22222111111111111111111111\r\nx22222111111111111111111111\r\nx22222111111111111111111111\r\nx2222xx1111111111xx11111111\r\nx2222xx1111111111xx11111111\r\nx2222xx1111111111xxxx1111xx\r\nx2222xx1111111111xxxx0000xx\r\nxxxxxxx1111111111xx00000000\r\nxxxxxxx1111111111xx00000000\r\nx22222111111111111000000000\r\nx22222111111111111000000000\r\nx22222111111111111000000000\r\nx22222111111111111000000000\r\nx2222xx1111111111xx00000000\r\nx2222xx1111111111xx00000000\r\nx2222xxxx1111xxxxxxxxxxxxxx\r\nx2222xxxx0000xxxxxxxxxxxxxx\r\nx2222x0000000000xxxxxxxxxxx\r\nx2222x0000000000xxxxxxxxxxx\r\nx2222x0000000000xxxxxxxxxxx\r\nx2222x0000000000xxxxxxxxxxx\r\nx2222x0000000000xxxxxxxxxxx\r\nx2222x0000000000xxxxxxxxxxx\r\n'),
(23, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxx\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nxxx00xxx0000xxx00xxx\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\n0000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000x0000x000000x\r\nx000000xxxxxx000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nx000000000000000000x\r\nxxxxxxxxxxxxxxxxxxxx\r\n'),
(24, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx00000000xx0000000000xx0000x\r\nx00000000xx0000000000xx0000x\r\n000000000xx0000000000xx0000x\r\nx00000000xx0000000000xx0000x\r\nx00000000xx0000xx0000xx0000x\r\nx00000000xx0000xx0000xx0000x\r\nx00000000xx0000xx0000000000x\r\nx00000000xx0000xx0000000000x\r\nxxxxx0000xx0000xx0000000000x\r\nxxxxx0000xx0000xx0000000000x\r\nxxxxx0000xx0000xxxxxxxxxxxxx\r\nxxxxx0000xx0000xxxxxxxxxxxxx\r\nx00000000xx0000000000000000x\r\nx00000000xx0000000000000000x\r\nx00000000xx0000000000000000x\r\nx00000000xx0000000000000000x\r\nx0000xxxxxxxxxxxxxxxxxx0000x\r\nx0000xxxxxxxxxxxxxxxxxx0000x\r\nx00000000000000000000000000x\r\nx00000000000000000000000000x\r\nx00000000000000000000000000x\r\nx00000000000000000000000000x\r\nxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(25, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxx00000000000000000000\r\nxxxxxxxxxxx00000000000000000000\r\nxxxxxxxxxxx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\n000000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nx00000000xx00000000000000000000\r\nxxxxxxxxxxx00000000000000000000\r\nxxxxxxxxxxx00000000000000000000\r\nxxxxxxxxxxx00000000000000000000\r\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n'),
(26, 1, 1, 1, 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0000\r\n000000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0000\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0000\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx0000\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nx00000000xx00000000xx00000000xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n');

-- --------------------------------------------------------

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
-- Index pour la table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `room_id` (`user_id`,`room_id`) USING BTREE,
  ADD KEY `itemsdata` (`room_id`,`item_id`) USING BTREE,
  ADD KEY `user_id` (`user_id`) USING BTREE,
  ADD KEY `extra_data` (`extra_data`) USING BTREE,
  ADD KEY `wired_data` (`wired_data`) USING BTREE,
  ADD KEY `id` (`id`) USING BTREE;

--
-- Index pour la table `items_base`
--
ALTER TABLE `items_base`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Index pour la table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `room_models`
--
ALTER TABLE `room_models`
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
-- AUTO_INCREMENT pour la table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `room_models`
--
ALTER TABLE `room_models`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
