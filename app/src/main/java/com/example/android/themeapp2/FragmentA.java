package com.example.android.themeapp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), R.style.AppTheme);
        contextThemeWrapper.getTheme().applyStyle(R.style.AppTheme_Purple, true);
        contextThemeWrapper.setTheme(R.style.AppTheme_Purple);
        LayoutInflater fragmentAInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = fragmentAInflater.inflate(R.layout.fragment_a, container);
        return view;
    }
}
