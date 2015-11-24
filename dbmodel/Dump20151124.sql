-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: rokomari
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_fk` int(11) DEFAULT NULL,
  `authority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`authority_id`),
  KEY `user_id_fk_idx` (`user_id_fk`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,1,'USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(200) NOT NULL,
  `author_bio` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'হুমায়ূন আহমেদ',NULL),(2,'তসলিমা নাসরিন',NULL),(3,'সিরাজুল ইসলাম চৌধুরী',NULL),(4,'সুমন্ত আসলাম',NULL);
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `books_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `categories` varchar(2000) DEFAULT NULL,
  `isbn` varchar(100) NOT NULL,
  `edition` varchar(100) DEFAULT NULL,
  `no_of_pages` int(11) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `previous_price` double DEFAULT NULL,
  `current_price` double DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `author_id_fk` int(11) DEFAULT NULL,
  `publisher_id_fk` int(11) DEFAULT NULL,
  `subject_id_fk` int(11) DEFAULT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `book_summary` text,
  PRIMARY KEY (`books_id`,`isbn`),
  KEY `author_id_fk_idx` (`author_id_fk`),
  KEY `publishers_id_fk_idx` (`publisher_id_fk`),
  KEY `subject_id_fk_idx` (`subject_id_fk`),
  CONSTRAINT `author_id_fk` FOREIGN KEY (`author_id_fk`) REFERENCES `authors` (`author_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `publisher_id_fk` FOREIGN KEY (`publisher_id_fk`) REFERENCES `publishers` (`publisher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `subject_id_fk` FOREIGN KEY (`subject_id_fk`) REFERENCES `subjects` (`subject_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'শরম','Book , Novel , Contemporary Novel , Boimela 2015 , Novel, Short Story & Drama','9789849136545','1st, 2015',271,'Bangladesh','Bangla',400,340,1,NULL,NULL,2,2,1,'http://d1cdd9ctvqfjk5.cloudfront.net/av/rokimg_20150307_94328.gif','মেয়েটি উঠতে চায় নিজে, পারে না। সুরঞ্জনকে উঠে মেয়েটাকে তুলে ধরতে হয়। তার সারা গায়ে ব্যাথা। জায়জায় জায়জায় ক্ষত, কোনওটাতে রক্ত। ও নিয়েই সে জুলেখাকে সায়া ব্লাউজ পরিয়ে দেয়, শাড়ি পরিয়ে দেয়। মেয়েটার সম্ভবত মাথা ঘোরায়, দাঁড়াতে গেলেই পরে যেতে নেয়। সুরঞ্জন জড়িয়ে ধরে রাখে। ধীরে ধীরে মেয়েটাকে নীচে নামিয়ে সে ট্যাক্সিতে তোলে। রাস্তার লোকেরা হয়তো ভেবে নেয় যে অসুস্থ স্ত্রীকে নিয়ে জাক্তারের কাছে যাচ্ছে যাচ্ছে ভদ্রলোক। ভদ্রলোকই বটে আজ সুরঞ্জন। পার্ক সার্কাসের গলিতে ঢুকে বাড়ির দরজার কাছে সিড়িতে জুলেখাকে রেখে সুরঞ্জন অন্ধকারে অদৃশ্য হয়ে যায়। ভেতর খেকে কেউ নিশ্চই খুলে দেবে। স্বামী বা কেউ। ট্যাক্সিতে জুলেখাকে উঠিয়ে দিলেই জুলেখা বাড়ি ফিরে যেতে পারতো, সুরঞ্জনেরও কোনো ঝুঁকি নেওয়া হতো না। কিন্তু ঝুঁকি যে আছে নিজে পৌঁছে দেওয়ায়, ভাবেনি। তাকে পুলিশ ধরতে পারতো, পাড়ার লোকেরাও ঘেরাও করতে পারতো, মুসলমান গুন্ডারা মেরে হাড়েগোড় ভেঙে দিতে পারতো।');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carts` (
  `cart_id` int(11) NOT NULL,
  `user_id_fk` int(11) DEFAULT NULL,
  `book_id_fk` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `user_id_fk_idx` (`user_id_fk`),
  KEY `book_id_fk_idx` (`book_id_fk`),
  CONSTRAINT `book_fk` FOREIGN KEY (`book_id_fk`) REFERENCES `books` (`books_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_items`
--

DROP TABLE IF EXISTS `ordered_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordered_items` (
  `ordered_item_id` int(11) NOT NULL,
  `order_id_fk` int(11) DEFAULT NULL,
  `book_id_fk` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`ordered_item_id`),
  KEY `order_fk_idx` (`order_id_fk`),
  CONSTRAINT `order_fk` FOREIGN KEY (`order_id_fk`) REFERENCES `orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_items`
--

LOCK TABLES `ordered_items` WRITE;
/*!40000 ALTER TABLE `ordered_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordered_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `user_id_fk` int(11) DEFAULT NULL,
  `item_cost` double DEFAULT NULL,
  `shipping_cost` double DEFAULT NULL,
  `payment_method` varchar(45) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `userfk_idx` (`user_id_fk`),
  CONSTRAINT `userfk` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publishers` (
  `publisher_id` int(11) NOT NULL AUTO_INCREMENT,
  `publisher_name` varchar(45) NOT NULL,
  `publisher_address` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES (1,'অংকুর কারুশিল্প',NULL),(2,'অন্বেষা প্রকাশন',NULL);
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'সমকালীন উপন্যাস');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'shafin.mahmud@gmail.com','1234',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-24 15:06:55
