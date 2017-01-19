package com.example.android.themeapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
        mContentView = inflater.inflate(R.layout.fragment_main, container, false);
        mContentView.findViewById(R.id.main_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.getTheme().applyStyle(R.style.AppTheme, true);
                reload();
//                ViewGroup parent = (ViewGroup) mContentView.getParent();
//                Log.e("App", Thread.currentThread().getStackTrace()[2]+"contentView "+parent);
//                parent.removeAllViews();
//                ContextThemeWrapper contextThemeWrapper=new ContextThemeWrapper(mContext, R.style.AppTheme);
//                contextThemeWrapper.getTheme().applyStyle(R.style.AppTheme, true);
//                contextThemeWrapper.setTheme(R.style.AppTheme);
//                LayoutInflater mainInflater = inflater.cloneInContext(contextThemeWrapper);
//                parent.addView(mainInflater.inflate(R.layout.fragment_main, container));
            }
        });
        mContentView.findViewById(R.id.pink_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContentView.invalidate();
                mContext.getTheme().applyStyle(R.style.AppTheme_Pink, true);
                reload();
           }
        });
        mContentView.findViewById(R.id.yellow_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.getTheme().applyStyle(R.style.AppTheme_Yellow, true);
                reload();
            }
        });
        return mContentView;
    }

    private void reload() {

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, new MainFragment())
                .commit();
    }
}
