package com.weidi.jijeng.weidi.choose;

/**
 * Created by Administrator on 2015/8/20.
 */
public interface AbOnScrollListener {

    /**
     * 滚动.
     * @param arg1 返回参数
     */
    public void onScroll(int arg1);

    /**
     * 滚动停止.
     */
    public void onScrollStoped();

    /**
     * 滚到了最左边.
     */
    public void onScrollToLeft();

    /**
     * 滚到了最右边.
     */
    public void onScrollToRight();

}
