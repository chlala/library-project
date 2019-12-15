/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.16-log : Database - dblib
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dblib` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dblib`;

/*Table structure for table `bachelor` */

DROP TABLE IF EXISTS `bachelor`;

CREATE TABLE `bachelor` (
  `no` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `borrow_num` int(11) DEFAULT '0',
  `owe_money` double unsigned DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bachelor` */

insert  into `bachelor`(`no`,`name`,`password`,`borrow_num`,`owe_money`,`email`) values ('111','夏了','$2a$10$XuSXHiOmG/iVZqLnpsuvHO/mfjcIXom5YXkVJiEwLj93QohuaZ1A2',0,0,NULL),('143','连看','$2a$10$hr3nzgC412x0R8TmOIaiouGBTlG8PVD01ZSmvpxGpZ0yQwb7INH36',0,0,'1032621325@qq.com'),('234','卡是','$2a$10$p/09TgDjPYqXBFxuW5uVT.Ub4f/eZrkJFAAp4pI.gq.UVU6Se3p7S',0,0,'1032621325@qq.com');

/*Table structure for table `book_admin` */

DROP TABLE IF EXISTS `book_admin`;

CREATE TABLE `book_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `location` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `book_admin` */

insert  into `book_admin`(`id`,`name`,`password`,`location`) values (8,'刘我','$2a$10$oJZ41/nX4x40AOXkPopdgu5dAegBaN/mivJaweD1Md/3Gp./QKZFq',1),(9,'蔡类','$2a$10$znFpzO1mRBwzDMqGgzWVoepLi/2b1wSxSyr3g6b0F/am6Dojfvi8u',1),(10,'黄怕','$2a$10$/cE7BeNIbSyD5.UeBW/OkuIgeOyVU141i6GuNCpqAvGdSIOmtUM02',3),(12,'严了','$2a$10$LiYeNVFWsMcmNIyJkz767Oks3ulQ057iZ9ROuNrAjUHa/Qk31ZMoa',2),(13,'分发','$2a$10$2He52F/Emh2XP1DaGRdt1u90seZPg9dvRf7Vc0TLv/1abA6Df21NG',1);

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `bi_id` int(255) NOT NULL,
  `type` int(11) NOT NULL,
  `ser_no` varchar(255) NOT NULL,
  `validate` int(2) NOT NULL,
  `borrow_date` date NOT NULL,
  `should_return_time` date NOT NULL,
  `return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

insert  into `borrow`(`bi_id`,`type`,`ser_no`,`validate`,`borrow_date`,`should_return_time`,`return_date`) values (74,1,'1',2,'2019-12-12','2020-01-21','2019-12-12'),(8,2,'1',1,'2019-12-12','2020-01-16',NULL),(126,1,'11',1,'2019-12-12','2020-01-01',NULL),(13,3,'11',1,'2019-12-12','2019-12-27',NULL),(91,1,'1',1,'2019-12-12','2020-01-21',NULL),(99,1,'1',1,'2019-12-12','2020-01-21',NULL),(104,1,'1',1,'2019-12-12','2020-01-21',NULL),(109,1,'1',1,'2019-12-12','2020-01-21',NULL),(120,1,'1',1,'2019-12-12','2020-01-21',NULL),(132,1,'1',1,'2019-12-12','2020-01-21',NULL),(140,1,'1',1,'2019-12-12','2020-01-21',NULL),(141,1,'1',1,'2019-12-12','2020-01-21',NULL),(133,1,'1',1,'2019-12-12','2020-01-21',NULL),(127,1,'1',1,'2019-12-12','2020-01-21',NULL),(76,1,'12',2,'2019-10-26','2019-12-11','2019-12-13'),(15,2,'12',1,'2019-12-13','2019-12-31',NULL),(15,3,'12',1,'2019-12-13','2019-12-28',NULL),(82,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(83,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(84,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(89,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(94,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(123,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(129,1,'12',2,'2019-09-03','2019-11-13','2019-12-13'),(136,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(129,1,'12',1,'2019-12-13','2020-01-02',NULL),(134,1,'12',2,'2019-09-19','2019-12-10','2019-12-13'),(123,1,'12',2,'2019-09-10','2019-12-11','2019-12-13'),(123,1,'12',2,'2019-10-23','2019-12-11','2019-12-13'),(123,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(143,1,'12',1,'2019-12-13','2020-01-02',NULL),(142,1,'12',1,'2019-12-13','2020-01-02',NULL),(122,1,'12',1,'2019-12-13','2020-01-02',NULL),(123,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(110,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(111,1,'12',1,'2019-12-13','2020-01-02',NULL),(101,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(101,1,'12',1,'2019-12-13','2020-01-02',NULL),(77,1,'12',2,'2019-12-13','2020-01-02','2019-12-13'),(83,1,'1',1,'2019-12-15','2020-01-24',NULL);

/*Table structure for table `borrow_strategy` */

DROP TABLE IF EXISTS `borrow_strategy`;

CREATE TABLE `borrow_strategy` (
  `user_type` int(11) NOT NULL,
  `book_type` int(11) NOT NULL,
  `max_borrow_num` int(11) NOT NULL,
  `max_borrow_day` varchar(255) NOT NULL,
  PRIMARY KEY (`user_type`,`book_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow_strategy` */

insert  into `borrow_strategy`(`user_type`,`book_type`,`max_borrow_num`,`max_borrow_day`) values (1,1,20,'40'),(1,2,20,'35'),(1,3,20,'30'),(2,1,10,'20'),(2,2,10,'18'),(2,3,10,'15'),(3,1,12,'25'),(3,2,12,'20'),(3,3,12,'15'),(4,1,15,'30'),(4,2,15,'25'),(4,3,15,'20'),(5,1,18,'35'),(5,2,18,'30'),(5,3,18,'25');

/*Table structure for table `doctor` */

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `no` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `borrow_num` int(11) DEFAULT '0',
  `owe_money` double unsigned DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `doctor` */

insert  into `doctor`(`no`,`name`,`password`,`borrow_num`,`owe_money`,`email`) values ('12345','陈类','$2a$10$JNsV9KXoZGUxXqAk7BJ2VuCs4aROahJnWg2uTfDT9THk7OnjCfiUS',0,0,'1032621325@qq.com'),('12347','分发','$2a$10$o8DHqtZzh5P9KOZ4Q2qI1ej.fu3lZq47mV0WMz2liTXCwjpkTjRTi',0,0,NULL),('12348','分发','$2a$10$agoq5uexk8Hvfd86xqI/B.zzGFsXHYlbA2UABWjpGu.h3LbHwXvsK',0,0,NULL);

/*Table structure for table `fine_strategy` */

DROP TABLE IF EXISTS `fine_strategy`;

CREATE TABLE `fine_strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `fine_strategy` */

insert  into `fine_strategy`(`id`,`money`) values (1,0.1),(2,0.2),(3,0.3);

/*Table structure for table `junior` */

DROP TABLE IF EXISTS `junior`;

CREATE TABLE `junior` (
  `no` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `borrow_num` int(11) DEFAULT '0',
  `owe_money` double unsigned DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `junior` */

insert  into `junior`(`no`,`name`,`password`,`borrow_num`,`owe_money`,`email`) values ('11','分发','$2a$10$XaCB2IQhIy5CPl3KXw43p.iDeo4Fp9wHT4nxNUezXbME5pZBBY4K2',2,0,NULL),('12','刘了','$2a$10$Xawb5YOgNDpsus1cRu6gnu8d68oMfk9Hq/f0wLs9jciMetHl5ajqy',8,0,'1032621325@qq.com'),('13','分发','$2a$10$wZ0iQ.T9ZctsIkaSPed2NOrFeKnTn/BbrpTrQzv1AfE3Se0cIxV.C',0,0,NULL);

/*Table structure for table `magazine` */

DROP TABLE IF EXISTS `magazine`;

CREATE TABLE `magazine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `issn` varchar(255) NOT NULL,
  `period_num` int(11) NOT NULL,
  `date` date NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  `in_count` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `magazine` */

insert  into `magazine`(`id`,`book_name`,`author`,`issn`,`period_num`,`date`,`count`,`in_count`) values (6,'旅游实录','立方','hfu-w23',7,'2019-11-22',5,'4'),(7,'杂志1','dbf','ed-13',5,'2019-12-03',6,'5'),(8,'杂志2','立方','we233-hh',5,'2019-12-05',5,'5');

/*Table structure for table `magazine_item` */

DROP TABLE IF EXISTS `magazine_item`;

CREATE TABLE `magazine_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `should_return_time` date DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '1',
  `location` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `magazine_item` */

insert  into `magazine_item`(`id`,`book_id`,`should_return_time`,`state`,`location`) values (8,6,'2020-01-16',2,1),(9,6,NULL,1,1),(10,6,NULL,1,2),(11,6,NULL,1,2),(12,6,NULL,1,3),(13,7,NULL,1,1),(14,7,NULL,1,1),(15,7,'2019-12-31',2,2),(16,7,NULL,1,2),(17,7,NULL,1,3),(18,7,NULL,1,3),(19,8,NULL,1,1),(20,8,NULL,1,2),(21,8,NULL,1,2),(22,8,NULL,1,3),(23,8,NULL,1,3);

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `no` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `borrow_num` int(11) DEFAULT '0',
  `owe_money` double unsigned DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `master` */

insert  into `master`(`no`,`name`,`password`,`borrow_num`,`owe_money`,`email`) values ('1111','王看','$2a$10$7K1IPIiNaQ2M5.9akC7JS..Uk6Eit1/13YTcZigEfzBFSSfNkZ1oa',0,0,NULL),('1234','江去','$2a$10$tbHI95chbLzjM.u95z2zsO/QCOltMUjwQnYmI7cbcnpHhNUGHNJY6',0,0,NULL);

/*Table structure for table `order_item` */

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(255) NOT NULL,
  `bi_id` int(11) NOT NULL,
  `book_type` int(11) NOT NULL,
  `validate` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `order_item` */

insert  into `order_item`(`id`,`no`,`bi_id`,`book_type`,`validate`) values (1,'1',140,1,1),(2,'1',109,1,1),(4,'1',126,1,1),(5,'12',116,1,1),(6,'12',110,1,1),(7,'12',111,1,1),(8,'12',123,1,2),(9,'1',91,1,1),(10,'1',111,1,1);

/*Table structure for table `ordinary_book` */

DROP TABLE IF EXISTS `ordinary_book`;

CREATE TABLE `ordinary_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `call_number` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `press` varchar(255) NOT NULL,
  `publish_time` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  `in_count` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `ordinary_book` */

insert  into `ordinary_book`(`id`,`book_name`,`call_number`,`author`,`press`,`publish_time`,`description`,`price`,`count`,`in_count`) values (29,'从Java走向Java EE','TP312JA/797','吴超','人民邮电出版社','2019-06-12','Java EE是目前企业级系统开发的最佳选择之一，其技术本身在不断发 展，涌现出各种概念，其繁多的内容让很多初学者望而','42',6,'6'),(30,'细说Java','TP312JA/1115','梁勇','人民邮电出版社','2019-06-12','本书详细讲解了Java开发的近百个细节，主要内容包括path与 classpath、main、基本数据类型、注释、运算','39',7,'6'),(31,'Core Java','TP312JA/111','Cay S. Horstmann','人民邮电出版社','2016-06-12','本书是经典的《Java核心技术 卷I：基础知识》的新版。这一版针对Java SE 8平台进行了全面更新，以反映Java','109',4,'4'),(32,'疯狂Java讲义','TP312JA/112','李刚','电子工业出版社','2014-06-12','本书深入介绍了Java编程的相关方面，全书内容覆盖了Java的基本语法结构、Java的面向对象特征、Java集合框架体系','109',8,'7'),(33,'Java经典实例','TP312JA/1988','Ian F. Darwin','中国电力出版社','2014-07-12','本书的主题包括：· 用于编译、运行和调试的方法。· 对文本的处理、比较和重新安排。· 用于字符串匹配和模式匹配的正则表达','148',5,'3'),(34,'Java Servlet编程','TP312JA/438','Jason Hunte','中国电力出版社','2012-07-12','在过去的几年里，Java servlet已经在服务器端开发领域引起了轰动','54',5,'4'),(35,'Java程序设计','TP312JA/2117','苏莹','机械工业出版社   ','2015-09-12','全书将面向对象Java中的重要概念: 类、对象、方法、继承、多态、接口、匿名类、内部类、文件处理、异常结合同一个应用系统的案例进行系列知识点的逐步分解和层层剖析。在循序渐进的章节安排上, 确保章节中的各个子案例源于一致, 又能独立运行。','46',5,'3'),(36,'Java虚拟机规范','TP312JA/1619','Tim Lindholm','机械工业出版社   ','2015-09-12','《Java虚拟机规范(Java SE 7版)》是Java领域最重要和最权威的著作之一，由Oracle官方发布','69',6,'5'),(37,'Java面向对象编程','TP312JA/481','孙卫琴','电子工业出版社   ','2015-09-25','本书内容由浅入深，紧密结合实际，利用大量典型实例，详细讲解Java面向对象的编程思想、编程语法和设计模式','66',6,'4'),(38,'Java设计：对象、UML和过程','TP312JA/136','Kirk Knoernschild','人民邮电出版社   ','2015-10-09','本书重点介绍如何把Java、UML、OO和软件过程等技术有机地结合起来，并成功地运用到软件开发中','25',6,'3'),(39,'Java编程指南','TP312JA/1797','布迪·克尼亚万',' 机械工业出版社','2016-10-28','	这本书涵盖了Java开发者需要掌握的最重要的主题：面向对象编程、Java语言语法以及Java库。','99',8,'6'),(40,'Thinking in Java','TP312JA/E19','Eckel, Bruce','Publishing House of Electronic Industry','2013-10-28','《Java编程思想(评注版第4版)》(作者埃克尔)作者拥有多年教学经验 ，对C、C++以及Java语言都有独到、深入的','98',6,'2');

/*Table structure for table `ordinary_book_item` */

DROP TABLE IF EXISTS `ordinary_book_item`;

CREATE TABLE `ordinary_book_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `should_return_time` date DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '1',
  `location` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

/*Data for the table `ordinary_book_item` */

insert  into `ordinary_book_item`(`id`,`book_id`,`should_return_time`,`state`,`location`) values (74,29,NULL,1,1),(75,29,NULL,1,1),(76,29,NULL,1,2),(77,29,NULL,1,2),(78,29,NULL,1,3),(79,29,NULL,1,3),(80,30,NULL,1,1),(81,30,NULL,1,1),(82,30,NULL,1,2),(83,30,'2020-01-24',2,2),(84,30,NULL,1,2),(85,30,NULL,1,3),(86,30,NULL,1,3),(87,31,NULL,1,1),(88,31,NULL,1,1),(89,31,NULL,1,2),(90,31,NULL,1,3),(91,32,'2020-01-21',2,1),(92,32,NULL,1,1),(93,32,NULL,1,1),(94,32,NULL,1,2),(95,32,NULL,1,2),(96,32,NULL,1,2),(97,32,NULL,1,3),(98,32,NULL,1,3),(99,33,'2020-01-21',2,1),(100,33,NULL,1,1),(101,33,'2020-01-02',2,2),(102,33,NULL,1,3),(103,33,NULL,1,3),(104,34,'2020-01-21',2,1),(105,34,NULL,1,1),(106,34,NULL,1,2),(107,34,NULL,1,2),(108,34,NULL,1,3),(109,35,'2020-01-21',2,1),(110,35,NULL,1,2),(111,35,'2020-01-02',2,2),(112,35,NULL,1,2),(113,35,NULL,1,3),(114,36,NULL,1,1),(115,36,NULL,1,1),(116,36,'2020-01-02',2,2),(117,36,NULL,1,3),(118,36,NULL,1,3),(119,36,NULL,1,3),(120,37,'2020-01-21',2,1),(121,37,NULL,1,1),(122,37,'2020-01-02',2,2),(123,37,NULL,1,2),(124,37,NULL,1,3),(125,37,NULL,1,3),(126,38,'2020-01-01',2,1),(127,38,'2020-01-21',2,1),(128,38,NULL,1,2),(129,38,'2020-01-02',2,2),(130,38,NULL,1,3),(131,38,NULL,1,3),(132,39,'2020-01-21',2,1),(133,39,'2020-01-21',2,1),(134,39,NULL,1,2),(135,39,NULL,1,2),(136,39,NULL,1,2),(137,39,NULL,1,3),(138,39,NULL,1,3),(139,39,NULL,1,3),(140,40,'2020-01-21',2,1),(141,40,'2020-01-21',2,1),(142,40,'2020-01-02',2,2),(143,40,'2020-01-02',2,2),(144,40,NULL,1,3),(145,40,NULL,1,3);

/*Table structure for table `paper` */

DROP TABLE IF EXISTS `paper`;

CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `kind_num` varchar(255) NOT NULL,
  `count` int(11) NOT NULL DEFAULT '0',
  `in_count` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `paper` */

insert  into `paper`(`id`,`book_name`,`author`,`date`,`kind_num`,`count`,`in_count`) values (3,'基于快快快的研究','何看','2019-10-18','32j-sw',6,'4');

/*Table structure for table `paper_item` */

DROP TABLE IF EXISTS `paper_item`;

CREATE TABLE `paper_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `should_return_time` date DEFAULT NULL,
  `state` int(2) NOT NULL DEFAULT '1',
  `location` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `paper_item` */

insert  into `paper_item`(`id`,`book_id`,`should_return_time`,`state`,`location`) values (13,3,'2019-12-27',2,1),(14,3,NULL,1,1),(15,3,'2019-12-28',2,2),(16,3,NULL,1,2),(17,3,NULL,1,3),(18,3,NULL,1,3);

/*Table structure for table `system_admin` */

DROP TABLE IF EXISTS `system_admin`;

CREATE TABLE `system_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `system_admin` */

insert  into `system_admin`(`id`,`name`,`password`) values (1,'叶非','$2a$10$MbLHMXg0BAwgz1o6UXoI7uheupWrM/xtjzGdz4qoXTHnc.2ZuZsoS'),(2,'秦即','$2a$10$NCwuM.jSK6ASzmUOQrwX5eIKFrekz7FLxVZFVjzBPNJPvaW5bKXXG');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `no` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `borrow_num` int(11) NOT NULL DEFAULT '0',
  `owe_money` double unsigned NOT NULL DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`no`,`name`,`password`,`borrow_num`,`owe_money`,`email`) values ('1','李四','$2a$10$EsDcyI8f72T5TQ4ZkoM1KOzR5HxOgz85Qo5XXSgMU4Nf3TLdLYtX2',12,0,'1032621325@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
