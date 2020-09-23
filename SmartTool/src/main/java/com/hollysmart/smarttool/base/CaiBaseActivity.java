package com.hollysmart.smarttool.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hollysmart.smarttool.R;
import com.hollysmart.smarttool.statusbar.StatusBarUtil;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;


public abstract class CaiBaseActivity extends AppCompatActivity implements View.OnClickListener, BGASwipeBackHelper.Delegate{
    public Context mContext;
    public int animType;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSwipeBackFinish();
        mContext = this;
        if (savedInstanceState != null) {
            animType = savedInstanceState.getInt("animType");
        }
        animType = getIntent().getIntExtra("animType", 0);

        setContentView(layoutResID());
        //这里注意下 调用setRootViewFitsSystemWindows 里面 winContent.getChildCount()=0 导致代码无法继续
        //是因为你需要在setContentView之后才可以调用 setRootViewFitsSystemWindows
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this,false);

        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);

        findView();
        init();
    }

    /**
     * layout绑定
     */
    public abstract int layoutResID();

    /**
     * 控件绑定
     */
    public abstract void findView();

    /**
     * 逻辑操作
     */
    public abstract void init();

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    protected BGASwipeBackHelper mSwipeBackHelper;
    private void initSwipeBackFinish() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);
        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 ktrue
        mSwipeBackHelper.setIsWeChatStyle(true);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        mSwipeBackHelper.setIsNavigationBarOverlap(false);
    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *
     * @return
     */
    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }
    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }
    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @Override
    public void onSwipeBackLayoutCancel() {
    }
    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }



    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        animEnter(intent.getIntExtra("animType", 0));
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        animEnter(intent.getIntExtra("animType", 0));
    }

    @Override
    public void finish() {
        super.finish();
        animExit();
    }
    private void animEnter(int animType){
        switch (animType) {
            case 1:
                overridePendingTransition(R.anim.activity_enter_shang, R.anim.activity_yuandian);
                break;
            case 2:
                overridePendingTransition(R.anim.activity_enter_xia, R.anim.activity_yuandian);
                break;
            case 3:
                overridePendingTransition(R.anim.activity_enter_left, R.anim.activity_yuandian);
                break;
            case 4:
                overridePendingTransition(R.anim.activity_enter_right, R.anim.activity_yuandian);
                break;
            case 5:
                overridePendingTransition(R.anim.activity_enter_soufang, R.anim.activity_yuandian);
                break;
            case 6:
                overridePendingTransition(R.anim.activity_enter_long_left, R.anim.activity_yuandian);
                break;
            case 7:
                overridePendingTransition(R.anim.activity_enter_long_right, R.anim.activity_yuandian);
                break;
        }
    }

    private void animExit(){
        switch (animType) {
            case 1:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_shang);
                break;
            case 2:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_xia);
                break;
            case 3:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_left);
                break;
            case 4:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_right);
                break;
            case 5:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_soufang);
                break;
            case 6:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_long_left);
                break;
            case 7:
                overridePendingTransition(R.anim.activity_yuandian, R.anim.activity_exit_long_right);
                break;
        }
    }








}









