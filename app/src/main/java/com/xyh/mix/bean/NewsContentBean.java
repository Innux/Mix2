package com.xyh.mix.bean;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/17.
 */

public class NewsContentBean {

    /*"tngou": [
        {
			"count": 216,
			"description": "记者5日从贵阳南明警方处获悉，贵阳市公安局南明分局经济犯罪侦查大队日前在火车站八达巷一居民楼内，成功捣毁一个制售假发票窝点，抓获江某等3名犯罪嫌疑人，缴获假发票102万份，其中单张发票最大票值达999万，总票值达10亿余元",
			"fcount": 0,
			"fromname": "中国青年网",
			"fromurl": "http://minsheng.youth.cn/mszxgch/201701/t20170105_9014157.htm",
			"id": 14989,
			"img": "/top/default.jpg",
			"keywords": "侦破10亿票值假发票",
			"rcount": 0,
			"time": 1483606290000,
			"title": "侦破10亿票值假发票 目前已被警方刑事拘留",
			"topclass": 1
		},
*/

    public ArrayList<NewsContent> tngou;
    //TODO 测试数据
    public String des;

    public class NewsContent {
        public String description;
        public String fromname;
        public String fromurl;
        public String img;
        public String keywords;
        public String title;
    }
}
