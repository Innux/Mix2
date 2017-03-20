package com.xyh.mix.bean;

import java.util.ArrayList;

/**
 * Created by xyh on 2017/3/15.
 */

public class ClassifyBean {
    public ArrayList<HotName> tngou;

    //页签对象
    public class HotName {
        public String description;
        public String keywords;
        public String name;
        public String title;
        public int id;
        public int seq;

        @Override
        public String toString() {
            return "hotName{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TypeBean{" +
                "tngou=" + tngou +
                '}';
    }
}
