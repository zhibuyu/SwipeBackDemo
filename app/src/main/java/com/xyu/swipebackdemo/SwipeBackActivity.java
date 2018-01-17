package com.xyu.swipebackdemo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

/**
 * Created by xiongyu on 17/3/3.
 */
public class SwipeBackActivity extends AppCompatActivity implements MySwipeBackLayout.SwipeBackListener {

    private static final MySwipeBackLayout.DragEdge DEFAULT_DRAG_EDGE = MySwipeBackLayout.DragEdge.NONE;

    private MySwipeBackLayout swipeBackLayout;
    private ImageView ivShadow;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(getContainer());
        View view = getLayoutInflater().inflate(layoutResID, null);
        swipeBackLayout.addView(view);
    }

    private View getContainer() {
        RelativeLayout container = new RelativeLayout(this);
        swipeBackLayout = new MySwipeBackLayout(this);
        swipeBackLayout.setDragEdge(DEFAULT_DRAG_EDGE);
        swipeBackLayout.setOnSwipeBackListener(this);
        swipeBackLayout.setOnFinishCallBackLister(new MySwipeBackLayout.FinishCallBackLister() {
            @Override
            public void HadBack() {
                DragFinsh();
            }
        });
        ivShadow = new ImageView(this);
        ivShadow.setBackgroundColor(getResources().getColor(R.color.black_p50));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        container.addView(ivShadow, params);
        container.addView(swipeBackLayout);
        return container;
    }
    /**
     * 滑动返回后监听
     */
    protected void DragFinsh() {
        finish();
        overridePendingTransition(0, android.R.anim.fade_out);
    }

    /**
     * 是否支持滑动返回
     * @param enableSwipe
     */
    public void setEnableSwipe(boolean enableSwipe) {
        swipeBackLayout.setEnablePullToBack(enableSwipe);
    }

    /**
     * 设置滑动方向
     * @param dragEdge
     */
    public void setDragEdge(MySwipeBackLayout.DragEdge dragEdge) {
        swipeBackLayout.setDragEdge(dragEdge);
    }

    public void setDragDirectMode(MySwipeBackLayout.DragDirectMode dragDirectMode) {
        swipeBackLayout.setDragDirectMode(dragDirectMode);
    }

    public MySwipeBackLayout getSwipeBackLayout() {
        return swipeBackLayout;
    }

    @Override
    public void onViewPositionChanged(float fractionAnchor, float fractionScreen) {
        ivShadow.setAlpha(1 - fractionScreen);
    }

}
