package com.yyzy.dao.base;

import com.yyzy.common.exception.ContextRuntimeException;

public interface DAO
{

    /**
     * 保存对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object save(String str, Object obj) throws ContextRuntimeException;

    /**
     * 修改对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object update(String str, Object obj) throws ContextRuntimeException;

    /**
     * 删除对象 
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object delete(String str, Object obj) throws ContextRuntimeException;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForObject(String str, Object obj) throws ContextRuntimeException;

    /**
     * 查找对象
     * @param str
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForList(String str, Object obj) throws ContextRuntimeException;

    /**
     * 查找对象封装成Map
     * @param obj
     * @return
     * @throws Exception
     */
    public Object findForMap(String sql, Object obj, String key, String value) throws ContextRuntimeException;

}
