package com.demo.util;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * Created by lWX458933 on 2017/4/19.
 */
public class JsonUtil {

    /**
     * 对象转换为json字符串
     *
     * @param obj
     * @return String
     */
    public static String toJsonString(Object obj) {
        return toJSONString(obj);
    }
}
