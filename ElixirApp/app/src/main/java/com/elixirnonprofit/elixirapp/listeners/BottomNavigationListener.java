package com.elixirnonprofit.elixirapp.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.elixirnonprofit.elixirapp.R;
import com.elixirnonprofit.elixirapp.screens.MainActivity;

/**
 * Created by Falak on 8/25/18.
 */

public class BottomNavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private Activity current;
    private LayoutInflater inflater;
    private LinearLayout parentContainer;

    public BottomNavigationListener(MainActivity current) {
        super();
        this.current = current;
        this.context = current.getApplicationContext();
        inflater = LayoutInflater.from(context);
        parentContainer = new LinearLayout(current);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                inflater.inflate(R.layout.view_home_page, parentContainer, false);
                return true;
            case R.id.navigation_map:
                inflater.inflate(R.layout.view_map, parentContainer, false);
                return true;
            case R.id.navigation_search:
                inflater.inflate(R.layout.view_search, parentContainer, false);
                return true;
        }
        return false;
    }
}