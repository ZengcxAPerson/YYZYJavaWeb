/**
 * 文件名: ITreeNodeState.java
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
 * <p>功能描述：树节点状态</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月7日
 */
public interface ITreeNodeState
{
    /**
     * Tree Node State Opened
     * 
     * @return State Opened
     */
    public boolean isOpened();
    
    /**
     * Tree Node State Disabled
     * 
     * @return State Disabled
     */
    public boolean isDisabled();
    
    /**
     * Tree Node State Selected
     * 
     * @return State Selected
     */
    public boolean isSelected();
}