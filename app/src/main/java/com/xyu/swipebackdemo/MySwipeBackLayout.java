package com.xyu.swipebackdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 处理viewPager滑动兼容问题
 * Created by xiongyu on 2017/11/17.
 */
public class MySwipeBackLayout extends SwipeBackLayout {
    private float startY;
    private float startX;
    // 记录viewPager是否拖拽的标记
    private boolean mIsVpDragger;
    private int mTouchSlop;

    public MySwipeBackLayout(Context context) {
        super(context);
    }

    public MySwipeBackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setDragEdge(DragEdge.LEFT);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
// 记录手指按下的位置
                startY = ev.getY();
                startX = ev.getX();
// 初始化标记
                mIsVpDragger = false;
                break;
            case MotionEvent.ACTION_MOVE:
// 如果viewpager正在拖拽中，那么不拦截它的事件，直接return false；
                if (mIsVpDragger) {
                    return false;
                }
// 获取当前手指位置
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - startX);
                float distanceY = Math.abs(endY - startY);
// 如果X轴位移大于Y轴位移，那么将事件交给viewPager处理。
/*if(distanceX > mTouchSlop && distanceX > distanceY) {
                mIsVpDragger = true;
                return false;
            }*/
                if (distanceY > mTouchSlop && distanceY > distanceX) {
                    mIsVpDragger = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
// 初始化标记
                mIsVpDragger = false;
                break;
        }
// 如果是Y轴位移大于X轴，事件交给SwipeBackLayout处理。
        return super.onInterceptTouchEvent(ev);
    }
}
