-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 evaluation 的数据库结构
CREATE DATABASE IF NOT EXISTS `evaluation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `evaluation`;

-- 导出  表 evaluation.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  CONSTRAINT `FK_admin_user` FOREIGN KEY (`admin_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.admin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 evaluation.class 结构
CREATE TABLE IF NOT EXISTS `class` (
  `class_id` int(11) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `number` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `grade` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK_Relationship_1` (`department_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.class 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
REPLACE INTO `class` (`class_id`, `department_id`, `number`, `name`, `grade`) VALUES
	(1, 1, '1', '计算机科学与技术', '2017'),
	(2, 1, '2', '计算机科学与技术', '2017'),
	(3, 1, '3', '计算机网络', '2017'),
	(4, 1, '4', '软件工程', '2017'),
	(5, 1, '5', '教育技术', '2017'),
	(6, 1, '6', '教育技术', '2017'),
	(7, 1, '7', 'rjgc', '2017');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;

-- 导出  表 evaluation.class_course 结构
CREATE TABLE IF NOT EXISTS `class_course` (
  `course_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`class_id`),
  KEY `FK_Relationship_8` (`class_id`),
  KEY `FK_class_course_teacher` (`teacher_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FK_class_course_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.class_course 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `class_course` DISABLE KEYS */;
REPLACE INTO `class_course` (`course_id`, `class_id`, `teacher_id`) VALUES
	(1, 2, 2),
	(2, 4, 2),
	(4, 2, 2),
	(4, 6, 2),
	(1, 1, 5),
	(1, 3, 5),
	(1, 4, 5),
	(2, 2, 5),
	(2, 5, 6),
	(3, 4, 6),
	(4, 4, 6),
	(2, 1, 7),
	(4, 1, 7);
/*!40000 ALTER TABLE `class_course` ENABLE KEYS */;

-- 导出  表 evaluation.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(11) NOT NULL,
  `number` varchar(128) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `course_type` varchar(128) DEFAULT NULL,
  `course_class` varchar(128) DEFAULT NULL,
  `course_dep` varchar(128) DEFAULT NULL,
  `score` decimal(10,0) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FK_course_department` (`department_id`),
  CONSTRAINT `FK_course_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.course 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
REPLACE INTO `course` (`course_id`, `number`, `name`, `course_type`, `course_class`, `course_dep`, `score`, `time`, `department_id`) VALUES
	(1, '11A001', '计算机导论', '学科专业课程-专业核心课程', '必修课', '计算机科学学院', 2, 32, 2),
	(2, '11A003', '数字电路', '学科专业课程-专业核心课程', '必修课', '计算机科学学院', 5, 80, 1),
	(3, '11A023', 'IOS高级开发技术', '学科专业课程-特色创新课程', '必修课', '计算机科学学院', 4, 64, 1),
	(4, '11A022', '算法设计与分析', '专业方向课程-软件开发及应用方向', '必修课', '计算机科学学院', 4, 64, 1),
	(5, '11A015', '网页制作', '专业方向课程-软件开发及应用方向', '选修课', '计算机科学学院', 2, 32, 1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- 导出  表 evaluation.department 结构
CREATE TABLE IF NOT EXISTS `department` (
  `department_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.department 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
REPLACE INTO `department` (`department_id`, `name`) VALUES
	(1, '计算机科学学院'),
	(2, '美术学院');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- 导出  表 evaluation.evaluation_item 结构
CREATE TABLE IF NOT EXISTS `evaluation_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `role_id` int(11) NOT NULL DEFAULT '0',
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  evaluation.evaluation_item 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `evaluation_item` DISABLE KEYS */;
REPLACE INTO `evaluation_item` (`id`, `content`, `role_id`, `weight`) VALUES
	(1, '讲课思路和概念清楚，容易听懂', 3, 6000),
	(2, '教师上课认真，课堂纪律良好', 3, 5000),
	(3, '使用现代化的教学手段', 3, 4000),
	(4, '批改作业认真，辅导答疑热情', 3, 3000),
	(5, '上课不迟到，不提前下课，不随便停课', 3, 2000),
	(6, '教材和辅导材料适用', 3, 1000),
	(7, '教师上课认真，课堂纪律好', 4, 1000),
	(8, '学生积极回答问题', 4, 2000),
	(9, '上课不迟到，不提前下课，不随便停课', 4, 3000),
	(14, '教师备课充分,上课思路清晰', 4, 4000),
	(15, '上课不迟到，不提前下课，不随便停课', 2, 4000),
	(16, '有扎实的专业知识', 2, 3000);
/*!40000 ALTER TABLE `evaluation_item` ENABLE KEYS */;

-- 导出  表 evaluation.individual_evaluation 结构
CREATE TABLE IF NOT EXISTS `individual_evaluation` (
  `individual_id` int(11) NOT NULL AUTO_INCREMENT,
  `summary_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `from_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `score_1` int(11) DEFAULT NULL,
  `score_2` int(11) DEFAULT NULL,
  `score_3` int(11) DEFAULT NULL,
  `score_4` int(11) DEFAULT NULL,
  `score_5` int(11) DEFAULT NULL,
  `score_6` int(11) DEFAULT NULL,
  `total_score` decimal(10,0) DEFAULT NULL,
  `advice` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`individual_id`),
  KEY `FK_Relationship_12` (`summary_id`),
  KEY `FK_Relationship_13` (`teacher_id`),
  KEY `FK_individual_evaluation_user` (`from_id`),
  KEY `FK_individual_evaluation_role` (`role_id`),
  KEY `FK_individual_evaluation_course` (`course_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`summary_id`) REFERENCES `summary_evaluation` (`summary_id`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `FK_individual_evaluation_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FK_individual_evaluation_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FK_individual_evaluation_user` FOREIGN KEY (`from_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.individual_evaluation 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `individual_evaluation` DISABLE KEYS */;
REPLACE INTO `individual_evaluation` (`individual_id`, `summary_id`, `role_id`, `from_id`, `teacher_id`, `course_id`, `score_1`, `score_2`, `score_3`, `score_4`, `score_5`, `score_6`, `total_score`, `advice`) VALUES
	(1, NULL, 4, 12, 6, 1, 5, 4, 3, 2, 5, 5, 4, '老师教的很好'),
	(2, NULL, 2, 5, 7, 2, 5, 4, 3, 2, 5, 5, 4, NULL),
	(3, NULL, 3, 4, 5, 5, 5, 4, 3, 2, 5, 5, 4, NULL),
	(4, NULL, 3, 9, 2, 4, 5, 5, 5, 5, 5, 5, 5, '很好很好'),
	(5, NULL, 3, 9, 5, 1, 5, 5, 5, 5, 5, 5, 5, '老师上课速度有点快，我有点更不上'),
	(6, NULL, 3, 3, 5, 1, 4, 4, 4, 4, 4, 4, 4, '老师上课速度有点快，我有点更不上'),
	(8, NULL, 2, 7, 2, 3, 4, 4, 4, 4, 4, 4, 4, '认真负责，教学计划制定得认真详细'),
	(9, NULL, 4, 12, 2, 1, 5, 5, 5, 5, 5, 5, 5, '刘老师好'),
	(13, NULL, 4, 12, 5, 2, 4, 4, 4, 4, 4, 4, 4, '我没有评价'),
	(14, NULL, 3, 10, 5, 2, 4, 4, 4, 4, 4, 4, 4, NULL),
	(15, NULL, 2, 7, 5, 5, 2, 2, 2, 2, 2, 2, 2, NULL);
/*!40000 ALTER TABLE `individual_evaluation` ENABLE KEYS */;

-- 导出  表 evaluation.permission 结构
CREATE TABLE IF NOT EXISTS `permission` (
  `permission_id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  `perms` varchar(128) DEFAULT NULL,
  `parrent_id` int(11) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.permission 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
REPLACE INTO `permission` (`permission_id`, `name`, `url`, `perms`, `parrent_id`, `type`) VALUES
	(1, '查看权限', '/user/view', 'user:view', NULL, ''),
	(2, '修改权限', '/user/update', 'user:update', NULL, ''),
	(3, '添加权限', '/user/add', 'user:add', NULL, '');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- 导出  表 evaluation.role 结构
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.role 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`role_id`, `name`) VALUES
	(1, '管理员'),
	(2, '教师'),
	(3, '学生'),
	(4, '督导');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- 导出  表 evaluation.role_permission 结构
CREATE TABLE IF NOT EXISTS `role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK_Relationship_3` (`permission_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.role_permission 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
REPLACE INTO `role_permission` (`role_id`, `permission_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(1, 2),
	(2, 2),
	(1, 3);
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;

-- 导出  表 evaluation.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `region` varchar(128) DEFAULT NULL,
  `score` decimal(10,0) DEFAULT NULL,
  `entrance_date` date DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK_Relationship_5` (`class_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `FK_student_user` FOREIGN KEY (`student_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.student 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
REPLACE INTO `student` (`student_id`, `class_id`, `name`, `gender`, `birth`, `region`, `score`, `entrance_date`) VALUES
	(3, 4, '白鹤', 0, '2020-05-05', '四川眉山', 400, '2020-05-05'),
	(4, 2, '黑迪克', 0, '2019-05-05', '四川遂宁', 210, '2020-05-05'),
	(8, 1, '王小朵', 1, '2020-05-05', '四川成都', 1000, '2020-05-05'),
	(9, 2, '王华康', 1, '2020-05-05', '四川德阳', 170, '2020-05-05'),
	(10, 6, '张卡丽', 0, '2020-05-05', '四川雅安', 250, '2020-05-05');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 evaluation.summary_evaluation 结构
CREATE TABLE IF NOT EXISTS `summary_evaluation` (
  `summary_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `semester` varchar(32) DEFAULT NULL,
  `summary_score` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`summary_id`),
  KEY `FK_Reference_14` (`class_id`),
  KEY `FK_Reference_16` (`course_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.summary_evaluation 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `summary_evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary_evaluation` ENABLE KEYS */;

-- 导出  表 evaluation.supervisor 结构
CREATE TABLE IF NOT EXISTS `supervisor` (
  `supervisor_id` int(11) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`supervisor_id`),
  CONSTRAINT `FK_supervisor_user` FOREIGN KEY (`supervisor_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.supervisor 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
REPLACE INTO `supervisor` (`supervisor_id`, `gender`, `name`) VALUES
	(11, 0, '王东东'),
	(12, 0, '刘丽萍'),
	(13, 1, '李汉杰');
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;

-- 导出  表 evaluation.supervisor_course 结构
CREATE TABLE IF NOT EXISTS `supervisor_course` (
  `supervisor_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`supervisor_id`,`course_id`,`teacher_id`),
  KEY `FK_supervisor_course_course` (`course_id`),
  KEY `FK_supervisor_course_teacher` (`teacher_id`),
  CONSTRAINT `FK_supervisor_course_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `FK_supervisor_course_supervisor` FOREIGN KEY (`supervisor_id`) REFERENCES `supervisor` (`supervisor_id`),
  CONSTRAINT `FK_supervisor_course_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='督导可评价老师的关系表';

-- 正在导出表  evaluation.supervisor_course 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `supervisor_course` DISABLE KEYS */;
REPLACE INTO `supervisor_course` (`supervisor_id`, `course_id`, `teacher_id`) VALUES
	(11, 1, 5),
	(12, 1, 2),
	(12, 2, 6),
	(12, 2, 7),
	(13, 5, 2);
/*!40000 ALTER TABLE `supervisor_course` ENABLE KEYS */;

-- 导出  表 evaluation.teacher 结构
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` int(11) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `region` varchar(128) DEFAULT NULL,
  `total_class` bigint(20) DEFAULT NULL,
  `entrance_date` date DEFAULT NULL,
  `job_title` varchar(128) DEFAULT NULL,
  `grant_date` date DEFAULT NULL,
  `political_status` varchar(32) DEFAULT NULL,
  `degree` varchar(32) DEFAULT NULL,
  `graduate_school` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `FK_Relationship_6` (`department_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `FK_teacher_user` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.teacher 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
REPLACE INTO `teacher` (`teacher_id`, `department_id`, `name`, `gender`, `birth`, `region`, `total_class`, `entrance_date`, `job_title`, `grant_date`, `political_status`, `degree`, `graduate_school`) VALUES
	(2, 1, '张大哥', 0, '2020-05-05', '四川成都', 10000, '2020-05-05', '教授', '2020-05-05', '党员', '博士', '电子科技大学'),
	(5, 1, '刘凯', 1, '2020-05-05', '四川绵阳', 4000, '2020-05-05', '助教', '2020-05-05', '党员', '学士', '四川师范大学'),
	(6, 1, '白鹤楼', 0, '2020-05-05', '四川德阳', 2000, '2020-05-05', '副教授', '2020-05-05', '党员', '硕士', '四川师范大学'),
	(7, 2, '黑弹', 1, '2020-05-05', '福建福州', 6000, '2020-05-05', '讲师', '2020-05-05', '团员', '学士', '四川大学');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- 导出  表 evaluation.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `id_number` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_15` (`role_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  evaluation.user 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
REPLACE INTO `user` (`user_id`, `role_id`, `name`, `password`, `id_number`) VALUES
	(1, 1, 'admin', '202cb962ac59075b964b07152d234b70', 'fcea920f7412b5da7be0cf42b8c93759'),
	(2, 2, '张老师', '202cb962ac59075b964b07152d234b70', 'd1999a2caf49c63987d19e2ee981ead8'),
	(3, 3, '小白', '202cb962ac59075b964b07152d234b70', '5059437b8a54d05c09884405ebaf7fb1'),
	(4, 3, '小黑', 'fcea920f7412b5da7be0cf42b8c93759', 'fcea920f7412b5da7be0cf42b8c93759'),
	(5, 2, '刘老师', '827ccb0eea8a706c4c34a16891f84e7b', '827ccb0eea8a706c4c34a16891f84e7b'),
	(6, 2, '王老师', 'f9ddd5154de830bc8367fd5881de574d', 'fcea920f7412b5da7be0cf42b8c93759'),
	(7, 2, '罗老师', '0883adf9b30528a9a0f668f44b593aed', 'e10adc3949ba59abbe56e057f20f883e'),
	(8, 3, '小多', 'f9ddd5154de830bc8367fd5881de574d', '7fa8282ad93047a4d6fe6111c93b308a'),
	(9, 3, '小王', '0883adf9b30528a9a0f668f44b593aed', 'e3ceb5881a0a1fdaad01296d7554868d'),
	(10, 3, '小张', '0883adf9b30528a9a0f668f44b593aed', '7fa8282ad93047a4d6fe6111c93b308a'),
	(11, 4, '王督导', '202cb962ac59075b964b07152d234b70', 'fcea920f7412b5da7be0cf42b8c93759'),
	(12, 4, '刘督导', '202cb962ac59075b964b07152d234b70', '5059437b8a54d05c09884405ebaf7fb1'),
	(13, 4, '李督导', '202cb962ac59075b964b07152d234b70', '5059437b8a54d05c09884405ebaf7fb1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
