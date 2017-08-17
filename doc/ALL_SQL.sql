
-- 產品
DROP TABLE IF EXISTS `sun_product`;
CREATE TABLE `sun_product` (
	`id` VARCHAR(100) NOT NULL COMMENT '流水編號',
	`name` VARCHAR(50) NOT NULL COMMENT '產品名稱',
	`price` DECIMAL(10,2) NOT NULL DEFAULT 0 COMMENT '價格',
	`create_time` DATETIME NOT NULL COMMENT '建立時間',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

-- 帳號
DROP TABLE IF EXISTS `sun_account`;
CREATE TABLE `sun_account` (
	`id` VARCHAR(50) NOT NULL COMMENT '帳號id',
	`account` VARCHAR(20) NOT NULL COMMENT '帳號',
	`password` VARCHAR(20) NOT NULL COMMENT '密碼',
	`user_id` VARCHAR(50) NOT NULL COMMENT '使用者id',
	`status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '狀態:0=正常',
	`create_time` DATETIME NOT NULL COMMENT '建立時間',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

-- 使用者
DROP TABLE IF EXISTS `sun_user`;
CREATE TABLE `sun_user` (
	`id` VARCHAR(50) NOT NULL COMMENT '使用者id',
	`name` VARCHAR(50) NOT NULL COMMENT '使用者名稱',
	`nick_name` VARCHAR(50) NOT NULL COMMENT '使用者暱稱',
	`birthday` DATE NOT NULL COMMENT '生日',
	`create_time` DATETIME NOT NULL COMMENT '建立時間',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;



-- 批次設定表
DROP TABLE IF EXISTS `sun_batch`;
CREATE TABLE IF NOT EXISTS `sun_batch` (
  `id` varchar(50) NOT NULL COMMENT '批次id',
  `description` varchar(50) NOT NULL COMMENT '批次用途描述',
  `cron_str` varchar(50) NOT NULL COMMENT '週期代碼',
  `run_time` time NOT NULL COMMENT '執行時間',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `update_user` VARCHAR(50) NOT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) 
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

-- 正在導出表  model_practice.sun_batch 的資料：~1 rows (大約)
INSERT INTO `sun_batch` (`id`, `cron_str`, `run_time`, `update_time`, `update_user`) VALUES
	('A', '0 0 9 * * ?', '09:00:00', '2017-06-16 14:25:56', 'A001'),
	('B', '0 0 20 * * ?', '20:00:00', '2017-06-16 14:28:18', 'A001');

	


