
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
grep 'putaoid=413532' /search/odin/daemon/activities-common-service/log/activities-common-service.2020-08-26.log >> at.java:2020-8-18.log

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

```