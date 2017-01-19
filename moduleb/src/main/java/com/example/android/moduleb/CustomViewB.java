package com.example.android.moduleb;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


public class CustomViewB extends TextView {

    public CustomViewB(Context context) {
        super(context);
    }

    public CustomViewB(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.customViewBStyle);
    }

    public CustomViewB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
