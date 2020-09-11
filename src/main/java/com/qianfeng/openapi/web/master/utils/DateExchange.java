package com.qianfeng.openapi.web.master.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ZMQ
 * @Date 2020/9/10
 * @since 1.8
 * 日期转换
 */
public class DateExchange {
    private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 转UtilsDate
     * @param str
     * @return
     * @throws ParseException
     */
    public static java.util.Date strToUtilDate(String str) throws ParseException {
        Date date = SIMPLEDATEFORMAT.parse(str);
        return date;
    }

    /**
     * 转SQLDate
     * @param str
     * @return
     * @throws ParseException
     */
    public static java.sql.Date strToSqlDate(String str) throws ParseException {
        Date date = SIMPLEDATEFORMAT.parse(str);
        return new java.sql.Date(date.getTime());
    }
}
