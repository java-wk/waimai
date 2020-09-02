
手动打包上线
```
rsync /search/user/pmm/dev/activities-common-service.jar webServer02.bj3::root/odin/daemon/activities-common-service/bin/

scp -r root@172.21.0.6:/search/user/pmm/dev/course-situation-center-service-0.0.1-SNAPSHOT.jar ./bin/course-situation-center-service.jar

rsync /search/user/wk/activities-common-service.jar server01.bj3::root/odin/daemon/activities-common-service/bin/
rsync /search/user/wk/activities-common-service.jar server02.bj3::root/odin/daemon/activities-common-service/bin/
rsync /search/user/wk/activities-common-service.jar server03.bj3::root/odin/daemon/activities-common-service/bin/
rsync /search/user/wk/activities-common-service.jar server04.bj3::root/odin/daemon/activities-common-service/bin/

rsync /search/user/wk/activities-common-service.jar server01.bj3::root/odin/daemon/activities-common-service/bin/
```


日志相关：
```
/search/dfs_log/activities-common-service/Server0*.bj3/

    cd /search/user/shy/tools/ && omnitty  -T 200
    @server.list

    vim /search/odin/daemon/activities-common-service/log/activities-common-service.2020-0
    omnitty  -T 120
    omnitty  -T 120 -w 80
    omnitty  -W 80


grep 'at com.putaoabc.activitiescommonservice' /search/dfs_log/course-service/Server0[1-4].bj3/course-service.2020-08-16.log
grep '215620' /search/dfs_log/activities-common-service/Server0[1-4].bj3/activities-common-service.2020-08-24.log
grep 'putaoId=413532' /search/dfs_log/activities-common-service/Server0[1-4].bj3/activities-common-service.2020-08-24.log
grep 'putaoId=328041' /search/dfs_log/activities-common-service/Server0[1-4].bj3/activities-common-service.2020-08-24.log
grep xception /search/odin/daemon/activities-common-service/log/activities-common-service.2020-08-18.log >> xception-2020-8-18.log
grep '.java:' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-08-18.log >> at.java:2020-8-18.log
grep 'putaoid=741189' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-09-01.log >> at.java:2020-8-18.log
grep 'Params: inviteRewardRecordDTO' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-09-01.log >> at.java:2020-8-18.log
grep 'conversion提卡-' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-09-01.log >> at.java:2020-8-18.log

    defaultErrorHandler-系统异常
    xception:
    'com.putaoabc.activitiescommonservice'
    putaoid=49350


String logStr = LogUtil.getLogStr(Thread.currentThread().getStackTrace()[1].getMethodName());
logger.info(logStr + " Params: putaoId={} ", putaoId);
logger.info(logStr + " Params: putaoId={} refundType={} ", putaoId, refundType);
logger.info(logStr + " Params: classId={} ", classId);
logger.info(logStr + " Params: putaoId={} refundFee={} orderId={} refundType={}", putaoId, refundFee, orderId, refundType);

logger.info(logStr + " rewardRecord={} ",rewardRecord);

logger.info(logStr + " Return: GroupBuyOtnVO={}", JSON.toJSONString(vo, true));
logger.info(logStr + " Return: vo={}", vo);
logger.info(logStr + " Return: void=success! ");

logger.error(logStr + " Return: void=failed! ", e);
logger.error(logStr + " Exception: 创建定时任务失败! ", e);

```

日志写法
```

    /**
     * 老带新团购 退款
     */
    public boolean applyRefund(Integer putaoId, Integer refundFee, Integer orderId, String refundType) {
        String logStr = LogUtil.getLogStr(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info(logStr + " Params: putaoId={} refundFee={} orderId={} refundType={}", putaoId, refundFee, orderId, refundType);

        try {
            ApplyRefundParamDTO applyRefundParamDTO = new ApplyRefundParamDTO();
            applyRefundParamDTO.setOrderId(orderId);
            applyRefundParamDTO.setPutaoId(putaoId);
            applyRefundParamDTO.setRefundFee(refundFee);
            applyRefundParamDTO.setRefundType(refundType);

            orderFeignClient.applyRefund(applyRefundParamDTO);
            logger.info(logStr + " Return: void=success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

```


mysql
```
本地
10.10.34.14		root		123456
dev
172.21.0.4   jdbc:mysql://154.8.138.91:3306/miniprogram 	root		m1i2m3a02
product - test(yufa)
jdbc:mysql://172.21.0.8:3306   172.21.0.8		backend 		rd_0419_YG
ssh
ssh：192.144.190.227 	u=root 	p=ZhiXue@YG_t_Ct
```


Redis
```
本地  10.10.34.14	6379	spring.redis.app.password=	spring.redis.app.database=1

Dev	     172.21.0.4     (154.8.138.91)	    	  root         m1i2m3a02	6379   database=2
Dev2	 172.21.0.41    (140.143.188.55)	      backend	   m1i2m3a03	6379   database=2

product - test(yufa)   172.21.0.3	6379	m6i1m2a3	database=2

```


已部署App
```
60.195.40.162

Jenkins http://putaoabc-inc.com:18080/
jenkins inner.putaoabc.net.cn:18080
git inner.putaoabc.net.cn:8082
wiki inner.putaoabc.net.cn:8081
maven inner.putaoabc.net.cn:8086

```



一些小记
```
swagger.enabled=false

host: '10.10.34.130:8789'
host: 'dev.putaoabc.net.cn'

【团长】classid：368 渠道：7367
【团员】classid：369 渠道：7368

欧飞余额查询
curl -X GET "https://api2.ofpay.com/newqueryuserinfo.do?userid=A200611014&userpws=1a4400630630941ccd40611f0afe6fa8&version=6.0&format=json" -H "accept: */*"

find / -name '*.sh'

grep -r -w '08/26' .
grep -r -w 'course_v2/activityCenter' .


```


```
老带新拼团-裂变积分

https://test.putaoabc.net.cn/course_v2/activityCenter/groupBuyOtn/createActivity?startTime=20200825000000&endTime=20211231235959&classIdMaster=477&classIdMember=475&sourceMaster=7829&sourceMember=7825&groupBuyCount=2&type=2&themeLessonUnit=24

startTime=20200825000000&endTime=20211231235959&classIdMaster=477&classIdMember=475&sourceMaster=7829&sourceMember=7825&groupBuyCount=2&type=2&themeLessonUnit=24

Air Force:
https://www.putaoabc.com/onlinepages/op_activity/obgroup?otnLabel=93f92a1a

开团页：
https://webres.putaoabc.com/jht/image/dlgroup/list2.png
https://webres.putaoabc.com/jht/image/dlgroup/list3.png
https://webres.putaoabc.com/jht/image/dlgroup/list4.png

参团页：
https://webres.putaoabc.com/jht/image/appbuy/bg_01.png
https://webres.putaoabc.com/jht/image/combuy6/bg_02.png
https://webres.putaoabc.com/jht/image/combuy6/bg_04.png
https://webres.putaoabc.com/jht/image/combuy6/bg_07.png
https://webres.putaoabc.com/jht/image/combuy6/bg_08.png
https://webres.putaoabc.com/jht/image/combuy6/bg_09.png

头图：https://webres.putaoabc.com/jht/image/obgroup/banner.png
海报：https://webres.putaoabc.com/jht/image/obgroup/poster.png



[root@webServer02 ~]# grep 'conversion提卡-' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-09-01.log
2020-09-01 10:43:36.062  INFO 31919 --- [nio-8789-exec-3] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15989282153666056 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"3779-AB8A-741B-CF45","cardno":"JDV58320005980000182"}],"orderid":"S2009011335949","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"41","ordercash":"9.98","retcode":"1"}
2020-09-01 10:48:56.703  INFO 31919 --- [nio-8789-exec-5] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=1598928536134182 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tpxd2p2d92R9b2","cardno":"e49fc031168cf7e352c581d55071f3a3"}],"orderid":"S2009011361763","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"42","ordercash":"16","retcode":"1"}
2020-09-01 10:49:10.361  INFO 31919 --- [nio-8789-exec-3] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15989285496135674 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23thxs2n2297Rfcf","cardno":"80a6b1fa706caaaa651d2c7e1efda589"}],"orderid":"S2009011363085","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"43","ordercash":"16","retcode":"1"}
2020-09-01 10:52:38.360  INFO 31919 --- [nio-8789-exec-6] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15989287578466337 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"F0C6-EC81-3E14-848F","cardno":"JDV58320005980000190"}],"orderid":"S2009011380919","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"44","ordercash":"9.98","retcode":"1"}
2020-09-01 11:06:25.504  INFO 31919 --- [nio-8789-exec-7] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15989295848669638 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tWxM2h2996R2h8","cardno":"f2503de023723b7fe41ef92024722ed3"}],"orderid":"S2009011430587","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"45","ordercash":"16","retcode":"1"}
2020-09-01 11:07:10.348  INFO 31919 --- [nio-8789-exec-9] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=1598929629793305 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tQxR2j2691R3i3","cardno":"7f2324c70ff238dd97f832fb10328d95"}],"orderid":"S2009011433106","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"46","ordercash":"16","retcode":"1"}
2020-09-01 16:48:26.995  INFO 8757 --- [nio-8789-exec-8] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15989501069686050 act=conversion提卡-redemptionResult:
2020-09-01 16:48:47.710  INFO 8757 --- [nio-8789-exec-3] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=1598950127691787 act=conversion提卡-redemptionResult:
[root@webServer02 ~]# grep 'conversion提卡-' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-08-31.log
2020-08-31 18:07:46.089  INFO 31919 --- [nio-8789-exec-8] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988684654468708 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"DBBF-F0AB-61F9-5C82","cardno":"JDV58320005980000052"}],"orderid":"S2008319344314","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"34","ordercash":"9.98","retcode":"1"}
2020-08-31 18:07:58.601  INFO 31919 --- [nio-8789-exec-3] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988684781251928 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"3622-39D6-4266-DACC","cardno":"JDV58320005980000053"}],"orderid":"S2008319344709","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"35","ordercash":"9.98","retcode":"1"}
2020-08-31 18:23:08.063  INFO 31919 --- [nio-8789-exec-5] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988693874519134 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"6125-5D2D-9256-E8C8","cardno":"JDV58320005980000055"}],"orderid":"S2008319378040","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"36","ordercash":"9.98","retcode":"1"}
2020-08-31 18:23:32.274  INFO 31919 --- [nio-8789-exec-2] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988694117937903 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23t4xy2Y239bP8Aa","cardno":"820aa6bf42154af1994d1bd0ab2ed528"}],"orderid":"S2008319379019","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"37","ordercash":"16","retcode":"1"}
2020-08-31 18:23:42.494  INFO 31919 --- [nio-8789-exec-1] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988694220191067 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tNxj2t219cP7B0","cardno":"cfc1004009a9197e248610be19096a72"}],"orderid":"S2008319379442","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"38","ordercash":"16","retcode":"1"}
2020-08-31 19:56:33.700  INFO 31919 --- [nio-8789-exec-8] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988749928815840 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"79A5-5B00-00E7-9C92","cardno":"JDV58320005980000061"}],"orderid":"S2008319686026","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"39","ordercash":"9.98","retcode":"1"}
2020-08-31 19:57:36.702  INFO 31919 --- [nio-8789-exec-1] c.p.a.s.c.ActivityCreditsShoppingService : url=/course_v2/activityCenter/credits/conversioning logId=15988750562135898 act=conversion提卡-redemptionResult:{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tixK282a96P0Y1","cardno":"1538a37bbdb5c7c92b1f1b9644b99bab"}],"orderid":"S2008319688189","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"40","ordercash":"16","retcode":"1"}

```



{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"3779-AB8A-741B-CF45","cardno":"JDV58320005980000182"}],"orderid":"S2009011335949","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"41","ordercash":"9.98","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"F0C6-EC81-3E14-848F","cardno":"JDV58320005980000190"}],"orderid":"S2009011380919","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"44","ordercash":"9.98","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"DBBF-F0AB-61F9-5C82","cardno":"JDV58320005980000052"}],"orderid":"S2008319344314","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"34","ordercash":"9.98","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"3622-39D6-4266-DACC","cardno":"JDV58320005980000053"}],"orderid":"S2008319344709","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"35","ordercash":"9.98","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"6125-5D2D-9256-E8C8","cardno":"JDV58320005980000055"}],"orderid":"S2008319378040","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"36","ordercash":"9.98","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2022-08-21","cardpws":"79A5-5B00-00E7-9C92","cardno":"JDV58320005980000061"}],"orderid":"S2008319686026","err_msg":"","cardname":"京东E卡10元卡密","cardid":"1227401","sporder_id":"39","ordercash":"9.98","retcode":"1"}


{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tpxd2p2d92R9b2","cardno":"e49fc031168cf7e352c581d55071f3a3"}],"orderid":"S2009011361763","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"42","ordercash":"16","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23thxs2n2297Rfcf","cardno":"80a6b1fa706caaaa651d2c7e1efda589"}],"orderid":"S2009011363085","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"43","ordercash":"16","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tWxM2h2996R2h8","cardno":"f2503de023723b7fe41ef92024722ed3"}],"orderid":"S2009011430587","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"45","ordercash":"16","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tQxR2j2691R3i3","cardno":"7f2324c70ff238dd97f832fb10328d95"}],"orderid":"S2009011433106","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"46","ordercash":"16","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23t4xy2Y239bP8Aa","cardno":"820aa6bf42154af1994d1bd0ab2ed528"}],"orderid":"S2008319379019","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"37","ordercash":"16","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tNxj2t219cP7B0","cardno":"cfc1004009a9197e248610be19096a72"}],"orderid":"S2008319379442","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"38","ordercash":"16","retcode":"1"}
{"cardnum":"1","cards":[{"expiretime":"2021-07-19","cardpws":"wA23tixK282a96P0Y1","cardno":"1538a37bbdb5c7c92b1f1b9644b99bab"}],"orderid":"S2008319688189","err_msg":"","cardname":"腾讯视频VIP（月卡）20元卡密","cardid":"1241804","sporder_id":"40","ordercash":"16","retcode":"1"}
