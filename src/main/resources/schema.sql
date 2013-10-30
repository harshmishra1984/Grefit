delimiter $$

CREATE DATABASE `rimt` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */$$

delimiter $$

CREATE TABLE `User` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `organisation_id` int(11) DEFAULT NULL,
  `first_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `address_line_1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `address_line2` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password_recovery_question` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `answer` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `created_at` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `updated_at` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin$$

delimiter $$

CREATE TABLE `inventory` (
  `inventory_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `city` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `location` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `inventory_type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `property_type` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `builder` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `project` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `bhk` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `size` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `unit` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `demand` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `payd_up` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `floor` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tower` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `booking` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `white_part` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `black_part` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `current_status` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`inventory_id`),
  UNIQUE KEY `inventory_id_UNIQUE` (`inventory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin$$

delimiter $$

CREATE TABLE `organisation` (
  `organisation_id` int(11) NOT NULL,
  `organisation_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `address_line_1` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `address_line2` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `state` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `website` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `created_at` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `updated_at` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`organisation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin$$


