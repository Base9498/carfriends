package com.carfriend.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * 格式化工具
 */
public class FormattingTool {

    /***
     * 字符串格式为时间戳
     * @param dateStamp 时间字符串
     * @return 格式化时间戳
     */
    public static Date StringFormatDate(String dateStamp){
        SimpleDateFormat smp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse=null;
        try {
            parse=smp.parse(dateStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    /***
     * 字符串传long型
     * @param str 字符串
     * @return 转换结果
     */
    public static Long StringFormatLong(String str){
        return Long.valueOf(str);
    }
}
