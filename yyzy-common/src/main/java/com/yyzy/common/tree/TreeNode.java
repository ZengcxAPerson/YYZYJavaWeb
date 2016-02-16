/**
 * 文件名: TreeNode.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月7日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月7日
 */
public class TreeNode implements ITreeNode
{
    /**
     * TreeNode ID
     */
    private final String id;
    
    /**
     * TreeNode Text
     */
    private final String text;
    
    /**
     * TreeNode Icon
     */
    private String icon;
    
    /**
     * TreeNode Type
     */
    private String type;
    
    /**
     * TreeNode State
     */
    private ITreeNodeState state;
    
    /**
     * TreeNode has been Children default no Children.
     */
    private Collection<ITreeNode> children;
    
    /**
     * 是否有儿子
     */
    private boolean child = false;
    
    /**
     * LI标签的属性
     */
    private Map<String, String> liattr;
    
    /**
     * A标签的属性
     */
    private Map<String, String> aattr;
    
    /**
     * 构造函数
     * 
     * @param id TreeNode ID
     * @param text TreeNode Text
     */
    public TreeNode(String id, String text)
    {
        this.id = id;
        this.text = text;
        this.children = new ArrayList<ITreeNode>();
        this.liattr = new HashMap<String, String>();
        this.aattr = new HashMap<String, String>();
    }
    
    /**
     * TreeNode ID
     * 
     * @return TreeNode ID
     */
    public String getId()
    {
        return this.id;
    }
    
    /**
     * TreeNode Text
     * 
     * @return TreeNode Text
     */
    public String getText()
    {
        return this.text;
    }
    
    /**
     * TreeNode Icon
     * 
     * @return TreeNode Icon
     */
    public String getIcon()
    {
        return this.icon;
    }
    
    /**
     * TreeNode Icon
     * 
     * @param icon TreeNode Icon
     */
    public void setIcon(String icon)
    {
        this.icon = icon;
    }
    
    /**
     * TreeNode Type
     * 
     * @return TreeNode Type
     */
    public String getType()
    {
        return this.type;
    }
    
    /**
     * TreeNode Type
     * 
     * @param type TreeNode Type
     */
    public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * TreeNode State
     * 
     * @return TreeNode State
     */
    public ITreeNodeState getState()
    {
        return this.state;
    }
    
    /**
     * TreeNode State
     * 
     * @param state TreeNode State
     */
    public void setState(ITreeNodeState state)
    {
        this.state = state;
    }
    
    /**
     * 是否有儿子
     * @return 有儿子true, 否则false
     */
    public Object getChildren()
    {
        return this.child ? child : this.children;
    }
    
    /**
     * TreeNode has Children set for true, otherwise set for false.
     * 
     * @param children TreeNode has Children
     */
    public void setChildren(Collection<ITreeNode> children)
    {
        this.children = children;
    }
    
    /**
     * TreeNode has Children set for true, otherwise set for false.
     * 
     * @param children TreeNode has Children
     */
    public void addChild(ITreeNode child)
    {
        this.children.add(child);
    }
    
    /**
     * TreeNode has Children set for true, otherwise set for false.
     * 
     * @param children TreeNode has Children
     */
    public void addChild(Collection<ITreeNode> children)
    {
        this.children.addAll(children);
    }
    
    /**
     * Children set for true, otherwise set for false.
     * 
     * @param child TreeNode has Children
     */
    public void setChild(boolean child)
    {
        this.child = child;
    }

    /**
     * 获得LI标签的属性
     * 
     * @return LI标签的属性
     */
    public Map<String, String> getLi_attr()
    {
        return this.liattr;
    }
    
    /**
     * 添加LI属性名称和值
     * 
     * @param key LI属性名称
     * @param value LI属性值
     */
    public void putLiattr(String key, String value)
    {
        this.liattr.put(key, value);
    }
    
    /**
     * 获得A标签属性
     * 
     * @return A标签属性
     */
    public Map<String, String> getA_attr()
    {
        return this.aattr;
    }
    
    /**
     * 添加A属性名称和值
     * 
     * @param key A属性名称
     * @param value A属性值
     */
    public void putAattr(String key, String value)
    {
        this.liattr.put(key, value);
    }
}