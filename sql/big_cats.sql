/*
 Navicat Premium Data Transfer

 Source Server         : big_cats
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : home.oldwei.com:3306
 Source Schema         : big_cats

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 06/09/2021 18:00:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户操作',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求方法',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '请求参数',
  `timelong` bigint(20) DEFAULT NULL COMMENT '执行时长（毫秒）',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'IP地址',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `modifier_id` bigint(20) DEFAULT NULL COMMENT '修改者ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE
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
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父级菜单ID，一级菜单为0',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '授权 逗号隔开',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型 0:目录 1:菜单 2:按钮',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标',
  `sort_num` tinyint(4) DEFAULT NULL COMMENT '排序',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `hidden` tinyint(1) DEFAULT NULL COMMENT '是否隐藏',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组件',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '重定向',
  `target` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '打开方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1421881306307891201, 0, NULL, NULL, '2021-08-01 17:11:35', NULL, '2021-08-01 17:11:35', NULL, 0, 'dashboard', NULL, NULL, NULL, 'dashboard', NULL, '仪表盘', NULL, 'RouteView', '/dashboard/workplace', NULL);
INSERT INTO `sys_menu` VALUES (1421904771303989250, 0, NULL, NULL, '2021-08-01 18:44:49', NULL, '2021-08-01 18:44:49', NULL, 1421881306307891201, 'workplace', NULL, NULL, NULL, NULL, NULL, '工作台', NULL, 'Workplace', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1421905223068278786, 0, NULL, NULL, '2021-08-01 18:46:37', NULL, '2021-08-01 18:50:12', NULL, 1421881306307891201, 'monitor', 'https://www.baidu.com/', NULL, NULL, NULL, NULL, '监控页（外部）', NULL, NULL, NULL, '_blank');
INSERT INTO `sys_menu` VALUES (1421906428930678785, 0, NULL, NULL, '2021-08-01 18:51:25', NULL, '2021-08-01 18:51:25', NULL, 1421881306307891201, 'Analysis', '/dashboard/analysis', NULL, NULL, NULL, NULL, '分析页', NULL, 'Analysis', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1421906611177381889, 0, NULL, NULL, '2021-08-01 18:52:08', NULL, '2021-09-01 17:23:02', NULL, 0, 'form', NULL, NULL, NULL, 'form', NULL, '表单页', NULL, 'RouteView', '/form/basic-form', NULL);
INSERT INTO `sys_menu` VALUES (1421907229514260482, 0, NULL, NULL, '2021-08-01 18:54:35', NULL, '2021-09-01 17:23:35', NULL, 0, 'cats', NULL, NULL, NULL, 'user', NULL, '系统设置', NULL, 'RouteView', '/cats/sys-user', NULL);
INSERT INTO `sys_menu` VALUES (1421907765760221185, 0, NULL, NULL, '2021-08-01 18:56:43', NULL, '2021-08-01 18:57:42', NULL, 1421907229514260482, 'sys-user', NULL, NULL, NULL, NULL, NULL, '用户管理', NULL, 'cats/sysUser/SysUser', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1421907915379433473, 0, NULL, NULL, '2021-08-01 18:57:19', NULL, '2021-08-01 18:57:19', NULL, 1421907229514260482, 'sys-menu', NULL, NULL, NULL, NULL, NULL, '菜单管理', NULL, 'cats/sysMenu/SysMenu', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422753772014206977, 0, NULL, NULL, '2021-08-04 02:58:27', NULL, '2021-08-04 03:03:16', NULL, 1421906611177381889, 'basic-form', NULL, NULL, NULL, NULL, NULL, '基础表单', NULL, 'BasicForm', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422753978227163137, 0, NULL, NULL, '2021-08-04 02:59:16', NULL, '2021-08-04 03:03:18', NULL, 1421906611177381889, 'step-form', NULL, NULL, NULL, NULL, NULL, '分步表单', NULL, 'StepForm', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422754184867938305, 0, NULL, NULL, '2021-08-04 03:00:05', NULL, '2021-08-04 03:03:23', NULL, 1421906611177381889, 'advanced-form', NULL, NULL, NULL, NULL, NULL, '高级表单', NULL, 'AdvanceForm', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422757069441794049, 0, NULL, NULL, '2021-08-04 03:11:33', NULL, '2021-09-01 16:58:35', NULL, 0, 'list', NULL, NULL, NULL, 'table', NULL, '列表页', NULL, 'RouteView', '/list/table-list', NULL);
INSERT INTO `sys_menu` VALUES (1422757316259807233, 0, NULL, NULL, '2021-08-04 03:12:32', NULL, '2021-08-04 03:51:36', NULL, 1422757069441794049, 'table-list', '/list/table-list/:pageNo([1-9]\\\\\\\\d*)?', NULL, NULL, NULL, NULL, '查询表格', NULL, 'TableList', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422768486219857921, 0, NULL, NULL, '2021-08-04 03:56:55', NULL, '2021-08-04 03:56:55', NULL, 1422757069441794049, 'basic-list', NULL, NULL, NULL, NULL, NULL, '标准列表', NULL, 'StandardList', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422768568554045441, 0, NULL, NULL, '2021-08-04 03:57:15', NULL, '2021-08-04 03:57:15', NULL, 1422757069441794049, 'card', NULL, NULL, NULL, NULL, NULL, '卡片列表', NULL, 'CardList', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422768689719099394, 0, NULL, NULL, '2021-08-04 03:57:44', NULL, '2021-09-01 16:59:37', NULL, 1422757069441794049, 'search', NULL, NULL, NULL, NULL, NULL, '搜索列表', NULL, 'SearchLayout', '/list/search/article', NULL);
INSERT INTO `sys_menu` VALUES (1422768854584606722, 0, NULL, NULL, '2021-08-04 03:58:23', NULL, '2021-08-04 03:58:23', NULL, 1422768689719099394, 'article', NULL, NULL, NULL, NULL, NULL, '搜索列表（文章）', NULL, 'SearchArticles', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422768951271702530, 0, NULL, NULL, '2021-08-04 03:58:46', NULL, '2021-08-04 03:58:46', NULL, 1422768689719099394, 'project', NULL, NULL, NULL, NULL, NULL, '搜索列表（项目）', NULL, 'SearchProjects', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422769045295415298, 0, NULL, NULL, '2021-08-04 03:59:08', NULL, '2021-08-04 03:59:08', NULL, 1422768689719099394, 'application', NULL, NULL, NULL, NULL, NULL, '搜索列表（应用）', NULL, 'SearchApplications', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422769165898432513, 0, NULL, NULL, '2021-08-04 03:59:37', NULL, '2021-08-04 03:59:37', NULL, 0, 'profile', NULL, NULL, NULL, 'profile', NULL, '详情页', NULL, 'RouteView', '/profile/basic', NULL);
INSERT INTO `sys_menu` VALUES (1422769259968282625, 0, NULL, NULL, '2021-08-04 04:00:00', NULL, '2021-08-04 04:00:00', NULL, 1422769165898432513, 'basic', NULL, NULL, NULL, NULL, NULL, '基础详情页', NULL, 'ProfileBasic', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422769348220633090, 0, NULL, NULL, '2021-08-04 04:00:21', NULL, '2021-08-04 04:00:21', NULL, 1422769165898432513, 'advanced', NULL, NULL, NULL, NULL, NULL, '高级详情页', NULL, 'ProfileAdvanced', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422769469293412354, 0, NULL, NULL, '2021-08-04 04:00:49', NULL, '2021-08-04 04:00:49', NULL, 0, 'result', NULL, NULL, NULL, 'check-circle-o', NULL, '结果页', NULL, 'PageView', '/result/success', NULL);
INSERT INTO `sys_menu` VALUES (1422769598507335681, 0, NULL, NULL, '2021-08-04 04:01:20', NULL, '2021-08-04 04:01:20', NULL, 1422769469293412354, 'success', NULL, NULL, NULL, NULL, NULL, '成功', NULL, 'ResultSuccess', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422769670469009410, 0, NULL, NULL, '2021-08-04 04:01:37', NULL, '2021-08-04 04:01:37', NULL, 1422769469293412354, 'fail', NULL, NULL, NULL, NULL, NULL, '失败', NULL, 'ResultFail', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422769808692297730, 0, NULL, NULL, '2021-08-04 04:02:10', NULL, '2021-08-04 04:02:10', NULL, 0, 'exception', NULL, NULL, NULL, 'warning', NULL, '异常页', NULL, 'RouteView', '/exception/403', NULL);
INSERT INTO `sys_menu` VALUES (1422769999738650626, 0, NULL, NULL, '2021-08-04 04:02:56', NULL, '2021-08-04 04:02:56', NULL, 1422769808692297730, '403', NULL, NULL, NULL, NULL, NULL, '403', NULL, 'Exception403', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422770066419695618, 0, NULL, NULL, '2021-08-04 04:03:12', NULL, '2021-08-04 04:03:12', NULL, 1422769808692297730, '404', NULL, NULL, NULL, NULL, NULL, '404', NULL, 'Exception404', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422770145201307649, 0, NULL, NULL, '2021-08-04 04:03:31', NULL, '2021-08-04 04:03:31', NULL, 1422769808692297730, '500', NULL, NULL, NULL, NULL, NULL, '500', NULL, 'Exception500', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422770300830957569, 0, NULL, NULL, '2021-08-04 04:04:08', NULL, '2021-08-04 04:04:08', NULL, 0, 'account', NULL, NULL, NULL, 'user', NULL, '个人页', NULL, 'RouteView', '/account/center', NULL);
INSERT INTO `sys_menu` VALUES (1422770407093649409, 0, NULL, NULL, '2021-08-04 04:04:33', NULL, '2021-08-04 04:04:33', NULL, 1422770300830957569, 'center', NULL, NULL, NULL, NULL, NULL, '个人中心', NULL, 'AccountCenter', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422770570763780097, 0, NULL, NULL, '2021-08-04 04:05:12', NULL, '2021-08-04 04:05:12', NULL, 1422770300830957569, 'settings', NULL, NULL, NULL, NULL, NULL, '个人设置', NULL, 'AccountSettings', '/account/settings/base', NULL);
INSERT INTO `sys_menu` VALUES (1422770742512140290, 0, NULL, NULL, '2021-08-04 04:05:53', NULL, '2021-08-04 04:05:53', NULL, 1422770570763780097, 'BaseSettings', '/account/settings/base', NULL, NULL, NULL, NULL, '基本设置', NULL, 'BaseSettings', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422770869440167938, 0, NULL, NULL, '2021-08-04 04:06:23', NULL, '2021-08-04 04:06:23', NULL, 1422770570763780097, 'SecuritySettings', '/account/settings/security', NULL, NULL, NULL, NULL, '安全设置', NULL, 'SecuritySettings', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422770967796596738, 0, NULL, NULL, '2021-08-04 04:06:47', NULL, '2021-08-04 04:06:47', NULL, 1422770570763780097, 'CustomSettings', '/account/settings/custom', NULL, NULL, NULL, NULL, '个性化设置', NULL, 'CustomSettings', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422771083144151041, 0, NULL, NULL, '2021-08-04 04:07:14', NULL, '2021-08-04 04:07:14', NULL, 1422770570763780097, 'BindingSettings', '/account/settings/binding', NULL, NULL, NULL, NULL, '账户绑定', NULL, 'BindingSettings', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422771204468588546, 0, NULL, NULL, '2021-08-04 04:07:43', NULL, '2021-08-04 04:07:43', NULL, 1422770570763780097, 'NotificationSettings', '/account/settings/notification', NULL, NULL, NULL, NULL, '新消息通知', NULL, 'NotificationSettings', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422784731686191105, 0, NULL, NULL, '2021-08-04 05:01:28', NULL, '2021-08-04 05:01:28', NULL, 0, 'hik', NULL, NULL, NULL, NULL, NULL, 'hik', NULL, 'RouteView', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422785303466295298, 0, NULL, NULL, '2021-08-04 05:03:45', NULL, '2021-08-04 05:03:45', NULL, 1422784731686191105, 'device', NULL, NULL, NULL, NULL, NULL, '设备管理', NULL, 'hik/device/Device', NULL, NULL);
INSERT INTO `sys_menu` VALUES (1422815201685704706, 0, NULL, NULL, '2021-08-04 07:02:33', NULL, '2021-08-04 07:02:33', NULL, 1422784731686191105, 'category', NULL, NULL, NULL, NULL, NULL, '区域管理', NULL, 'hik/category/Category', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
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
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
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
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '盐',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(3) unsigned DEFAULT '1' COMMENT '状态 0:禁用 1:正常',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `last_login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后一次登录的IP地址',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录的时间',
  `lang` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '系统语言',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (0, 1, NULL, NULL, '2021-07-21 11:29:37', NULL, '2021-08-15 15:37:01', 1, 'oooldwei1', '289c26193e5c49a2039b8550f3e7c84c', NULL, NULL, 1, NULL, NULL, '15319977157', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1399646855951831041, 0, NULL, NULL, '2021-06-01 08:39:49', NULL, '2021-08-15 15:50:19', 2, 'admin', 'e10adc3949ba59abbe56e057f20f883e', NULL, '172965909@qq.com', 1, NULL, 'https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png', NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1402566544475279362, 0, NULL, NULL, '2021-06-09 10:01:37', NULL, '2021-08-15 15:37:07', 2, 'oldwei', '62c8ad0a15d9d1ca38d5dee762a16e01', NULL, '122965909@qq.com', 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1402621356981424130, 0, NULL, NULL, '2021-06-09 13:39:25', NULL, '2021-09-03 17:33:23', 1, 'oooldwei', 'e10adc3949ba59abbe56e057f20f883e', NULL, '142965909@qq.com', 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1402633772184178690, 0, NULL, NULL, '2021-06-09 14:28:45', NULL, '2021-08-15 15:51:50', 1, 'admin1', '289c26193e5c49a2039b8550f3e7c84c', NULL, '172945909@qq.com', 1, NULL, NULL, '15319977157', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (1417809646533525505, 0, NULL, NULL, '2021-07-21 11:32:16', NULL, '2021-09-03 17:34:43', 1, 'haomingzi', '670b14728ad9902aecba32e22fa4f6bd', NULL, NULL, 1, NULL, NULL, '15319977157', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
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
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `del_flag` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '删除标记',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改者',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_token` VALUES (1434796683202326529, 0, NULL, NULL, '2021-09-06 16:32:41', NULL, '2021-09-06 16:32:41', NULL, 1399646855951831041, 'eq2f1wjon2n0ni5hudovkeojvstimxu9', '2021-09-07 04:32:41', '2021-09-06 16:32:41');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
