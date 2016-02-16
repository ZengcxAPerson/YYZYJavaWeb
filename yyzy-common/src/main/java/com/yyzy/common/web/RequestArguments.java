/**
 * 文件名: RequestArguments.java
 * 版 权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: Feng.Chu
 * 修改时间: 2015-11-21
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Feng.Chu
 * @version 1.0 2015-11-21
 */
public class RequestArguments implements IRequestArguments
{
    /**
     * 请求参数对象集合
     */
    private Map<String, Object> arguments = null;

    /**
     * 构造函数
     * 
     * @param arguments 请求参数对象集合
     */
    public RequestArguments(Map<String, Object> arguments)
    {
        this.arguments = arguments;
    }
    
    /**
     * 通过HttpServletRequest请求对象创建请求参数对象
     * 
     * @param request HttpServletRequest请求对象
     * @return 请求参数对象
     */
    @SuppressWarnings("unchecked")
    public static IRequestArguments createRequestArgument(HttpServletRequest request)
    {
        return new RequestArguments(request.getParameterMap());
    }

    /**
     * 通过请求参数对象集合创建请求参数对象
     * 
     * @param arguments 请求参数对象集合
     * @return 请求参数对象
     */
    public static RequestArguments createRequestArgument(Map<String, Object> arguments)
    {
        return new RequestArguments(arguments);
    }

    /**
     * 获得请求参数的值为字符串(默认返回NULL)
     * 
     * @param paramName 参数名称
     * @return 参数的值
     */
    public String getStringValue(String paramName)
    {
        return this.getStringValue(paramName, null);
    }

    /**
     * 获得请求参数的值为字符串
     * 
     * @param paramName 参数名称
     * @param defaultValue 默认值
     * @return 参数的值
     */
    public String getStringValue(String paramName, String defaultValue)
    {
        if (this.constians(paramName))
        {
            Object value = this.arguments.get(paramName);
            return (null == value ? defaultValue : (String) value);
        }
        return defaultValue;
    }

    /**
     * 获得请求参数的值为整型(默认返回0)
     * 
     * @param paramName 参数名称
     * @return 参数的值
     */
    public int getIntValue(String paramName)
    {
        return this.getIntValue(paramName, 0);
    }

    /**
     * 获得请求参数的值为整型
     * 
     * @param paramName 参数名称
     * @param defaultValue 默认值
     * @return 参数的值
     */
    public int getIntValue(String paramName, int defaultValue)
    {
        if (this.constians(paramName))
        {
            Object value = this.arguments.get(paramName);
            return (null == value ? defaultValue : Integer.parseInt(value.toString()));
        }
        return defaultValue;
    }

    /**
     * 获得请求参数的值为Boolean型(默认返回false)
     * 
     * @param paramName 参数名称
     * @return 参数的值
     */
    public boolean getBooleanValue(String paramName)
    {
        return this.getBooleanValue(paramName, false);
    }

    /**
     * 获得请求参数的值为Boolean型
     * 
     * @param paramName 参数名称
     * @param defaultValue 默认值
     * @return 参数的值
     */
    public boolean getBooleanValue(String paramName, boolean defaultValue)
    {
        if (this.constians(paramName))
        {
            Object value = this.arguments.get(paramName);
            return (null == value ? defaultValue : Boolean.valueOf(value.toString()));
        }
        return defaultValue;
    }

    /**
     * 请求是否包含指定名称的请求参数
     * 
     * @param paramName 参数名称
     * @return 包含指定名称的请求参数返回true, 否则false.
     */
    public boolean constians(String paramName)
    {
        return this.arguments.containsKey(paramName);
    }
}