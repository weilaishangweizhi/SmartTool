package com.hollysmart.smarttooldemo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.hollysmart.smarttool.base.CaiBaseActivity;
import com.hollysmart.smarttool.utils.CaiUtils;
import com.hollysmart.smarttool.value.Value;

public class MainActivity extends CaiBaseActivity {

    @Override
    public int layoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public boolean setTranslucent() {
        return true;
    }

    @Override
    public void findView() {
        findViewById(R.id.bn_one).setOnClickListener(this);
        findViewById(R.id.bn_two).setOnClickListener(this);
        findViewById(R.id.bn_three).setOnClickListener(this);
        findViewById(R.id.bn_four).setOnClickListener(this);
        findViewById(R.id.bn_five).setOnClickListener(this);
        findViewById(R.id.bn_six).setOnClickListener(this);
        findViewById(R.id.bn_seven).setOnClickListener(this);
    }

    @Override
    public void init() {

    }

    @Override
    public void onClick(View v) {
        if (CaiUtils.isFastClick()) {
            return;
        }
        Intent intent = new Intent(mContext, TestActivity.class);
        switch (v.getId()){
            case R.id.bn_one:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_SHANG);
                startActivity(intent);
                break;
            case R.id.bn_two:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_XIA);
                startActivity(intent);
                break;
            case R.id.bn_three:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_LEFT);
                startActivity(intent);
                break;
            case R.id.bn_four:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_RIGHT);
                startActivity(intent);
                break;
            case R.id.bn_five:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_SUOFANG);
                startActivity(intent);
                break;
            case R.id.bn_six:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_LONG_LEFT);
                startActivity(intent);
                break;
            case R.id.bn_seven:
                intent.putExtra(Value.ANIM_TYPE, Value.ANIM_TYPE_LONG_RIGHT);
                startActivity(intent);
                break;
        }
    }
}









