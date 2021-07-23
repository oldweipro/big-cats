/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : big_cats

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 23/07/2021 10:53:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `operation` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户操作',
  `method` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方法',
  `params` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求参数',
  `timelong` bigint DEFAULT NULL COMMENT '执行时长（毫秒）',
  `ip` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'IP地址',
  `creator_id` bigint DEFAULT NULL COMMENT '创建者ID',
  `modifier_id` bigint DEFAULT NULL COMMENT '修改者ID',
  `creator` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `parent_id` bigint DEFAULT NULL COMMENT '父级菜单ID，一级菜单为0',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(1000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '授权 逗号隔开',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型 0:目录 1:菜单 2:按钮',
  `icon` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
  `sort_num` tinyint DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `role_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `username` varchar(16) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '盐',
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `status` tinyint unsigned DEFAULT '1' COMMENT '状态 0:禁用 1:正常',
  `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `telephone` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `last_login_ip` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后一次登录的IP地址',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录的时间',
  `lang` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '系统语言',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (0, 1, NULL, NULL, '2021-07-21 11:29:37', NULL, '2021-07-21 11:50:59', 'oooldwei1', '289c26193e5c49a2039b8550f3e7c84c', NULL, NULL, 1, NULL, NULL, '15319977157', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1399646855951831041, 0, NULL, NULL, '2021-06-01 08:39:49', NULL, '2021-07-21 10:35:30', 'admin', 'e10adc3949ba59abbe56e057f20f883e', NULL, '172965909@qq.com', 1, NULL, 'https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1402566544475279362, 0, NULL, NULL, '2021-06-09 10:01:37', NULL, '2021-06-09 14:30:53', 'oldwei', '62c8ad0a15d9d1ca38d5dee762a16e01', NULL, '122965909@qq.com', 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1402621356981424130, 0, NULL, NULL, '2021-06-09 13:39:25', NULL, '2021-06-09 14:30:56', 'oooldwei', '5d93ceb70e2bf5daa84ec3d0cd2c731a', NULL, '142965909@qq.com', 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1402633772184178690, 0, NULL, NULL, '2021-06-09 14:28:45', NULL, '2021-07-21 11:24:26', 'admin1', '289c26193e5c49a2039b8550f3e7c84c', NULL, '172945909@qq.com', 1, NULL, NULL, '15319977157', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1417809646533525505, 1, NULL, NULL, '2021-07-21 11:32:16', NULL, '2021-07-21 11:50:56', 'haomingzi', '670b14728ad9902aecba32e22fa4f6bd', NULL, NULL, 1, NULL, NULL, '15319977157', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `user_id` bigint DEFAULT NULL COMMENT '用户ID',
  `token` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_token` VALUES (1399314569797173250, 0, NULL, NULL, '2021-05-31 10:39:26', NULL, '2021-05-31 10:39:26', 1399307750668476417, 'dmsatvg102tpsmjyvll8ft2h9gjdmlsk', '2021-06-01 06:39:26', '2021-05-31 18:39:26');
INSERT INTO `sys_user_token` VALUES (1399646352945754114, 0, NULL, NULL, '2021-06-01 08:37:49', NULL, '2021-06-01 08:37:49', 1399642868008230913, 'w0mh6vfrd85cf5sprevbjmczdcpm9kwh', '2021-06-02 04:37:49', '2021-06-01 16:37:49');
INSERT INTO `sys_user_token` VALUES (1399646932854394882, 0, NULL, NULL, '2021-06-01 08:40:07', NULL, '2021-06-01 08:40:07', 1399646855951831041, '99kyx6rp2j34q40u322dnc9k9xe7gdw1', '2021-06-02 04:40:08', '2021-06-01 16:40:08');
INSERT INTO `sys_user_token` VALUES (1399647798101561346, 0, NULL, NULL, '2021-06-01 08:43:33', NULL, '2021-06-01 08:43:33', 1399646855951831041, 'o7fajse9hyv6y9vjuf7imvgzn8m3dvqg', '2021-06-02 04:43:34', '2021-06-01 16:43:34');
INSERT INTO `sys_user_token` VALUES (1399648563360698370, 0, NULL, NULL, '2021-06-01 08:46:36', NULL, '2021-06-01 08:46:36', 1399646855951831041, 'nphahq29ceosjr6yxor6lv5xuy2accba', '2021-06-02 04:46:36', '2021-06-01 16:46:36');
INSERT INTO `sys_user_token` VALUES (1399663744589537281, 0, NULL, NULL, '2021-06-01 09:46:55', NULL, '2021-06-01 09:46:55', 1399646855951831041, '1nvj4bkjtif6ta6u8e023f92jzvtmh1h', '2021-06-02 05:46:56', '2021-06-01 17:46:56');
INSERT INTO `sys_user_token` VALUES (1399664551665909761, 0, NULL, NULL, '2021-06-01 09:50:08', NULL, '2021-06-01 09:50:08', 1399646855951831041, 'l5z8ee6q29g6yh4ora9uva4dj2yc4pum', '2021-06-02 05:50:08', '2021-06-01 17:50:08');
INSERT INTO `sys_user_token` VALUES (1399664972379734017, 0, NULL, NULL, '2021-06-01 09:51:48', NULL, '2021-06-01 09:51:48', 1399646855951831041, 'esdth85v3hbwenxnxuwzqwc8qhgbfup6', '2021-06-02 05:51:49', '2021-06-01 17:51:49');
INSERT INTO `sys_user_token` VALUES (1399666139730792450, 0, NULL, NULL, '2021-06-01 09:56:26', NULL, '2021-06-01 09:56:26', 1399646855951831041, 'mu6v1wrnpawoih6thms33iqvke582jy9', '2021-06-02 05:56:27', '2021-06-01 17:56:27');
INSERT INTO `sys_user_token` VALUES (1399666464579543041, 0, NULL, NULL, '2021-06-01 09:57:44', NULL, '2021-06-01 09:57:44', 1399646855951831041, 'g3b7cd5o8tvsrn4r4s71ph0s6nhah1vw', '2021-06-02 05:57:44', '2021-06-01 17:57:44');
INSERT INTO `sys_user_token` VALUES (1399741066306912258, 0, NULL, NULL, '2021-06-01 14:54:10', NULL, '2021-06-01 14:54:10', 1399646855951831041, 'r0otkn9v1c9iqnpxl89tryv6zynom6mb', '2021-06-02 10:54:11', '2021-06-01 22:54:11');
INSERT INTO `sys_user_token` VALUES (1399749574066700289, 0, NULL, NULL, '2021-06-01 15:27:59', NULL, '2021-06-01 15:27:59', 1399646855951831041, '97382ax3sd4tfmzj4wzzhazx6j3dhflp', '2021-06-02 11:27:59', '2021-06-01 23:27:59');
INSERT INTO `sys_user_token` VALUES (1399751713455366145, 0, NULL, NULL, '2021-06-01 15:36:29', NULL, '2021-06-01 15:36:29', 1399646855951831041, 'ro59emlrwwuxpnq865ywt77nduwa8740', '2021-06-02 11:36:29', '2021-06-01 23:36:29');
INSERT INTO `sys_user_token` VALUES (1399751952815906817, 0, NULL, NULL, '2021-06-01 15:37:26', NULL, '2021-06-01 15:37:26', 1399646855951831041, 'yrv1913s5tcofrev1avfntkx59okudsp', '2021-06-02 11:37:26', '2021-06-01 23:37:26');
INSERT INTO `sys_user_token` VALUES (1399934403488649217, 0, NULL, NULL, '2021-06-02 03:42:25', NULL, '2021-06-02 03:42:25', 1399646855951831041, 'zuz7zxyr1z75vd5k1uw0pbzahjodcjsg', '2021-06-02 23:42:26', '2021-06-02 11:42:26');
INSERT INTO `sys_user_token` VALUES (1400085927757393922, 0, NULL, NULL, '2021-06-02 13:44:32', NULL, '2021-06-02 13:44:32', 1399646855951831041, 'p68d8carizomlzkn5vimjj5aloewm3bs', '2021-06-03 09:44:32', '2021-06-02 21:44:32');
INSERT INTO `sys_user_token` VALUES (1400098636297887746, 0, NULL, NULL, '2021-06-02 14:35:02', NULL, '2021-06-02 14:35:02', 1399646855951831041, 'sfiyvzslezgpxin37w96a9nx4autl056', '2021-06-03 10:35:02', '2021-06-02 22:35:02');
INSERT INTO `sys_user_token` VALUES (1400098961004126209, 0, NULL, NULL, '2021-06-02 14:36:19', NULL, '2021-06-02 14:36:19', 1399646855951831041, '9y6jmg87sqip9561uqqo004k7bexf155', '2021-06-03 10:36:20', '2021-06-02 22:36:20');
INSERT INTO `sys_user_token` VALUES (1400099752682516482, 0, NULL, NULL, '2021-06-02 14:39:28', NULL, '2021-06-02 14:39:28', 1399646855951831041, 'j288jzlecyzy8c6ypsaxqm2x37adpdrb', '2021-06-03 10:39:28', '2021-06-02 22:39:28');
INSERT INTO `sys_user_token` VALUES (1400099887202234369, 0, NULL, NULL, '2021-06-02 14:40:00', NULL, '2021-06-02 14:40:00', 1399646855951831041, 'vnnxm8aockhbcvwn4w56k7od2bo4y5tt', '2021-06-03 10:40:00', '2021-06-02 22:40:00');
INSERT INTO `sys_user_token` VALUES (1400101307808833538, 0, NULL, NULL, '2021-06-02 14:45:39', NULL, '2021-06-02 14:45:39', 1399646855951831041, 'yqvz2wjrpnuddvo0qncfibz42cb59iwj', '2021-06-03 10:45:39', '2021-06-02 22:45:39');
INSERT INTO `sys_user_token` VALUES (1400102605396430850, 0, NULL, NULL, '2021-06-02 14:50:48', NULL, '2021-06-02 14:50:48', 1399646855951831041, 'zj3vl0s67wgfm0xibi2mmqv27zb4785j', '2021-06-03 10:50:48', '2021-06-02 22:50:48');
INSERT INTO `sys_user_token` VALUES (1400421601706635266, 0, NULL, NULL, '2021-06-03 11:58:23', NULL, '2021-06-03 11:58:23', 1399646855951831041, 'h47n8rk21a2h5qtjvv2zusc6ncwrrh2l', '2021-06-04 07:58:23', '2021-06-03 19:58:23');
INSERT INTO `sys_user_token` VALUES (1401745624092762113, 0, NULL, NULL, '2021-06-07 03:39:34', NULL, '2021-06-07 03:39:34', 1399646855951831041, 'igb0fhd53ksrupqvj0vnoex542tbj0xd', '2021-06-07 23:39:35', '2021-06-07 11:39:35');
INSERT INTO `sys_user_token` VALUES (1402115340095856642, 0, NULL, NULL, '2021-06-08 04:08:41', NULL, '2021-06-08 04:08:41', 1399646855951831041, '00lgurx24s71rj2saf3owfhlfv4qdgk1', '2021-06-09 00:08:42', '2021-06-08 12:08:42');
INSERT INTO `sys_user_token` VALUES (1402219986231734273, 0, NULL, NULL, '2021-06-08 11:04:31', NULL, '2021-06-08 11:04:31', 1399646855951831041, 'ny782k9jbym833ecr0snrhnm95v3lnps', '2021-06-09 07:04:31', '2021-06-08 19:04:31');
INSERT INTO `sys_user_token` VALUES (1402535427159670785, 0, NULL, NULL, '2021-06-09 07:57:58', NULL, '2021-06-09 07:57:58', 1399646855951831041, 'nlr71fg683rf04ni6j7tlmgme4afns31', '2021-06-10 03:57:58', '2021-06-09 15:57:58');
INSERT INTO `sys_user_token` VALUES (1402535601110040577, 0, NULL, NULL, '2021-06-09 07:58:39', NULL, '2021-06-09 07:58:39', 1399646855951831041, '5jr3qs1ipxojxcjd18kdrm5hdl3toxjm', '2021-06-10 03:58:40', '2021-06-09 15:58:40');
INSERT INTO `sys_user_token` VALUES (1402565306933301249, 0, NULL, NULL, '2021-06-09 09:56:42', NULL, '2021-06-09 09:56:42', 1399646855951831041, 'pq3qcrp2yyork80oce3n2a3ze67qvn0p', '2021-06-10 05:56:42', '2021-06-09 17:56:42');
INSERT INTO `sys_user_token` VALUES (1402566597063462913, 0, NULL, NULL, '2021-06-09 10:01:49', NULL, '2021-06-09 10:01:49', 1402566544475279362, 'pc8bwewswydt4l38e6u7w8n83ka4wnkb', '2021-06-10 06:01:50', '2021-06-09 18:01:50');
INSERT INTO `sys_user_token` VALUES (1402566648569516033, 0, NULL, NULL, '2021-06-09 10:02:02', NULL, '2021-06-09 10:02:02', 1399646855951831041, 'xwxo9l3olwy088bllzb239vugfv3web2', '2021-06-10 06:02:02', '2021-06-09 18:02:02');
INSERT INTO `sys_user_token` VALUES (1402616296134922242, 0, NULL, NULL, '2021-06-09 13:19:19', NULL, '2021-06-09 13:19:19', 1399646855951831041, '8r52i2ey383l2206c5698eahxynixo6j', '2021-06-10 09:19:19', '2021-06-09 21:19:19');
INSERT INTO `sys_user_token` VALUES (1402916662747570178, 0, NULL, NULL, '2021-06-10 09:12:52', NULL, '2021-06-10 09:12:52', 1399646855951831041, '65fzuvn3b7jtqrtt68a93c4283596six', '2021-06-11 05:12:52', '2021-06-10 17:12:52');
INSERT INTO `sys_user_token` VALUES (1417784590189953026, 0, NULL, NULL, '2021-07-21 09:52:42', NULL, '2021-07-21 09:52:42', 1399646855951831041, 'beiarq2ykt2l4rx6gi8jp15nf6qe4zgn', '2021-07-22 05:52:42', '2021-07-21 17:52:42');
INSERT INTO `sys_user_token` VALUES (1417784675401433089, 0, NULL, NULL, '2021-07-21 09:53:02', NULL, '2021-07-21 09:53:02', 1399646855951831041, '35ds5y5bbt7g4vphoep7ofkush3q6u4a', '2021-07-22 05:53:02', '2021-07-21 17:53:02');
INSERT INTO `sys_user_token` VALUES (1417795398051528705, 0, NULL, NULL, '2021-07-21 10:35:38', NULL, '2021-07-21 10:35:38', 1399646855951831041, 'vpw62acq7dgoq2m56fl7745mew1y3d1r', '2021-07-22 06:35:39', '2021-07-21 18:35:39');
INSERT INTO `sys_user_token` VALUES (1417795593376092162, 0, NULL, NULL, '2021-07-21 10:36:25', NULL, '2021-07-21 10:36:25', 1399646855951831041, 'idbignrlr4oheelyjz447l5jdixy43b3', '2021-07-22 06:36:25', '2021-07-21 18:36:25');
INSERT INTO `sys_user_token` VALUES (1417796337068134402, 0, NULL, NULL, '2021-07-21 10:39:22', NULL, '2021-07-21 10:39:22', 1399646855951831041, '11301an74v7qind87c466qtulmjrd34m', '2021-07-22 06:39:23', '2021-07-21 18:39:23');
INSERT INTO `sys_user_token` VALUES (1417807257227280385, 0, NULL, NULL, '2021-07-21 11:22:46', NULL, '2021-07-21 11:22:46', 1399646855951831041, '6jk5tn1e6trfhe2chaiprb167g0xkj02', '2021-07-22 07:22:46', '2021-07-21 19:22:46');
INSERT INTO `sys_user_token` VALUES (1418022786680496129, 0, NULL, NULL, '2021-07-22 01:39:12', NULL, '2021-07-22 01:39:12', 1399646855951831041, '911ajcsnnckocpp1f8ubag7zi5zms68v', '2021-07-22 21:39:13', '2021-07-22 09:39:13');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
