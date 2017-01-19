package com.example.android.themeapp2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


public class CustomViewA extends TextView {

    public CustomViewA(Context context) {
        super(context);
    }

    public CustomViewA(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.customViewStyle);
    }

    public CustomViewA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomViewA(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
