package com.example.android.themeapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

        mContentView.findViewById(R.id.selectableItemBackGround).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "hey", Toast.LENGTH_SHORT).show();
            }
        });
        mContentView.findViewById(R.id.main_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.getTheme().applyStyle(R.style.AppTheme, true);
                reload();
            }
        });
        mContentView.findViewById(R.id.pink_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        mContentView.findViewById(R.id.ripple_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Does not work", Toast.LENGTH_SHORT).show();
//                Drawable drawable=v.getBackground();
//                Resources.Theme currentTheme=mContext.getTheme();
//                currentTheme.applyStyle(R.style.AppTheme_Purple, true);
//                drawable.applyTheme(currentTheme);
//                v.setBackground(drawable);
            }
        });

        ((ViewGroup) mContentView.findViewById(R.id.linear_layout)).addView(new CustomViewA(mContext, null, 0, R.style.AppTheme_Purple));
        return mContentView;
    }

    private void reload() {

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, new MainFragment())
                .commit();
    }
}
