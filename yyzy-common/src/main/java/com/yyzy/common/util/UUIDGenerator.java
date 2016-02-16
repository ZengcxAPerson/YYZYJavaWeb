/**
 * 文件名: UUIDGenerator.java
 * 版 权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月10日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.util;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月10日
 */
public final class UUIDGenerator
{
    private static final int IP;
    private static short counter = (short) 0;
    private static final int JVM = (int) (System.currentTimeMillis() >>> 8);
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static UUIDGenerator instance = null;

    static
    {
        int ipadd;
        try
        {
            ipadd = IptoInt(InetAddress.getLocalHost().getAddress());
        }
        catch (Exception e)
        {
            ipadd = 0;
        }
        IP = ipadd;
    }

    public UUIDGenerator()
    {
    }

    private static int IptoInt(byte[] bytes)
    {
        int result = 0;
        for (int i = 0; i < 4; i++)
        {
            result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }

    /** 
     * Unique across JVMs on this machine (unless they load this class 
     * in the same quater second - very unlikely) 
     */
    protected int getJVM()
    {
        return JVM;
    }

    /** 
     * Unique in a millisecond for this JVM instance (unless there 
     * are > Short.MAX_VALUE instances created in a millisecond) 
     */
    protected short getCount()
    {
        synchronized (UUIDGenerator.class)
        {
            if (counter < 0)
                counter = 0;
            return counter++;
        }
    }

    /** 
     * Unique in a local network 
     */
    protected int getIP()
    {
        return IP;
    }

    /** 
     * Unique down to millisecond 
     */
    protected short getHiTime()
    {
        return (short) (System.currentTimeMillis() >>> 32);
    }

    protected int getLoTime()
    {
        return (int) System.currentTimeMillis();
    }

    protected String format(int intval)
    {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace(8 - formatted.length(), 8, formatted);
        return buf.toString();
    }

    protected String format(short shortval)
    {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace(4 - formatted.length(), 4, formatted);
        return buf.toString();
    }

    public Serializable generate()
    {
        StringBuffer buffer = new StringBuffer(36);
        buffer.append("");
        buffer.append(format(getIP()));
        buffer.append(format(getJVM()));
        buffer.append(format(getHiTime()));
        buffer.append(format(getLoTime()));
        buffer.append(format(getCount()));
        return buffer.toString();
    }
    
    public static Serializable generateUUID()
    {
        if (!initialized.get())
        {
            System.out.println("初始化......");
            UUIDGenerator.instance = new UUIDGenerator();
            initialized.compareAndSet(false, true);
            return UUIDGenerator.instance.generate();
        }
        return UUIDGenerator.instance.generate();
    }
    
    // 压力测试
    public static void main(String[] args)
    {
        for (int i = 0; i < 50; i++)
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for (int i = 0; i < 1000; i++)
                    {
                        System.out.println(UUIDGenerator.generateUUID());
                    }
                }
            }).start();
        }
    }
}