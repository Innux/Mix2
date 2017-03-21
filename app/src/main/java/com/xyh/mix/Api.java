package com.xyh.mix;

/**
 * Created by xyh on 2017/3/15.
 */
public class Api {

    /*分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
第几页：数字，大于0
例：
http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
数据类型： 福利 | Android | iOS  | 拓展资源 | 前端
请求个数： 数字，大于0
http://gank.io/api/data/Android/10/1
http://gank.io/api/data/福利/10/1
http://gank.io/api/data/iOS/20/2
http://gank.io/api/data/all/20/2*/
    public static final String GANK_BASIC_URL = "http://gank.io/api/data/";
    public static final String GANK_BASIC_URL_TEST = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    public static final String GANK_WELFARE = "%E7%A6%8F%E5%88%A9/15/1";
    public static final String GANK_ANDROID = "Android/15/";
    public static final String GANK_iOS = "iOS/15/";
    public static final String GANK_EXTEND = "拓展资源/15/";
    public static final String GANK_FRONT = "前端/15/";

    public static final int GANK_FIRST_PAGE = 1;
}
