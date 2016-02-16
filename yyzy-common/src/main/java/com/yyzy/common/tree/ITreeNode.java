/**
 * 文件名: ITreeNode.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月7日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.tree;

import java.util.Map;

/**
 * <p>功能描述：树节点接口</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月7日
 */
public interface ITreeNode
{
    /**
     * TreeNode ID
     * 
     * @return TreeNode ID
     */
    public String getId();
    
    /**
     * TreeNode Text
     * 
     * @return TreeNode Text
     */
    public String getText();
    
    /**
     * TreeNode Icon
     * 
     * @return TreeNode Icon
     */
    public String getIcon();
    
    /**
     * TreeNode Type
     * 
     * @return TreeNode Type
     */
    public String getType();
    
    /**
     * TreeNode State
     * 
     * @return TreeNode State
     */
    public ITreeNodeState getState();
    
    /**
     * 是否有儿子
     * @return 有儿子true, 否则false
     */
    public Object getChildren();
    
    /**
     * 获得LI标签的属性
     * 
     * @return LI标签的属性
     */
    public Map<String, String> getLi_attr();
    
    /**
     * 获得A标签属性
     * 
     * @return A标签属性
     */
    public Map<String, String> getA_attr();
}
