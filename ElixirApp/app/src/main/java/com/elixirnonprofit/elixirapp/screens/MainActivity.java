package com.elixirnonprofit.elixirapp.screens;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.elixirnonprofit.elixirapp.R;
import com.elixirnonprofit.elixirapp.listeners.BottomNavigationListener;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener = new BottomNavigationListener(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(listener);
    }

}
