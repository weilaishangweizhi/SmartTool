package com.hollysmart.smarttool.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.StringUtils;
import com.hollysmart.smarttool.R;

public class TextViewDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private String title;
    private String message;
    private String left;         //left 不传   默认 确定
    private String right;

    public TextViewDialog(@NonNull Context context, int themeResId, String title, String message, String left) {
        super(context, themeResId);
        this.mContext = context;
        this.title = title;
        this.message = message;
        this.left = left;
    }

    public TextViewDialog(@NonNull Context context, int themeResId, String title, String message, String left, String right) {
        super(context, themeResId);
        this.mContext = context;
        this.title = title;
        this.message = message;
        this.left = left;
        this.right = right;
    }


    private TextView tv_title;
    private TextView tv_message;

    private TextView tv_left;
    private TextView tv_right;
    private View view_xian;

    private OnClickOkListener onClickOkListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_textview, null);
        setContentView(mView);

        tv_title = mView.findViewById(R.id.tv_title);
        tv_message = mView.findViewById(R.id.tv_message);
        tv_left = mView.findViewById(R.id.tv_left);
        tv_right = mView.findViewById(R.id.tv_right);
        view_xian = mView.findViewById(R.id.view_xian);

        if (StringUtils.isEmpty(title)) {
            tv_title.setVisibility(View.GONE);
        } else {
            tv_title.setText(title);
        }
        if (StringUtils.isEmpty(message)) {
            tv_message.setVisibility(View.GONE);
        } else {
            tv_message.setText(message);
        }

        if (StringUtils.isEmpty(right)) {
            tv_right.setVisibility(View.GONE);
            view_xian.setVisibility(View.GONE);
        } else {
            tv_right.setText(right);
        }


        if (StringUtils.isEmpty(left)) {
            tv_left.setText(R.string.str_sure);
        } else {
            tv_left.setText(left);
        }
        tv_left.setOnClickListener(this);
        tv_right.setOnClickListener(this);
    }

    public void setOnClickOkListener(OnClickOkListener onClickOkListener) {
        this.onClickOkListener = onClickOkListener;
    }

    @Override
    public void onClick(View v) {
        if (onClickOkListener != null) {
            int id = v.getId();
            if (id == R.id.tv_left) {
                onClickOkListener.OnClickOkLeft(v);
            } else if (id == R.id.tv_right) {
                onClickOkListener.OnClickOkRight(v);
            }
        }
        cancel();
    }

    public interface OnClickOkListener {
        void OnClickOkLeft(View view);

        void OnClickOkRight(View view);
    }

}
