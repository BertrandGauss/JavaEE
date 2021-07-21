/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 80023
Source Host           : localhost:3306
Source Database       : health_management

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2021-07-21 15:16:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `administrator_id` int NOT NULL AUTO_INCREMENT,
  `administrator_name` varchar(1024) NOT NULL,
  `password` varchar(1024) NOT NULL,
  PRIMARY KEY (`administrator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'admin', '000000');

-- ----------------------------
-- Table structure for alarmclock
-- ----------------------------
DROP TABLE IF EXISTS `alarmclock`;
CREATE TABLE `alarmclock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(1024) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `type` varchar(1024) DEFAULT NULL COMMENT '0-每日提醒\r\n            1-仅一次提醒\r\n            ',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Relationship_9` (`user_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='alarmclock';

-- ----------------------------
-- Records of alarmclock
-- ----------------------------
INSERT INTO `alarmclock` VALUES ('1', '1', '起床', '15:31:00', '仅此一次', '2021-07-20');
INSERT INTO `alarmclock` VALUES ('2', '1', '入睡', '16:16:00', '仅此一次', '2021-07-20');
INSERT INTO `alarmclock` VALUES ('3', '1', 'kaihui', '16:21:20', '仅此一次', '2021-07-20');

-- ----------------------------
-- Table structure for exerciseinf
-- ----------------------------
DROP TABLE IF EXISTS `exerciseinf`;
CREATE TABLE `exerciseinf` (
  `exercise_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(1024) NOT NULL,
  `caloriePerHour` int NOT NULL,
  PRIMARY KEY (`exercise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='exerciseInf';

-- ----------------------------
-- Records of exerciseinf
-- ----------------------------
INSERT INTO `exerciseinf` VALUES ('1', '跑步', '700');
INSERT INTO `exerciseinf` VALUES ('2', '跳绳', '800');
INSERT INTO `exerciseinf` VALUES ('3', '单车', '245');
INSERT INTO `exerciseinf` VALUES ('4', '快走', '555');
INSERT INTO `exerciseinf` VALUES ('5', '慢走', '255');
INSERT INTO `exerciseinf` VALUES ('6', '游泳', '1000');
INSERT INTO `exerciseinf` VALUES ('7', '健美操', '500');

-- ----------------------------
-- Table structure for foodinf
-- ----------------------------
DROP TABLE IF EXISTS `foodinf`;
CREATE TABLE `foodinf` (
  `food_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `weightPerOne` double NOT NULL,
  `caloriePer100g` int NOT NULL,
  `vAPer100g` double DEFAULT NULL,
  `vBper100g` double DEFAULT NULL,
  `vCper100g` double DEFAULT NULL,
  `vDper100g` double DEFAULT NULL,
  `vEper100g` double DEFAULT NULL,
  `proteinPer100g` double DEFAULT NULL,
  `fatPer100g` double DEFAULT NULL,
  `carbsPer100g` double DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='foodInf';

-- ----------------------------
-- Records of foodinf
-- ----------------------------
INSERT INTO `foodinf` VALUES ('1', '苹果', '140', '53', '0.004', '0.04', '3', '0', '0.43', '0.4', '0.2', '13.7');
INSERT INTO `foodinf` VALUES ('2', '香蕉', '150', '93', '0.005', '0.06', '8', '0', '0.24', '1.4', '0.2', '22');
INSERT INTO `foodinf` VALUES ('3', '西瓜', '3000', '31', '0.014', '0.11', '5.7', '0', '0.11', '0.5', '0.3', '6.8');
INSERT INTO `foodinf` VALUES ('4', '番茄', '170', '15', '0.031', '0.03', '14', '0', '0.42', '0.9', '0.2', '3.3');
INSERT INTO `foodinf` VALUES ('5', '黄瓜', '130', '16', '0.008', '0.09', '9', '0', '0.49', '0.8', '0.2', '2.9');
INSERT INTO `foodinf` VALUES ('6', '桃子', '200', '42', '0.002', '0.03', '10', '0', '0.71', '0.6', '0.1', '10');
INSERT INTO `foodinf` VALUES ('7', '橙子', '270', '48', '0.013', '0.18', '33', '0', '0.56', '0.8', '0.2', '11.1');
INSERT INTO `foodinf` VALUES ('8', '梨', '250', '51', '0.002', '0.09', '5', '0', '0.46', '0.3', '0.1', '13.1');
INSERT INTO `foodinf` VALUES ('9', '枣', '17', '113', '0', '0.17', '243', '0', '0.19', '1.8', '0.2', '27.8');
INSERT INTO `foodinf` VALUES ('10', '柚子', '1200', '42', '0.001', '0.07', '23', '0', '0', '0.8', '0.2', '9.5');
INSERT INTO `foodinf` VALUES ('11', '葡萄', '500', '45', '0.003', '0.05', '4', '0', '0.86', '0.4', '0.3', '10.3');
INSERT INTO `foodinf` VALUES ('12', '圣女果', '18', '25', '0.028', '0.05', '33', '0', '0.98', '1', '0.2', '5.8');
INSERT INTO `foodinf` VALUES ('13', '木瓜', '700', '30', '0', '0.07', '31', '0', '0', '0.6', '0', '7.2');
INSERT INTO `foodinf` VALUES ('14', '猕猴桃', '150', '61', '0.011', '0.13', '62', '0', '2.43', '0.8', '0.6', '14.5');
INSERT INTO `foodinf` VALUES ('15', '火龙果', '530', '55', '0', '0.05', '3', '0', '0.14', '1.1', '0.2', '13.3');
INSERT INTO `foodinf` VALUES ('16', '菠萝', '1200', '44', '0.002', '0.18', '18', '0', '0', '0.5', '0.1', '10.8');
INSERT INTO `foodinf` VALUES ('17', '草莓', '45', '32', '0.003', '0.09', '47', '0', '0.71', '1', '0.2', '7.1');
INSERT INTO `foodinf` VALUES ('18', '芒果', '250', '35', '0.075', '0.19', '23', '0', '1.21', '0.6', '0.2', '8.3');
INSERT INTO `foodinf` VALUES ('19', '哈密瓜', '300', '34', '0.077', '0.08', '12', '0', '0', '0.1', '0.5', '7.9');
INSERT INTO `foodinf` VALUES ('20', '甜瓜', '200', '26', '0.003', '0.14', '15', '0', '0.47', '0.4', '0.1', '6.2');
INSERT INTO `foodinf` VALUES ('21', '李子', '50', '38', '0.013', '0.05', '5', '0', '0.74', '0.7', '0.2', '8.7');
INSERT INTO `foodinf` VALUES ('22', '荔枝', '30', '71', '0.001', '0.24', '41', '0', '0', '0.9', '0.2', '16.6');
INSERT INTO `foodinf` VALUES ('23', '龙眼', '12', '71', '0.002', '0.15', '43', '0', '0', '1.2', '0.1', '16.6');
INSERT INTO `foodinf` VALUES ('24', '杏', '80', '38', '0.038', '0.1', '4', '0', '0.95', '0.9', '0.1', '9.1');
INSERT INTO `foodinf` VALUES ('25', '杨梅', '10', '30', '0.003', '0.06', '9', '0', '0.81', '0.8', '0.2', '6.7');
INSERT INTO `foodinf` VALUES ('26', '大白菜', '600', '20', '0.007', '0.32', '37.5', '0', '0.36', '1.6', '0.2', '3.4');
INSERT INTO `foodinf` VALUES ('27', '小白菜', '50', '14', '0.154', '0.06', '64', '0', '0.4', '1.4', '0.3', '2.4');
INSERT INTO `foodinf` VALUES ('28', '青菜', '60', '18', '0.2', '0.03', '10', '0', '0', '1.7', '0.2', '3.2');
INSERT INTO `foodinf` VALUES ('29', '西兰花', '350', '27', '0.013', '0.32', '56', '0', '0.76', '0.6', '3.5', '3.7');
INSERT INTO `foodinf` VALUES ('30', '萝卜', '510', '16', '0', '0.03', '19', '0', '0', '0.7', '0.1', '4');
INSERT INTO `foodinf` VALUES ('31', '花菜', '100', '20', '0.001', '0.26', '32', '0', '0', '1.7', '0.2', '4.2');
INSERT INTO `foodinf` VALUES ('32', '南瓜', '250', '23', '0.074', '0.13', '8', '0', '0.36', '0.7', '0.1', '5.3');
INSERT INTO `foodinf` VALUES ('33', '胡萝卜', '116', '39', '0.688', '0.07', '13', '0', '0.41', '1', '0.2', '8.8');
INSERT INTO `foodinf` VALUES ('34', '冬瓜', '400', '10', '0', '0', '16', '0', '0.04', '0.3', '0.2', '2.4');
INSERT INTO `foodinf` VALUES ('35', '生菜', '400', '16', '0.06', '0.19', '20', '0', '0', '1.4', '0.4', '2.1');
INSERT INTO `foodinf` VALUES ('36', '卷心菜', '100', '24', '0.006', '0.18', '40', '0', '0.5', '1.5', '0.2', '4.6');
INSERT INTO `foodinf` VALUES ('37', '菠菜', '50', '28', '0.243', '0.35', '32', '0', '1.74', '2.6', '0.3', '4.5');
INSERT INTO `foodinf` VALUES ('38', '竹笋', '1000', '23', '0', '0.4', '5', '0', '0.05', '2.6', '0.2', '3.6');
INSERT INTO `foodinf` VALUES ('39', '木耳', '100', '27', '0.002', '0.19', '1', '0', '0', '1.5', '0.2', '6');
INSERT INTO `foodinf` VALUES ('40', '豆芽', '100', '16', '0.001', '0.13', '4', '0', '0', '1.7', '0.1', '2.6');
INSERT INTO `foodinf` VALUES ('41', '香菇', '10', '26', '0', '0.17', '1', '0', '0', '2.2', '0.3', '5.2');
INSERT INTO `foodinf` VALUES ('42', '茄子', '150', '23', '0.004', '0.14', '5', '0', '1.13', '1.1', '0.2', '4.9');
INSERT INTO `foodinf` VALUES ('43', '鸡蛋', '60', '139', '0.255', '1.35', '0', '0.002', '1.14', '13.1', '8.6', '2.4');
INSERT INTO `foodinf` VALUES ('44', '猪肉', '50', '143', '0.044', '1.64', '0', '0.0005', '0.34', '20.3', '6.2', '1.5');
INSERT INTO `foodinf` VALUES ('45', '鸭肉', '30', '240', '0.052', '0.22', '0', '0.0001', '0.27', '15.5', '19.7', '0.2');
INSERT INTO `foodinf` VALUES ('46', '鸡肉', '30', '389', '0.226', '0.43', '0', '0.0001', '0', '16.7', '35.4', '0.9');
INSERT INTO `foodinf` VALUES ('47', '牛肉', '50', '113', '0.004', '0.17', '0', '0.0001', '0.83', '21.3', '2.5', '1.3');
INSERT INTO `foodinf` VALUES ('48', '鱼', '20', '113', '0.011', '0.56', '0', '0', '2.03', '16.6', '5.2', '0');
INSERT INTO `foodinf` VALUES ('49', '虾', '10', '93', '0.015', '0.08', '0', '0.0003', '0.62', '18.6', '0.8', '2.8');
INSERT INTO `foodinf` VALUES ('50', '米饭', '180', '116', '0', '0.05', '0', '0', '0', '2.6', '0.3', '25.9');
INSERT INTO `foodinf` VALUES ('51', '豆浆', '250', '31', '0', '0.23', '0', '0', '1.06', '3', '1.6', '1.2');
INSERT INTO `foodinf` VALUES ('52', '豆腐', '100', '84', '0', '0.08', '0', '0', '5.79', '6.6', '5.3', '3.4');
INSERT INTO `foodinf` VALUES ('53', '花生', '1', '313', '0.001', '0.39', '14', '0', '2.93', '12', '25.4', '13');
INSERT INTO `foodinf` VALUES ('54', '核桃', '15', '646', '0.003', '0.87', '1', '0', '43.21', '14.9', '58.8', '19.1');
INSERT INTO `foodinf` VALUES ('55', '豆干', '10', '197', '0', '0.07', '0', '0', '13', '14.9', '11.3', '9.6');
INSERT INTO `foodinf` VALUES ('56', '牛奶', '200', '65', '0.054', '0.69', '1', '0.0011', '0.13', '3.3', '3.6', '4.9');
INSERT INTO `foodinf` VALUES ('57', '酸奶', '200', '70', '0.019', '0.57', '1', '0.0012', '0.13', '3.2', '1.9', '10');
INSERT INTO `foodinf` VALUES ('58', '玉米', '160', '112', '0', '0.27', '16', '0', '0.46', '4', '1.2', '22.8');
INSERT INTO `foodinf` VALUES ('59', '红薯', '130', '86', '0.709', '0.33', '2.4', '0', '0.26', '1.57', '0.1', '20.12');
INSERT INTO `foodinf` VALUES ('60', '面包', '60', '313', '0', '0.17', '0', '0', '1.66', '8.3', '5.1', '58.6');
INSERT INTO `foodinf` VALUES ('61', '面条', '350', '107', '0', '0.03', '0', '0', '0', '3.9', '0.4', '22.8');
INSERT INTO `foodinf` VALUES ('62', '薯片', '3', '548', '0', '0', '0', '0', '0', '7.5', '37.6', '53.4');
INSERT INTO `foodinf` VALUES ('63', '炸鸡', '200', '215', '0.0336', '0.7', '0', '0.0025', '6.2', '19.71', '9.08', '14.55');
INSERT INTO `foodinf` VALUES ('64', '饼干', '6', '435', '0.037', '0.12', '3', '0', '4.57', '9', '12.7', '71.7');
INSERT INTO `foodinf` VALUES ('65', '冰淇淋', '50', '127', '0.048', '0.42', '0', '0.0002', '0.24', '2.4', '5.3', '17.3');

-- ----------------------------
-- Table structure for healthclassroom
-- ----------------------------
DROP TABLE IF EXISTS `healthclassroom`;
CREATE TABLE `healthclassroom` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `administrator_id` int NOT NULL,
  `title` varchar(30) NOT NULL,
  `link` varchar(50) NOT NULL,
  `tags` varchar(50) NOT NULL,
  `viewers` int DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `FK_Relationship_7` (`administrator_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`administrator_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员发布的健康课程';

-- ----------------------------
-- Records of healthclassroom
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int NOT NULL AUTO_INCREMENT,
  `administrator_id` int NOT NULL,
  `content` varchar(1024) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`notice_id`),
  KEY `relationship_1` (`administrator_id`),
  CONSTRAINT `relationship_1` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`administrator_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `questionnaire_id` int NOT NULL AUTO_INCREMENT,
  `administrator_id` int NOT NULL,
  `name` varchar(1024) DEFAULT NULL,
  `problemNum` int DEFAULT NULL,
  PRIMARY KEY (`questionnaire_id`),
  KEY `FK_Relationship_8` (`administrator_id`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`administrator_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='调查问卷';

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('1', '1', '心理调查问卷', '13');
INSERT INTO `questionnaire` VALUES ('2', '1', '身体健康状况调查问卷', '10');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `questionnaire_id` int NOT NULL,
  `question` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `answerOne` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `answerTwo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `answerThree` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `answerFour` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `point` int DEFAULT NULL,
  PRIMARY KEY (`subject_id`,`questionnaire_id`),
  KEY `FK_Relationship_5` (`questionnaire_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaire` (`questionnaire_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='问卷中的题目';

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '1', '以下情况最符合你的是：', '我不感到忧郁', '我感到忧郁或沮丧', '我整天忧郁，无法摆脱', '我十分忧郁，已经承受不住', '1');
INSERT INTO `subject` VALUES ('1', '2', '你的身体成分达标吗？（脂肪率和去脂体重指数）', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('2', '1', '你对未来抱有什么态度？', '我对未来并不感到悲观失望', '我感到前途不太乐观', '我感到我对前途不抱希望', '我感到今后毫无希望，不可能有所好转', '1');
INSERT INTO `subject` VALUES ('2', '2', '膝盖不弯曲能摸到脚趾吗？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('3', '1', '你是如何看待失败的感觉？', '我并无失败的感觉', '我觉得和大多数人相比我是失败的', '回顾我的一生，我觉得那是一连串的失败', '我觉得我是个彻底失败的人', '1');
INSERT INTO `subject` VALUES ('3', '2', '你是否偶尔才会喘不上气？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('4', '1', '你对生活的满意度如何？', '我并不觉得我有什么不满意', '我觉得我不能像平时那样享受生活', '任何事情都不能使我感到满意一些 ', '我对所有的事情都不满意', '1');
INSERT INTO `subject` VALUES ('4', '2', '你能在12分钟内跑完两公里吗？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('5', '1', '你的内疚感有多深？', '我没有特殊的内疚感', '我有时感到内疚或觉得自己没价值', '我感到非常内疚', '我觉得自己非常坏，一钱不值', '1');
INSERT INTO `subject` VALUES ('5', '2', '活动完是否一会儿就能恢复？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('6', '1', '你是否会对自己感到失望？', '我没有对自己感到失望', '我对自己感到失望', '我讨厌自己', '我憎恨自己', '1');
INSERT INTO `subject` VALUES ('6', '2', '你能举木板保持1分钟吗？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('7', '1', '你会有想要伤害自己的想法吗？', '我没有要伤害自己的想法 ', '我感到还是死掉的好', '我考虑过自杀', '如果有机会，我还会杀了自己 ', '1');
INSERT INTO `subject` VALUES ('7', '2', '你中午经常休息吗？', '是 ', '否', null, null, '1');
INSERT INTO `subject` VALUES ('8', '1', '你是否失去与他人交往的兴趣？', '我没失去和他人交往的兴趣', '和平时相比，我和他人交往的兴趣有所减退 ', '我已失去大部分和人交往的兴趣，我对他们没', '我对他人全无兴趣，也完全不理睬别人', '1');
INSERT INTO `subject` VALUES ('8', '2', '你是否不容易紧张？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('9', '1', '做决定对你来说，是否感到困难？', '我能像平时一样做出决断', '我尝试避免做决定', '对我而言，做出决断十分困难 ', '我无法做出任何决断 ', '1');
INSERT INTO `subject` VALUES ('9', '2', '你记性好吗？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('10', '1', '与过去相比，你是否对你的形象不自信？', '我觉得我的形象一点也不比过去糟', '我担心我看起来老了，不吸引人了', '我觉得我的外表肯定变了，变得不具吸引力', '我觉得我的形象丑陋不堪且讨人厌 ', '1');
INSERT INTO `subject` VALUES ('10', '2', '你的睡眠好吗？', '是', '否', null, null, '1');
INSERT INTO `subject` VALUES ('11', '1', '你对工作抱有何种态度？', '我能像平时那样工作', '我做事时，要额外地努力才能开始', '我必须努力迫使自己，方能干事 ', '我完全不能做事情', '1');
INSERT INTO `subject` VALUES ('12', '1', '和以往相比，你是否会很容易就感到疲倦？', '和以往相比，我并不容易疲倦', '我比过去容易觉得疲倦', '我做任何事都感到疲倦', '我太易疲倦了，不能干任何事', '1');
INSERT INTO `subject` VALUES ('13', '1', '与过去相比，你的胃口如何？', '我的胃口不比过去差 ', '我的胃口没有过去那样好', '现在我的胃口比过去差多了', '我一点食欲都没有', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(1024) NOT NULL,
  `user_password` varchar(1024) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `gender` varchar(1024) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表，其中包含属性为用户id，用户名，和用户密码';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123asd', 'e10adc3949ba59abbe56e057f20f883e', '18175570266', 'male', '2000-03-14', '949412659@qq.com');
INSERT INTO `user` VALUES ('2', 'HeZH123', 'e10adc3949ba59abbe56e057f20f883e', '18175577725', 'male', '2000-03-14', 'pengyupingw@outlook.com');

-- ----------------------------
-- Table structure for usereat
-- ----------------------------
DROP TABLE IF EXISTS `usereat`;
CREATE TABLE `usereat` (
  `user_id` int NOT NULL,
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `number` int NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`user_id`,`name`,`date`),
  KEY `relationship_2` (`name`),
  CONSTRAINT `FK_Relationship12` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `relationship_2` FOREIGN KEY (`name`) REFERENCES `foodinf` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of usereat
-- ----------------------------

-- ----------------------------
-- Table structure for user_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `user_evaluation`;
CREATE TABLE `user_evaluation` (
  `date` date NOT NULL,
  `user_id` int NOT NULL,
  `grade` int NOT NULL,
  PRIMARY KEY (`date`,`user_id`),
  KEY `FK_Relationship_4` (`user_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每名用户每次的评价分数记录';

-- ----------------------------
-- Records of user_evaluation
-- ----------------------------

-- ----------------------------
-- Table structure for user_exercise
-- ----------------------------
DROP TABLE IF EXISTS `user_exercise`;
CREATE TABLE `user_exercise` (
  `date` date NOT NULL,
  `user_id` int NOT NULL,
  `total_calorie` int NOT NULL,
  PRIMARY KEY (`date`,`user_id`),
  KEY `FK_Relationship_2` (`user_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每名用户每日的锻炼情况';

-- ----------------------------
-- Records of user_exercise
-- ----------------------------
INSERT INTO `user_exercise` VALUES ('2021-07-20', '1', '500');

-- ----------------------------
-- Table structure for user_food
-- ----------------------------
DROP TABLE IF EXISTS `user_food`;
CREATE TABLE `user_food` (
  `date` date NOT NULL,
  `user_id` int NOT NULL,
  `total_calorie` int NOT NULL,
  `total_vitaminA` double DEFAULT NULL,
  `total_vitaminB` double DEFAULT NULL,
  `total_vitaminC` double DEFAULT NULL,
  `total_vitaminD` double DEFAULT NULL,
  `total_vitaminE` double DEFAULT NULL,
  `total_protein` double DEFAULT NULL,
  `total_fat` double DEFAULT NULL,
  `total_carbs` double DEFAULT NULL,
  PRIMARY KEY (`date`,`user_id`),
  KEY `FK_Relationship_1` (`user_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每名用户每日的饮食情况';

-- ----------------------------
-- Records of user_food
-- ----------------------------

-- ----------------------------
-- Table structure for user_height_weight
-- ----------------------------
DROP TABLE IF EXISTS `user_height_weight`;
CREATE TABLE `user_height_weight` (
  `date` date NOT NULL,
  `user_id` int NOT NULL,
  `height` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  PRIMARY KEY (`date`,`user_id`),
  KEY `FK_Relationship_10` (`user_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='user_height_weight';

-- ----------------------------
-- Records of user_height_weight
-- ----------------------------
INSERT INTO `user_height_weight` VALUES ('2021-07-20', '1', '161', '56');

-- ----------------------------
-- Table structure for user_questionnaire_grade
-- ----------------------------
DROP TABLE IF EXISTS `user_questionnaire_grade`;
CREATE TABLE `user_questionnaire_grade` (
  `questionnaire_id` int NOT NULL,
  `date` date NOT NULL,
  `user_id` int NOT NULL,
  `grade` int NOT NULL,
  PRIMARY KEY (`questionnaire_id`,`date`,`user_id`),
  KEY `FK_Relationship_6` (`user_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `relationship` FOREIGN KEY (`questionnaire_id`) REFERENCES `questionnaire` (`questionnaire_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每名用户每日调查问卷的分数';

-- ----------------------------
-- Records of user_questionnaire_grade
-- ----------------------------
INSERT INTO `user_questionnaire_grade` VALUES ('1', '2021-07-20', '1', '6');
INSERT INTO `user_questionnaire_grade` VALUES ('2', '2021-07-20', '1', '8');

-- ----------------------------
-- Table structure for user_sleep
-- ----------------------------
DROP TABLE IF EXISTS `user_sleep`;
CREATE TABLE `user_sleep` (
  `date` date NOT NULL,
  `user_id` int NOT NULL,
  `sleeptime` int NOT NULL,
  `starttime` time NOT NULL,
  PRIMARY KEY (`date`,`user_id`),
  KEY `FK_Relationship_3` (`user_id`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每名用户的每日睡眠情况';

-- ----------------------------
-- Records of user_sleep
-- ----------------------------
INSERT INTO `user_sleep` VALUES ('2021-07-20', '1', '8', '23:45:00');
