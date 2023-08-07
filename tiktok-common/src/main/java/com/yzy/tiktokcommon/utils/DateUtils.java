package com.yzy.tiktokcommon.utils;

import java.util.Date;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/8/5 22:09
 */
public class DateUtils {
    public static Long GetNow() {
        Date date = new Date();
        Long time = date.getTime();
        return time;
    }
}
