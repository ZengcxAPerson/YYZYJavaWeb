/**
 * 文件名: TreeNodeState.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月7日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.yyzy.common.tree;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月7日
 */
public class TreeNodeState implements ITreeNodeState
{
    /**
     * 默认是否展开
     */
    private boolean opened;
    
    /**
     * 默认是否为不可点击
     */
    private boolean disabled;
    
    /**
     * 默认是否选择
     */
    private boolean selected;
    
    /**
     * 构造函数
     * 
     * @param opened 默认是否展开
     */
    public TreeNodeState(boolean opened)
    {
        this(opened, false);
    }
    
    /**
     * 构造函数
     * 
     * @param opened 默认是否展开
     * @param disabled 默认是否为不可点击
     */
    public TreeNodeState(boolean opened, boolean disabled)
    {
        this(opened, disabled, false);
    }
    
    /**
     * 构造函数
     * 
     * @param opened 默认是否展开
     * @param disabled 默认是否为不可点击
     * @param selected 默认是否选择
     */
    public TreeNodeState(boolean opened, boolean disabled, boolean selected)
    {
        this.opened = opened;
        this.disabled = disabled;
        this.selected = selected;
    }
    
    /**
     * Tree Node State Opened
     * 
     * @return State Opened
     */
    public boolean isOpened()
    {
        return this.opened;
    }
    
    /**
     * Tree Node State Disabled
     * 
     * @return State Disabled
     */
    public boolean isDisabled()
    {
        return this.disabled;
    }
    
    /**
     * Tree Node State Selected
     * 
     * @return State Selected
     */
    public boolean isSelected()
    {
        return this.selected;
    }
}
