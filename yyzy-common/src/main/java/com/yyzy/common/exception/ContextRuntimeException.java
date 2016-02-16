/**
 * 文件名: ContextRuntimeException.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月5日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.exception;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月5日
 */
public class ContextRuntimeException extends RuntimeException
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5494027282102464910L;

    /**
     * Error Code Message Parameters
     */
    private Object[] parameters;
    
    /**
     * Error Code
     */
    private String errorCode;
    
    /**
     * Current Message
     */
    private String currentMessage;
    
    /**
     * Constructor
     * 
     * @param message Error Message Description
     */
    public ContextRuntimeException(String message)
    {
        super(message);
        this.currentMessage = message;
    }
    
    /**
     * Constructor
     * 
     * @param message Error Message Description
     * @param cause Exception Cause
     */
    public ContextRuntimeException(String message, Throwable cause)
    {
        super(message, cause);
        this.currentMessage = message;
    }
    
    /**
     * Constructor
     * 
     * @param message Error Message Description
     * @param cause Exception Cause
     * @param errorCode Error Code
     * @param parameters Error Code Message Parameters
     */
    public ContextRuntimeException(String message, Throwable cause, String errorCode, Object[] parameters)
    {
        super(message, cause);
        this.errorCode = errorCode;
        this.parameters = parameters;
        this.currentMessage = message;
    }
    
    /**
     * Gain Error Message
     * 
     * @return Error Message
     */
    public String getErrorCodeMessage()
    {
        //TODO
        if (ArrayUtils.isEmpty(this.parameters))
        {
            return this.currentMessage;
        }
        return this.currentMessage + Arrays.toString(this.parameters);
    }
    
    /**
     * Gain Message
     * 
     * @return Exception Description Message
     */
    public String getMessage()
    {
        StringBuilder msg = new StringBuilder();
        String message = super.getMessage();
        if (StringUtils.isNotBlank(message))
        {
            msg.append(message);
        }
        if (StringUtils.isNotEmpty(getErrorCode()))
        {
            msg.append(getErrorCodeMessage());
        }
        return msg.toString();
    }
    
    /**
     * Gain Error Code
     * 
     * @return Error Code
     */
    public String getErrorCode()
    {
        return errorCode;
    }
}