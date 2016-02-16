/**
 * 文件名: RegexChk.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2015-11-14
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <p>功能描述：检查输入格式工具类</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2015-11-14
 */
public class RegexChk
{
    /**
     * 建立模板编译器，检查字符是否匹配
     * @param regex
     * @param str
     * @return boolean
     */
    public static boolean check(String regex,String str){
        boolean tem = false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        tem = matcher.matches();
        return tem;
    }
    
    /**
     * 判断输入值是否为空
     * @param str
     * @return boolean
     */
    public static boolean notNull(String str){
        if(str.trim().equals("")||str.trim() == null){
            return false;
        }else{
            return true;
        }
    }
    
    /**
     * 判断输入是否为数字,并且在1-999之间
     * @param str
     * @return boolean
     */
    public static boolean chkisNum(String str){
        String reg = "^[1-9][0-9]{0,2}$";
        return check(reg, str);
    }
    
    /**
     * 检查字符串长度
     * @param str
     * @param min
     * @param max
     * @return boolean
     */
    public static boolean chkStrLength(String str,Integer min,Integer max){
System.out.println(str.getBytes().length);
        if(str.getBytes().length >= min || str.getBytes().length < max ){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 检查是否包含有特殊字符
     * @param str
     * @return boolean
     */
    public static boolean chk_special_characters(String str){
        String reg = "^[^`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）&—|{}【】‘；：”“'。，、？]+$";
       return check(reg, str);
    }
}
