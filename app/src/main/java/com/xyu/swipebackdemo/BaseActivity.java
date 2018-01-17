package com.xyu.swipebackdemo;


import android.os.Bundle;



/**
 * Created by xiongyu on 2017/11/17.
 */
public abstract  class BaseActivity extends SwipeBackActivity  {

    //设置默认左边右滑返回
    protected MySwipeBackLayout.DragEdge dragEdge=MySwipeBackLayout.DragEdge.LEFT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //处理全面屏
        setTheme(R.style.ThemeSwipeBacknoTranslucent);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if(isSwpeBack()){
            setDragEdge(dragEdge);
        }
    }

    /**
     * 是否需要滑动返回
     * @return
     */
    public abstract boolean isSwpeBack();

    /**
     * 在需要时设置滑动方向
     * @param dragEdge
     */
    protected  void setDragEdgeDirection(MySwipeBackLayout.DragEdge dragEdge) {
        this.dragEdge=dragEdge;
    }

}
