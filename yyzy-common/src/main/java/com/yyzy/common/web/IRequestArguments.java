/**
 * 文件名: IRequestArguments.java
 * 版 权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: Feng.Chu
 * 修改时间: 2015-11-21
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.web;

/**
 * <p>功能描述：请求参数接口</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Feng.Chu
 * @version 1.0 2015-11-21
 */
public interface IRequestArguments
{
    /**
     * 获得请求参数的值为字符串(默认返回NULL)
     * 
     * @param paramName 参数名称
     * @return 参数的值
     */
    public String getStringValue(String paramName);

    /**
     * 获得请求参数的值为字符串
     * 
     * @param paramName 参数名称
     * @param defaultValue 默认值
     * @return 参数的值
     */
    public String getStringValue(String paramName, String defaultValue);

    /**
     * 获得请求参数的值为整型(默认返回0)
     * 
     * @param paramName 参数名称
     * @return 参数的值
     */
    public int getIntValue(String paramName);

    /**
     * 获得请求参数的值为整型
     * 
     * @param paramName 参数名称
     * @param defaultValue 默认值
     * @return 参数的值
     */
    public int getIntValue(String paramName, int defaultValue);

    /**
     * 获得请求参数的值为Boolean型(默认返回false)
     * 
     * @param paramName 参数名称
     * @return 参数的值
     */
    public boolean getBooleanValue(String paramName);

    /**
     * 获得请求参数的值为Boolean型
     * 
     * @param paramName 参数名称
     * @param defaultValue 默认值
     * @return 参数的值
     */
    public boolean getBooleanValue(String paramName, boolean defaultValue);

    /**
     * 请求是否包含指定名称的请求参数
     * 
     * @param paramName 参数名称
     * @return 包含指定名称的请求参数返回true, 否则false.
     */
    public boolean constians(String paramName);
}
