package com.xyh.mix.bean;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/21.
 */

/*"results": [
    {
      "_id": "58d08621421aa95810795ca1",
      "createdAt": "2017-03-21T09:47:13.3Z",
      "desc": "3-21",
      "publishedAt": "2017-03-21T12:19:46.895Z",
      "source": "chrome",
      "type": "\u798f\u5229",
      "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-21-17268102_763630507137257_3620762734536163328_n%20-1-.jpg",
      "used": true,
      "who": "dmj"
    }, */
public class WelfareBean {

    public ArrayList<WelfareDetail> results;

    public class WelfareDetail{
        public String desc;
        public String type;
        public String url;
        public String source;
        public String _id;
        public String who;
        public String used;
        public String publishedAt;
        public String createdAt;

        @Override
        public String toString() {
            return "WelfareDetail{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WelfareBean{" +
                "results=" + results +
                '}';
    }
}
