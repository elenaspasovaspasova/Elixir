package com.elixirnonprofit.elixirapp.screens;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.elixirnonprofit.elixirapp.R;
import com.elixirnonprofit.elixirapp.listeners.BottomNavigationListener;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private BottomNavigationListener listener;
    private FrameLayout content;
    private int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateWithCorrectDimensions();
        setNavigationListener();
    }

    private void inflateWithCorrectDimensions() {
        Resources resources = getApplicationContext().getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int resourceSize = resources.getDimensionPixelSize(resourceId);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        screenHeight = height - (int)((resourceSize * displayMetrics.density + 0.5) + 30);
        content = (FrameLayout) findViewById(R.id.main_app_content);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) content.getLayoutParams();
        params.height = screenHeight;
        content.setLayoutParams(params);
    }

    private void setNavigationListener() {
        listener = new BottomNavigationListener(this);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(listener);
    }

}
