package com.example.android.themeapp2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainFragment extends Fragment {

    private Context mContext;
    private View mContentView;
    private int mThemeRes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        Bundle args = getArguments();
        mThemeRes = savedInstanceState != null ? savedInstanceState.getInt("THEME", R.style.AppTheme) : args != null ? args.getInt("THEME") : R.style.AppTheme;
        Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "mThemeRes " + mThemeRes + " this " + this);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), mThemeRes);
//        Resources.Theme theme = contextThemeWrapper.getTheme();
//        theme.applyStyle(mThemeRes, true);

        LayoutInflater cloneInflater = inflater.cloneInContext(contextThemeWrapper);
        mContentView = cloneInflater.inflate(R.layout.fragment_main, container, false);

        mContentView.findViewById(R.id.selectableItemBackGround).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "hey", Toast.LENGTH_SHORT).show();
            }
        });
        mContentView.findViewById(R.id.selectableItemBackGroundCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "hey", Toast.LENGTH_SHORT).show();
            }
        });
        mContentView.findViewById(R.id.main_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.getTheme().applyStyle(R.style.AppTheme, true);
                mThemeRes = R.style.AppTheme;
                reload(mThemeRes);
            }
        });
        mContentView.findViewById(R.id.pink_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.getTheme().applyStyle(R.style.AppTheme_Pink, true);
                mThemeRes = R.style.AppTheme_Pink;
                reload(mThemeRes);
            }
        });
        mContentView.findViewById(R.id.yellow_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.getTheme().applyStyle(R.style.AppTheme_Yellow, true);
                mThemeRes = R.style.AppTheme_Yellow;
                reload(mThemeRes);
            }
        });
        mContentView.findViewById(R.id.ripple_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Does not work
//                Drawable drawable = v.getBackground();
//                Resources.Theme currentTheme = mContext.getTheme();
//                currentTheme.applyStyle(R.style.AppTheme_Purple, true);
//                drawable.applyTheme(currentTheme);
//                v.setBackground(drawable);

                //Remove view and add view from the container
                TextView selectableItemBackGround = (TextView) mContentView.findViewById(R.id.selectableItemBackGround);
                ViewGroup selectableItemBackGroundContainer = (ViewGroup) mContentView.findViewById(R.id.selectableItemBackGroundContainer);
                selectableItemBackGroundContainer.removeView(selectableItemBackGround);
                selectableItemBackGround = new TextView(mContext, null, 0, R.style.SelectableItemBackGroundStyle);
                selectableItemBackGround.setText("TextView with selectable item background homemade inflated when inflating view");
                selectableItemBackGround.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                selectableItemBackGround.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "hey", Toast.LENGTH_SHORT).show();
                    }
                });
                selectableItemBackGroundContainer.addView(selectableItemBackGround);


                TextView selectableItemBackGroundDefaultInflated = (TextView) mContentView.findViewById(R.id.selectableItemBackGroundDefaultInflated);
                Resources.Theme currentTheme = mContext.getTheme();
                currentTheme.applyStyle(R.style.AppTheme_Yellow, true);
                selectableItemBackGroundDefaultInflated.setBackground(mContext.getResources().getDrawable(getResDrawable(R.attr.selectableItemBackground), currentTheme));
                //selectableItemBackGroundDefaultInflated.setBackground(mContext.getResources().getDrawable(R.drawable.selectable_item_background_color, currentTheme));
                selectableItemBackGroundDefaultInflated.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "hey", Toast.LENGTH_SHORT).show();
                    }
                });

                TextView selectableItemBackGroundHomemadeInflated = (TextView) mContentView.findViewById(R.id.selectableItemBackGroundHomemadeInflated);
                selectableItemBackGroundHomemadeInflated.setBackground(mContext.getResources().getDrawable(R.drawable.selectable_item_background_color));
                selectableItemBackGroundHomemadeInflated.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "hey", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        ((ViewGroup) mContentView.findViewById(R.id.linear_layout)).addView(new CustomViewA(mContext, null, 0, R.style.AppTheme_Purple));
        return mContentView;
    }

    private int getResDrawable(int drawableThemeAttr) {
        int[] drawableAttr = new int[] {drawableThemeAttr};
        int indexOfdrawableAttr = 0;
        TypedValue typedValue = new TypedValue();
        TypedArray a = getContext().obtainStyledAttributes(typedValue.data, drawableAttr);
        int drawableRes =a.getResourceId(indexOfdrawableAttr, -1);
        a.recycle();
        return drawableRes;
    }

    private void reload(int mThemeRes) {
        Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "mThemeRes " + mThemeRes);
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME", mThemeRes);
        mainFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, mainFragment)
                .commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Nebo", Thread.currentThread().getStackTrace()[2] + "mThemeRes " + mThemeRes);
        outState.putInt("THEME", mThemeRes);
    }
}
