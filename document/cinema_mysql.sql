CREATE DATABASE  IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cinema`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtp81kkpw4jxqdkw6q646buqgv` (`user_id`),
  CONSTRAINT `FKtp81kkpw4jxqdkw6q646buqgv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'2008-10-03 22:59:52',43),(2,'2008-10-03 22:59:52',44),(6,'2023-03-17 20:49:19',44),(7,'2023-03-17 20:52:05',44),(8,'2023-03-17 21:07:25',44),(9,'2023-03-17 21:08:08',44),(10,'2023-03-17 22:01:57',44),(11,'2023-03-18 08:01:52',44),(12,'2023-03-18 08:05:22',44),(13,'2023-03-18 10:25:37',44),(14,'2023-03-18 10:41:57',44),(15,'2023-03-18 23:17:21',44),(16,'2023-03-19 00:11:05',44),(17,'2023-03-19 00:13:36',44),(18,'2023-03-19 00:15:56',44),(19,'2023-03-19 00:17:12',44),(20,'2023-03-19 00:24:08',44),(21,'2023-03-19 00:26:27',44),(22,'2023-03-19 00:29:50',44),(23,'2023-03-19 00:33:00',44),(24,'2023-03-19 00:35:48',44),(25,'2023-03-19 00:41:46',44),(26,'2023-03-19 00:45:24',44),(27,'2023-03-19 00:46:37',44),(28,'2023-03-19 00:49:12',44),(29,'2023-03-19 00:51:25',44),(30,'2023-03-19 03:23:36',44),(31,'2023-03-19 03:48:55',44),(32,'2023-03-21 17:31:07',44),(33,'2023-03-21 17:37:35',44),(34,'2023-03-21 17:38:43',44),(35,'2023-03-21 17:40:15',44),(36,'2023-03-21 17:45:16',44),(37,'2023-03-21 18:02:26',44),(38,'2023-03-21 18:03:18',44),(39,'2023-03-21 18:03:41',44),(40,'2023-03-21 18:03:52',44),(41,'2023-03-21 18:05:17',44),(42,'2023-03-21 18:06:21',44),(43,'2023-03-21 18:10:00',44),(44,'2023-03-21 18:10:09',44),(45,'2023-03-21 18:11:21',44),(46,'2023-03-21 18:11:30',44),(47,'2023-03-22 08:22:38',44),(49,'2023-03-22 08:47:09',44),(50,'2023-03-22 08:51:54',44),(51,'2023-03-22 08:54:16',44),(52,'2023-03-22 08:55:58',44),(53,'2023-03-22 08:57:23',44),(54,'2023-03-22 08:59:38',44),(55,'2023-03-22 09:01:16',44),(58,'2023-03-22 18:18:26',44),(59,'2023-03-24 20:53:43',44),(61,'2023-04-23 16:34:54',44),(63,'2023-04-23 16:39:55',44),(65,'2023-05-13 12:07:19',44),(66,'2023-05-13 14:04:40',44),(67,'2023-05-13 14:13:25',44),(68,'2023-05-13 14:18:20',44),(69,'2023-05-13 14:20:39',44),(70,'2023-05-13 14:21:40',44),(71,'2023-05-13 14:25:24',44),(72,'2023-05-13 14:28:42',44),(73,'2023-05-13 14:29:45',44);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) DEFAULT NULL,
  `imgurl` varchar(2000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'danh','da','ho chi minh','032423');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `UKdwk6cx0afu8bs9o4t536v1j5v` (`email`),
  KEY `FKj8dlm21j202cadsbfkoem0s58` (`user_id`),
  CONSTRAINT `FKj8dlm21j202cadsbfkoem0s58` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'quynh thasn ','01234',NULL,'dong nai','tnq@gmal.com',44);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `actors` varchar(255) DEFAULT NULL,
  `categories` varchar(255) DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `is_showing` int NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `large_imageurl` varchar(1000) DEFAULT NULL,
  `long_description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rated` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `short_description` varchar(500) DEFAULT NULL,
  `small_imageurl` varchar(1000) DEFAULT NULL,
  `trailerurl` varchar(1000) DEFAULT NULL,
  `categorie_id` int DEFAULT NULL,
  `large_image_string` text,
  PRIMARY KEY (`id`),
  KEY `categorie_id_idx` (`categorie_id`),
  KEY `id_idx` (`categorie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Amy Sedaris, Jeff Goldblum, James Marsden','Hoạt Hình','Tom McGrath',105,1,'Tiếng Anh với phụ đề tiếng Việt và lồng tiếng Việt','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/r/s/rsz_dr-strange-980x448.jpg','Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted nhưng dường như hai anh em nhà Templeton nay đã không còn gần gũi như xưa. Nhưng bất ngờ thay khi Ted lại có màn tái xuất không thể hoành tráng hơn khi đáp thẳng máy bay trực thăng tới nhà Tim trước sự ngỡ ngàng của cả gia đình.','Nhóc Trùm: Nối Nghiệp Gia Đình','P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG','2021-12-24','Nhóc trùm Ted giờ đây đã trở thành một triệu phú nổi tiếng trong khi Tim lại có một cuộc sống đơn giản bên vợ anh Carol và hai cô con gái nhỏ yêu dấu. Mỗi mùa Giáng sinh tới, cả Tina và Tabitha đều mong được gặp chú Ted','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_boss_baby_2_24.12.2021_1_1_1__1.jpg','https://www.youtube.com/embed/Lv8nL2q8yRI',0,NULL),(2,'Tom Hardy, Michelle Williams, Woody Harrelson, Naomie Harris','Hành Động, Khoa Học Viễn Tưởng, Phiêu Lưu, Thần thoại','Andy Serkis',97,1,'Tiếng Anh - Phụ đề Tiếng Việt','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg','Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.','Venom: Đối Mặt Tử Thù','C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI','2021-12-10','Siêu bom tấn #VENOM: LET THERE BE CARNAGE hứa hẹn trận chiến khốc liệt nhất giữa Venom và kẻ thù truyền kiếp, Carnage.','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_venom_121121_1__1.jpg','https://www.youtube.com/embed/EVWdzVtSh1I',0,NULL),(3,'Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci','Hành Động, Khoa Học Viễn Tưởng','Lana Wachowski',148,1,'Tiếng Anh - Phụ đề Tiếng Việt, Phụ đề Tiếng Hàn','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg','Ma Trận: Hồi Sinh là phần phim tiếp theo rất được trông đợi của loạt phim “Ma Trận” đình đám, đã góp phần tái định nghĩa thể loại phim khoa học viễn tưởng. Phần phim mới nhất này đón chào sự trở lại của cặp đôi Keanu Reeves và Carrie-Anne Moss với vai diễn biểu tượng đã làm nên tên tuổi của họ, Neo và Trinity. Ngoài ra, phim còn có sự góp mặt của dàn diễn viên đầy tài năng gồm Yahya Abdul-Mateen II, Jessica Henwick, Jonathan Groff, Neil Patrick Harris, Priyanka Chopra Jonas và Christina Ricci.','Ma Trận: Hồi Sinh','C18 - PHIM CẤM KHÁN GIẢ DƯỚI 18 TUỔI','2021-12-24','Sau 20 năm, siêu phẩm ma trận đã trờ lại với người xem, Neo is back! Liệu đây có phải phần kết cho franchise này','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_matrix_4_1__1.jpg','https://www.youtube.com/embed/l2UTOJC5Tbk',0,NULL),(4,'Wasabi Mizuta, Megumi Oohara, Yumi Kakazu, Subaru Kimura, Tomokazu Seki','Hài, Hoạt Hình','Ryuichi Yagi, Takashi Yamazaki',96,1,'Tiếng Nhật - Phụ đề Tiếng Việt; Lồng tiếng','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/d/o/doreamon.jpg','Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon. Dù ngạc nhiên, bà vẫn tin cậu thiếu niên lớn tướng trước mặt mình là cháu mình. Trước nguyện vọng tha thiết “mong được thấy cháu dâu một lần”, chuyến phiêu lưu của Doraemon và Nobita bắt đầu. Nobita muốn cho bà xem đám cưới của mình, nhưng đúng ngày thành hôn với Shizuka, chú rể Nobita lại trốn mất? Jaian và Suneo chạy đôn chạy đáo tìm bạn, còn Shizuka vẫn tin tưởng chờ đợi Nobita. Để thực hiện nguyện vọng của bà, đáp lại niềm tin của gia đình, bạn bà và Shizuka yêu quý, Nobita sẽ cùng Doraemon du hành vượt thời gian. Họ sẽ mang đến cho chúng ta một câu chuyện cảm động đến rơi lệ về quan hệ con người, kết nối giữa quá khứ, hiện tại và tương lai.','Doraemon: Ôi Bạn Ơi 2','P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG','2021-12-17','Một ngày nọ, Nobita vô tình tìm thấy chú gấu bông cũ, món đồ chơi chất chứa bao kỉ niệm cùng người bà đáng kính. Với khát khao “muốn gặp bà lần nữa”, Nobita đã trở về quá khứ bằng cổ máy thời gian, bất chấp sự phản đối của Doraemon','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_doremon_2_1__1.jpg','https://www.youtube.com/embed/GXnOs4Hj8MA',0,NULL),(5,'Ansel Elgort, Rachel Zegler, Ariana DeBose, David Alvarez, Mike Faist, Josh Andrés Rivera, Ana Isabelle, Corey Stoll, Brian d’Arcy James, Rita Moreno','Nhạc kịch, Tình cảm','Steven Spielberg',156,1,'Tiếng Anh - Phụ đề Tiếng Việt','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/w/s/wss_sneak_980x448.jpg','Được đạo diễn bởi đạo diễn gạo cội từng giành giải Oscar Steven Spielberg, cùng kịch bản bởi biên kịch từng giành giải Pulitzer Prize và giải Tony Award, Tony Kushner, “Câu chuyện phía Tây” kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950.','Câu Chuyện Phía Tây','C16 - PHIM CẤM KHÁN GIẢ DƯỚI 16 TUỔI','2021-12-24','“Câu chuyện phía Tây” kể lại câu chuyện tình yêu kinh điển của Tony và Maria, giữa sự giằng xé của tình yêu trẻ tuổi và sự ngăn cấm, thù hằn ở thành phố NewYork những năm 1950','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_wss_1200x1800__1.jpg','https://www.youtube.com/embed/QPvqV71P0Fo',0,NULL),(6,'JISOO, JENNIE, ROSÉ, LISA','Phim tài liệu','Su Yee Jung, Oh Yoon-Dong',99,1,'Tiếng Hàn - Phụ đề tiếng Việt','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/b/l/blackpink-rolling_1_.jpg','Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE, đây cũng như là món quà đặc biệt dành tặng cho các BLINK— fandom của BLACKPINK — bộ phim sẽ tái hiện một cách sống động những kỷ niệm không thể quên cùng những màn trinh diễn đầy cuồng nhiệt đúng tinh thần lễ hội.','BlackPink The Movie','P - PHIM DÀNH CHO MỌI ĐỐI TƯỢNG','2021-12-24','Nhóm nhạc nữ được yêu thích toàn cầu, BLACKPINK sẽ kỷ niệm năm thứ 5 hoạt động của nhóm với việc phát hành BLACKPINK THE MOVIE','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/p/o/poster_blackpink_vie_2_1__1.jpg','https://www.youtube.com/embed/Q_rK9UlUN-Q',0,NULL),(7,'Tom Holland, Zendaya, Benedict Cumberbatch, Jacob Batalon, Jon Favreau','Hành Động, Phiêu Lưu','Jon Watts',149,1,'Tiếng Anh - Phụ đề Tiếng Việt','https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/r/s/rsz_dr-strange-980x448.jpg','Lần đầu tiên trong lịch sử điện ảnh của Người Nhện, thân phận người hàng xóm thân thiện bị lật mở, khiến trách nhiệm làm một Siêu Anh Hùng xung đột với cuộc sống bình thường và đặt người anh quan tâm nhất vào tình thế nguy hiểm. Khi anh nhờ đến giúp đỡ của Doctor Strange để khôi phục lại bí mật, phép thuật đã gây ra lỗ hổng thời không, giải phóng những ác nhân mạnh mẽ nhất từng đối đầu với Người Nhện từ mọi vũ trụ. Bây giờ, Peter sẽ phải vượt qua thử thách lớn nhất của mình, nó sẽ thay đổi không chỉ tương lai của chính anh mà còn là tương lai của cả Đa Vũ Trụ.','Người Nhện: Không Còn Nhà','C13 - PHIM CẤM KHÁN GIẢ DƯỚI 13 TUỔI','2021-12-17','Đa vũ trụ được mở ra, những kẻ phản diện nào sẽ trạm chán spidey, cùng đón xem nhá','https://www.cgv.vn/media/catalog/product/cache/1/small_image/240x388/dd828b13b1cb77667d034d5f59a82eb6/s/n/snwh_poster_bluemontage_4x5fb_1__1.jpg','https://www.youtube.com/embed/daHCu_jU5mQ',0,NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_CLIENT'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `imgurl` varchar(1000) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `total_area` double NOT NULL,
  `branch_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `FK3mf32q0hwpnmu7rf58gjtjrmj` (`branch_id`),
  CONSTRAINT `FK3mf32q0hwpnmu7rf58gjtjrmj` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,'asdfa','5',2,1),(2,50,'wwqe','2',432,1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `start_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `branch_id` int NOT NULL,
  `movie_id` int NOT NULL,
  `room_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ak7m8did07y741qbt2mm45c0` (`branch_id`),
  KEY `FKa6hosaihwhtb3scvamdyh9mlv` (`movie_id`),
  KEY `FKh2hdhbss2x31ns719hka6enma` (`room_id`),
  CONSTRAINT `FK4ak7m8did07y741qbt2mm45c0` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKa6hosaihwhtb3scvamdyh9mlv` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKh2hdhbss2x31ns719hka6enma` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,30000,'2023-03-07','10:00:00',1,1,1),(2,30000,'2023-03-07','10:00:00',1,1,2);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `room_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd7f42843rt05tt66t6vcb7s9u` (`room_id`),
  CONSTRAINT `FKd7f42843rt05tt66t6vcb7s9u` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1817 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A1',1),(2,'A2',1),(3,'A3',1),(4,'A4',1),(5,'A5',1),(6,'A6',1),(7,'A7',1),(8,'A8',1),(9,'B1',1),(10,'B2',1),(11,'B3',1),(12,'B4',1),(13,'B5',1),(14,'B6',1),(15,'B7',1),(16,'B8',1),(17,'C1',1),(18,'C2',1),(19,'C3',1),(20,'C4',1),(21,'C5',1),(22,'C6',1),(23,'C7',1),(24,'C8',1),(25,'D1',1),(26,'D2',1),(27,'D3',1),(28,'D4',1),(29,'D5',1),(30,'D6',1),(31,'D7',1),(32,'D8',1),(33,'E1',1),(34,'E2',1),(35,'E3',1),(36,'E4',1),(37,'E5',1),(38,'E6',1),(39,'E7',1),(40,'E8',1),(41,'A1',2),(42,'A2',2),(43,'A3',2),(44,'A4',2),(45,'A5',2),(46,'A6',2),(47,'A7',2),(48,'A8',2),(49,'B1',2),(50,'B2',2),(51,'B3',2),(52,'B4',2),(53,'B5',2),(54,'B6',2),(55,'B7',2),(56,'B8',2),(57,'C1',2),(58,'C2',2),(59,'C3',2),(60,'C4',2),(61,'C5',2),(62,'C6',2),(63,'C7',2),(64,'C8',2),(65,'D1',2),(66,'D2',2),(67,'D3',2),(68,'D4',2),(69,'D5',2),(70,'D6',2),(71,'D7',2),(72,'D8',2),(73,'E1',2),(74,'E2',2),(75,'E3',2),(76,'E4',2),(77,'E5',2),(78,'E6',2),(79,'E7',2),(80,'E8',2),(1769,'F1',2),(1770,'F2',2),(1771,'F3',2),(1772,'F4',2),(1773,'F5',2),(1774,'F6',2),(1775,'F7',2),(1776,'F8',2),(1777,'G1',2),(1778,'G2',2),(1779,'G3',2),(1780,'G4',2),(1781,'G5',2),(1782,'G6',2),(1783,'G7',2),(1784,'G8',2),(1785,'H1',2),(1786,'H2',2),(1787,'H3',2),(1788,'H4',2),(1789,'H5',2),(1790,'H6',2),(1791,'H7',2),(1792,'H8',2),(1793,'F1',1),(1794,'F2',1),(1795,'F3',1),(1796,'F4',1),(1797,'F5',1),(1798,'F6',1),(1799,'F7',1),(1800,'F8',1),(1801,'G1',1),(1802,'G2',1),(1803,'G3',1),(1804,'G4',1),(1805,'G5',1),(1806,'G6',1),(1807,'G7',1),(1808,'G8',1),(1809,'H1',1),(1810,'H2',1),(1811,'H3',1),(1812,'H4',1),(1813,'H5',1),(1814,'H6',1),(1815,'H7',1),(1816,'H8',1);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbhogfndgswrqk696i1s2stk2g` (`user_id`),
  CONSTRAINT `FKbhogfndgswrqk696i1s2stk2g` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qr_imageurl` varchar(255) DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `schedule_id` int NOT NULL,
  `seat_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `constraint_name` (`seat_id`,`schedule_id`),
  KEY `FKf9rrxu78kmw44u3xfarqpaa2r` (`bill_id`),
  KEY `FKdmmaqgvu0kjjlpsivmgnvurl5` (`schedule_id`),
  KEY `FKqahao9a85drt47ikjp0b8syvh` (`seat_id`),
  CONSTRAINT `FKdmmaqgvu0kjjlpsivmgnvurl5` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKf9rrxu78kmw44u3xfarqpaa2r` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKqahao9a85drt47ikjp0b8syvh` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'url',1,1,1),(2,'url-2',1,1,2),(3,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',2,1,3),(5,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',6,1,6),(6,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',7,1,7),(7,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',8,1,11),(8,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',9,1,12),(10,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',10,1,19),(11,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',10,1,20),(18,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',12,1,29),(19,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',12,1,30),(20,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',13,1,31),(21,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',13,1,23),(22,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',13,1,32),(23,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',13,1,24),(26,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',15,1,21),(27,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',16,1,28),(28,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',17,1,27),(30,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',19,1,26),(31,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',20,1,18),(32,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',21,1,4),(33,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',22,1,10),(34,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',23,1,14),(35,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',24,1,5),(36,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',25,1,9),(37,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',26,1,17),(38,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',27,1,25),(39,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',28,1,13),(40,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',29,2,43),(41,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',30,2,52),(42,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',31,2,59),(43,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',31,2,60),(47,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',36,1,36),(48,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',36,1,37),(49,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',37,1,22),(54,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',43,1,15),(56,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',45,1,35),(57,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',46,1,38),(58,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',46,1,39),(59,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',46,1,8),(60,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',46,1,40),(73,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',58,1,1798),(74,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',58,1,1797),(75,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',59,1,16),(77,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',61,1,33),(78,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',61,1,34),(81,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',63,1,1795),(82,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',63,1,1796),(84,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',65,1,1800),(85,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=meomeomeo',65,1,1799),(86,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=66-G3',66,1,1803),(87,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=67-G1',67,1,1801),(88,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=68-G2',68,1,1802),(89,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=69-G5',69,1,1805),(90,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=70-G8',70,1,1808),(91,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=71-G6',71,1,1806),(92,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=72-G7',72,1,1807),(93,'https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=73-G4',73,1,1804);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `profile_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_n67vkjwdu5sqqnyg6m79gmvo8` (`username`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKol5jyii7as0820ueqar5hc9f9` (`profile_id`),
  CONSTRAINT `FKol5jyii7as0820ueqar5hc9f9` FOREIGN KEY (`profile_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John Doe','$2a$10$2YyJAesejkOcujqN8MUQ.ealbZjSvNb4cu0b3hKf52cqwVHKiCOEq','joh3nd39dsdf',NULL),(43,'ttttt','$2a$10$vtdHVkkoABYpTNAALJiHQ.OLuGdC.f63iii1mlzwByvd25pTtMeY.','da',NULL),(44,'quynh','$2a$10$/OfK2XUi4SavnSCwEKnRXumaVDxrOaMFL3rmcrUX3Ixxj5.WOZ6Ja','qt',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  CONSTRAINT `FKgi4eki2k56pk6mrwfseslbpjl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-15 21:08:47
