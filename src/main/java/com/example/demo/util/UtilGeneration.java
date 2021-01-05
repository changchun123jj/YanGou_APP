package com.example.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 种子生成器控件
 *
 */
public class UtilGeneration {
    private static Map<String, String> gensIndex;    //种子池
    private static int maxIndex = 999;                //种子最大值(极端情况下,每毫秒最多生成maxIndex个)

    /**
     * 获取主键(默认key)
     *
     * @return
     */
    public static String getGenId() {
        String result = Long.toString(new Date().getTime());
        try {
            result += UtilGeneration.getNextGenIndex(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取主键(种子key,不同对象ID可分别设置)
     *
     * @param key
     * @return
     */
    public static String getGenId(String key) {
        String result = Long.toString(new Date().getTime());
        try {
            result += UtilGeneration.getNextGenIndex(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取下一个种子索引
     *
     * @param key
     * @return
     * @throws ServiceException
     */
    private static String getNextGenIndex(String key) throws ServiceException {
        int result = 1;
        //传空则为默认key
        if (key == null || "".equals(key.trim())) {
            key = "default";
        }
        //种子池中获取索引值
        if (gensIndex == null) {
            //.. 首次设置种子池
            gensIndex = new HashMap<String, String>();
            gensIndex.put(key, Integer.toString(result));
        } else if (gensIndex.get(key) == null || "".equals(gensIndex.get(key).trim())) {
            //.. 种子池无此key
            gensIndex.put(key, Integer.toString(result));
        } else {
            //.. 种子池有此key
            result = Integer.parseInt(gensIndex.get(key));
            if (++result > maxIndex) {
                result = 1;
            }
            gensIndex.put(key, Integer.toString(result));
        }
        return UtilString.formatLen(Integer.toString(result), Integer.toString(maxIndex).length(), "0");
    }

}
