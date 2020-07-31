/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.18 : Database - miaosha
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `cn_goods` */

CREATE TABLE `cn_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT '1' COMMENT '1 上架  0 下架',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `cn_goods` */

insert  into `cn_goods`(`id`,`name`,`number`,`create_time`,`update_time`,`status`,`start_time`,`end_time`) values (1,'柯南',100,'2020-07-30 13:22:51','2020-07-31 10:51:05',1,'2020-07-30 13:24:42','2020-07-30 13:24:53');
insert  into `cn_goods`(`id`,`name`,`number`,`create_time`,`update_time`,`status`,`start_time`,`end_time`) values (2,'灰原哀',0,'2020-07-30 13:23:01','2020-07-31 14:30:43',1,'2020-07-30 13:24:47','2020-07-30 13:24:56');
insert  into `cn_goods`(`id`,`name`,`number`,`create_time`,`update_time`,`status`,`start_time`,`end_time`) values (3,'刺痛',100,'2020-07-30 13:23:07','2020-07-30 15:39:57',1,'2020-07-30 13:24:49','2020-07-30 13:24:59');
insert  into `cn_goods`(`id`,`name`,`number`,`create_time`,`update_time`,`status`,`start_time`,`end_time`) values (4,'琴酒',100,'2020-07-30 13:23:11','2020-07-30 15:40:02',1,'2020-07-30 13:24:51','2020-07-30 13:25:02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
