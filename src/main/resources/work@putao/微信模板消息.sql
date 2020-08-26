INSERT INTO `miniprogram`.`acti_msg_wx_template_record` (
`title`,
`description`,
`del`,
`course_type`,
`activity_id`,
`create_time`,
`content`,
`template_id`,
`template_msg_type`,
`wechat_official_name`,
`coupon_id`,
`remind_times`,
`msg_type` 
)
VALUES
	(
	NULL,
	'体验营代理拼团',
	0,
	NULL,
	NULL,
	'2020-01-01 00:00:00',
	'{"first":"恭喜你，拼团成功！","keyword1":"{B}","keyword2":"{H}","keyword3":"拼团成功","remark":"点击详情下载APP去上课","keyword1_color":"#7B64FF","keyword2_color":"#7B64FF","keyword3_color":"#7B64FF","remark_color":"#66CC00"}',
	'--TsU-37qZFX1LziCDw-krsmYg-Cv61DS48B6Iw9oDA',
	'任务完成提醒',
	'葡萄英语服务号',
	NULL,
	NULL,
NULL
	);


INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '积分商城-首次完课分享奖励', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "恭喜宝贝完成在葡萄英语的第1节课！今日使用APP分享完课海报到朋友圈，即可获得200积分奖励，500积分可兑换1课时，还有iPad等各种实物大礼！",
  "keyword1": "首次完课分享奖励",
  "keyword2": "使用推荐语分享专属海报到朋友圈，即可获得200积分",
  "keyword3": "待完成",
  "remark": "↓↓↓查看活动详情",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', '--TsU-37qZFX1LziCDw-krsmYg-Cv61DS48B6Iw9oDA', '任务完成提醒', '葡萄英语服务号', NULL, NULL, NULL );


INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '积分商城-完课分享奖励', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "宝贝太棒了！今天又学了新课！使用APP分享完课海报到朋友圈，即可获得50积分奖励，500积分可兑换1课时，还有iPad等各种实物大礼！",
  "keyword1": "完课分享奖励",
  "keyword2": "使用推荐语分享专属海报到朋友圈，即可获得50积分",
  "keyword3": "待完成",
  "remark": "↓↓↓查看活动详情",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', '--TsU-37qZFX1LziCDw-krsmYg-Cv61DS48B6Iw9oDA', '任务完成提醒', '葡萄英语服务号', NULL, NULL, NULL );

INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '积分商城-首次购课分享奖励', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "您有400积分未领取，500积分兑1课时，还有iPad等各种实物大礼！",
  "keyword1": "首次购课分享奖励",
  "keyword2": "使用30字以上推荐语分享专属海报到朋友圈，并上传截图，将获得400积分。",
  "keyword3": "待完成",
  "remark": "↓↓↓点击赚积分",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', '--TsU-37qZFX1LziCDw-krsmYg-Cv61DS48B6Iw9oDA', '任务完成提醒', '葡萄英语服务号', NULL, NULL, NULL );


-- 老带新拼团


INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '老带新拼团-1开团成功通知', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "恭喜你开团成功！邀请{成团人数-1}人参团即可获得{团长课时数}节课~！",
  "keyword1": "{团长课时数}节葡萄英语1对1美教课",
  "keyword2": "{团长支付金额}",
  "keyword3": "{成团人数}人",
  "keyword4": "{当期活动结束时间}",
  "remark": "↓↓点击详情去领取专属海报去邀请好友吧！",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "keyword4_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'EUDy1_18s4Dp9Pdc_54hJwbiq5gntMfatK321QnVgpQ', '开团成功通知', '葡萄英语服务号', NULL, NULL, NULL );



INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '老带新拼团-2参团通知', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "邀请参团成功！还差{成团人数-当前团内人数}人参团即可获得{团长课时数}节课~",
  "keyword1": "{团长课时数}节葡萄英语1对1美教课",
  "keyword2": "{团长支付金额}",
  "keyword3": "拼团进度 {当前团内人数}/{成团人数}人",
  "keyword4": "{当期活动结束时间}",
  "remark": "↓↓点击详情查看拼团进度",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "keyword4_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'q45_wPadiM9X2Yx5NKd_4Mo1cqnt2QYRZYh53vz7Vmc', '参团成功通知', '葡萄英语服务号', NULL, NULL, NULL );



INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '老带新拼团-3拼团成功', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "恭喜你拼团成功！已达到成团人数，获得{团长课时数}节葡萄英语1对1美教课~",
  "keyword1": "{团长课时数}节葡萄英语1对1美教课",
  "keyword2": "{团长支付金额}",
  "keyword3": "拼团成功",
  "remark": "↓↓点击详情查看拼团情况",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'R5TsLD1bnNgVOl0nR1mvmgr2FGoaQXp50e9sLcngkmw', '拼团成功通知', '葡萄英语服务号', NULL, NULL, NULL );



INSERT INTO `miniprogram`.`acti_msg_wx_template_record` ( `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type` )
VALUES
	( NULL, '老带新拼团-4提醒', 0, NULL, NULL, '2020-02-17 18:16:26', '{
  "first": "Hi，{用户英文昵称}您的拼团还有最后{距结束剩余小时数}小时就要结束咯，赶快邀请好友参加吧！",
  "keyword1": "{团长支付金额}元/{团长课时数}节葡萄英语1对1美教课",
  "keyword2": "仅剩最后{距结束剩余小时数}小时",
  "keyword2": "{成团人数-当前团内人数}人",
  "remark": "您的拼团还差{成团人数-当前团内人数}名团员就能成团了，加油哦！点击详情查看拼团进度↓",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'z4eJENcp1ypwudBjYMUEDfJO3072O71-9FnjmKeK4XU', '未成团提醒', '葡萄英语服务号', NULL, NULL, NULL );



UPDATE `miniprogram`.`acti_msg_wx_template_record`
SET `title` = NULL, `description` = '老带新拼团-5退款', `del` = 0, `course_type` = NULL, `activity_id` = NULL, `create_time` = '2020-02-17 18:16:26',
`content` = '{
  "first": "Hi，{用户英文昵称}您的拼团：{团长活动套餐名称}的钱款已原路退回至您的账户，请注意查收~",
  "keyword1": "{团长活动套餐名称}",
  "keyword2": "{团长支付金额}",
  "keyword3": "{团长支付金额}",
  "remark": "点击详情查看拼团情况↓↓",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}',
`template_id` = 'ylopNAC4WdeASKlmbmTNzEGlzuR0aaZWodzDIhIXaaY', `template_msg_type` = '退款通知', `wechat_official_name` = '葡萄英语服务号', `coupon_id` = NULL, `remind_times` = NULL, `msg_type` = NULL
WHERE `id` = 105;




INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`) VALUES (101, NULL, '老带新拼团-1开团成功通知', 0, NULL, NULL, '2020-02-17 18:16:26', '{\r\n  \"first\": \"恭喜你开团成功！邀请{成团人数-1}人参团即可获得{团长课时数}节课~！\",\r\n  \"keyword1\": \"{团长课时数}节葡萄英语1对1美教课\",\r\n  \"keyword2\": \"{团长支付金额}\",\r\n  \"keyword3\": \"{成团人数}人\",\r\n  \"keyword4\": \"{当期活动结束时间}\",\r\n  \"remark\": \"↓↓点击详情去领取专属海报去邀请好友吧！\",\r\n  \"keyword1_color\": \"#7B64FF\",\r\n  \"keyword2_color\": \"#7B64FF\",\r\n  \"keyword3_color\": \"#7B64FF\",\r\n  \"keyword4_color\": \"#7B64FF\",\r\n  \"remark_color\": \"#66CC00\"\r\n}', 'Nen8tXwoIzEw8lylyOc9LkBwKW3GHuSh9qvaWLxG0Lg', '开团成功通知', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`) VALUES (102, NULL, '老带新拼团-2参团通知', 0, NULL, NULL, '2020-02-17 18:16:26', '{\r\n  \"first\": \"邀请参团成功！还差{成团人数-当前团内人数}人参团即可获得{团长课时数}节课~\",\r\n  \"keyword1\": \"{团长课时数}节葡萄英语1对1美教课\",\r\n  \"keyword2\": \"{团长支付金额}\",\r\n  \"keyword3\": \"拼团进度 {当前团内人数}/{成团人数}人\",\r\n  \"keyword4\": \"{当期活动结束时间}\",\r\n  \"remark\": \"↓↓点击详情查看拼团进度\",\r\n  \"keyword1_color\": \"#7B64FF\",\r\n  \"keyword2_color\": \"#7B64FF\",\r\n  \"keyword3_color\": \"#7B64FF\",\r\n  \"keyword4_color\": \"#7B64FF\",\r\n  \"remark_color\": \"#66CC00\"\r\n}', 'q45_wPadiM9X2Yx5NKd_4Mo1cqnt2QYRZYh53vz7Vmc', '参团成功通知', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`) VALUES (103, NULL, '老带新拼团-3拼团成功', 0, NULL, NULL, '2020-02-17 18:16:26', '{\r\n  \"first\": \"恭喜你拼团成功！已达到成团人数，获得{团长课时数}节葡萄英语1对1美教课~\",\r\n  \"keyword1\": \"{团长课时数}节葡萄英语1对1美教课\",\r\n  \"keyword2\": \"{团长支付金额}\",\r\n  \"keyword3\": \"拼团成功\",\r\n  \"remark\": \"↓↓点击详情查看拼团情况\",\r\n  \"keyword1_color\": \"#7B64FF\",\r\n  \"keyword2_color\": \"#7B64FF\",\r\n  \"keyword3_color\": \"#7B64FF\",\r\n  \"remark_color\": \"#66CC00\"\r\n}', 'R5TsLD1bnNgVOl0nR1mvmgr2FGoaQXp50e9sLcngkmw', '拼团成功通知', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`) VALUES (104, NULL, '老带新拼团-4提醒', 0, NULL, NULL, '2020-02-17 18:16:26', '{\r\n  \"first\": \"Hi，{用户英文昵称}您的拼团还有最后{距结束剩余小时数}小时就要结束咯，赶快邀请好友参加吧！\",\r\n  \"keyword1\": \"{团长支付金额}元/{团长课时数}节葡萄英语1对1美教课\",\r\n  \"keyword2\": \"仅剩最后{距结束剩余小时数}小时\",\r\n  \"keyword2\": \"{成团人数-当前团内人数}人\",\r\n  \"remark\": \"您的拼团还差{成团人数-当前团内人数}名团员就能成团了，加油哦！点击详情查看拼团进度↓\",\r\n  \"keyword1_color\": \"#7B64FF\",\r\n  \"keyword2_color\": \"#7B64FF\",\r\n  \"keyword3_color\": \"#7B64FF\",\r\n  \"remark_color\": \"#66CC00\"\r\n}', 'z4eJENcp1ypwudBjYMUEDfJO3072O71-9FnjmKeK4XU', '未成团提醒', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`) VALUES (105, NULL, '老带新拼团-5退款', 0, NULL, NULL, '2020-02-17 18:16:26', '{\r\n  \"first\": \" Hi，{用户英文昵称}您的拼团：{团长支付金额}元/{团长课时数}节葡萄英语1对1美教课已结束，由于拼团失败，您的学费将在3个工作日内原路退回。\",\r\n  \"keyword1\": \"未达到成团人数，拼团失败\",\r\n  \"keyword2\": \"{团长支付金额}\",\r\n  \"remark\": \"您的拼团还差{成团人数-当前团内人数}名团员就能成团了，加油哦！点击详情查看拼团进度↓\",\r\n  \"keyword1_color\": \"#7B64FF\",\r\n  \"keyword2_color\": \"#7B64FF\",\r\n  \"remark_color\": \"#66CC00\"\r\n}', 'EUDy1_18s4Dp9Pdc_54hJwbiq5gntMfatK321QnVgpQ', '退款通知', '葡萄英语服务号', NULL, NULL, NULL);

INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`)
VALUES (121, NULL, '老带新拼团裂变-1开团成功通知', 0, NULL, NULL, '2020-02-17 18:16:26',
'{
  "first": "恭喜你开团成功！邀请{成团人数-1}人参团即可成团~",
  "keyword1": "{团长活动套餐名称}",
  "keyword2": "{团长支付金额}",
  "keyword3": "{成团人数}人",
  "keyword4": "{当期活动结束时间}",
  "remark": "↓↓点击详情去领取专属海报去邀请好友吧！",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "keyword4_color": "#7B64FF",
  "remark_color": "#66CC00"
}',
 'Nen8tXwoIzEw8lylyOc9LkBwKW3GHuSh9qvaWLxG0Lg', '开团成功通知', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`)
VALUES (122, NULL, '老带新拼团裂变-2参团通知', 0, NULL, NULL, '2020-02-17 18:16:26',
'{
  "first": "邀请参团成功！还差{成团人数-当前团内人数}人参团即可成团~",
  "keyword1": "{团长活动套餐名称}",
  "keyword2": "{团长支付金额}",
  "keyword3": "拼团进度 {当前团内人数}/{成团人数}人",
  "keyword4": "{当期活动结束时间}",
  "remark": "↓↓点击详情查看拼团进度",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "keyword4_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'q45_wPadiM9X2Yx5NKd_4Mo1cqnt2QYRZYh53vz7Vmc', '参团成功通知', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`)
VALUES (123, NULL, '老带新拼团裂变-3拼团成功', 0, NULL, NULL, '2020-02-17 18:16:26',
'{
  "first": " 恭喜你拼团成功！已达到成团人数，获得成团奖励~",
  "keyword1": "{团长活动套餐名称}",
  "keyword2": "{团长支付金额}",
  "keyword3": "拼团成功",
  "remark": "↓↓点击详情查看拼团情况",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'R5TsLD1bnNgVOl0nR1mvmgr2FGoaQXp50e9sLcngkmw', '拼团成功通知', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`)
VALUES (124, NULL, '老带新拼团裂变-4提醒', 0, NULL, NULL, '2020-02-17 18:16:26',
'{
  "first": "Hi，{用户英文昵称}您的拼团还有最后{距结束剩余小时数}小时就要结束咯，赶快邀请好友参加吧！",
  "keyword1": "{团长活动套餐名称}",
  "keyword2": "仅剩最后{距结束剩余小时数}小时",
  "keyword3": "{成团人数-当前团内人数}人",
  "remark": "您的拼团还差{成团人数-当前团内人数}名团员就能成团了，加油哦！点击详情查看拼团进度↓",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'lUNRHlvUuQBGNHyGGYcykNHGy58dx9zeCDAiwpCsnDc', '未成团提醒', '葡萄英语服务号', NULL, NULL, NULL);
INSERT INTO `miniprogram`.`acti_msg_wx_template_record`(`id`, `title`, `description`, `del`, `course_type`, `activity_id`, `create_time`, `content`, `template_id`, `template_msg_type`, `wechat_official_name`, `coupon_id`, `remind_times`, `msg_type`)
VALUES (125, NULL, '老带新拼团裂变-5拼团失败', 0, NULL, NULL, '2020-02-17 18:16:26',
'{
  "first": "Hi，{用户英文昵称}您的拼团：{团长活动套餐名称}已结束，将无法获得成团奖励，但不影响您开团获得的课程~",
  "keyword1": "{团长活动套餐名称}",
  "keyword2": "{团长支付金额}",
  "keyword3": "无退款，仍可正常上课",
  "remark": "点击详情查看拼团情况↓↓",
  "keyword1_color": "#7B64FF",
  "keyword2_color": "#7B64FF",
  "keyword3_color": "#7B64FF",
  "remark_color": "#66CC00"
}', 'ylopNAC4WdeASKlmbmTNzEGlzuR0aaZWodzDIhIXaaY', '拼团失败通知', '葡萄英语服务号', NULL, NULL, NULL);






