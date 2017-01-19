package com.example.android.themeapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    private Context mContext;
    private View mContentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        mContext.getTheme().applyStyle(R.style.AppTheme_Pink, true);
        mContentView = inflater.inflate(R.layout.fragment_main, container);
        Log.e("App", Thread.currentThread().getStackTrace()[2]+"who is parent of contentView "+mContentView);

        mContentView.findViewById(R.id.main_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContentView.invalidate();
                //mContext.getTheme().applyStyle(R.style.AppTheme, true);
                ViewGroup parent = (ViewGroup) mContentView.getParent();
                Log.e("App", Thread.currentThread().getStackTrace()[2]+"contentView "+parent);
                parent.removeAllViews();
                ContextThemeWrapper contextThemeWrapper=new ContextThemeWrapper(mContext, R.style.AppTheme);
                contextThemeWrapper.getTheme().applyStyle(R.style.AppTheme, true);
                contextThemeWrapper.setTheme(R.style.AppTheme);
                LayoutInflater mainInflater = inflater.cloneInContext(contextThemeWrapper);
                parent.addView(mainInflater.inflate(R.layout.fragment_main, container));
            }
        });
        mContentView.findViewById(R.id.pink_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContentView.invalidate();
                //mContext.getTheme().applyStyle(R.style.AppTheme_Pink, true);
                ViewGroup parent = (ViewGroup) mContentView.getParent();
                Log.e("App", Thread.currentThread().getStackTrace()[2]+"contentView "+parent);
                parent.removeAllViews();
                ContextThemeWrapper contextThemeWrapper=new ContextThemeWrapper(mContext, R.style.AppTheme_Pink);
                contextThemeWrapper.getTheme().applyStyle(R.style.AppTheme_Pink, true);
                contextThemeWrapper.setTheme(R.style.AppTheme_Pink);
                LayoutInflater pinkInflater = inflater.cloneInContext(contextThemeWrapper);
                parent.addView(pinkInflater.inflate(R.layout.fragment_main, container));
            }
        });
        mContentView.findViewById(R.id.yellow_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContentView.invalidate();
                //mContext.getTheme().applyStyle(R.style.AppTheme_Yellow, true);
                ViewGroup parent = (ViewGroup) mContentView.getParent();
                Log.e("App", Thread.currentThread().getStackTrace()[2]+"contentView "+parent);
                parent.removeAllViews();
                ContextThemeWrapper contextThemeWrapper=new ContextThemeWrapper(mContext, R.style.AppTheme_Yellow);
                contextThemeWrapper.getTheme().applyStyle(R.style.AppTheme_Yellow, true);
                LayoutInflater yellowInflater = inflater.cloneInContext(contextThemeWrapper);
                contextThemeWrapper.setTheme(R.style.AppTheme_Yellow);
                parent.addView(yellowInflater.inflate(R.layout.fragment_main, container));
            }
        });
        return mContentView;
    }
}
