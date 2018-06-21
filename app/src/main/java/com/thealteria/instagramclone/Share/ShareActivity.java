package com.thealteria.instagramclone.Share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.thealteria.instagramclone.R;
import com.thealteria.instagramclone.Utils.BottomNavViewHelper;

public class ShareActivity extends AppCompatActivity {
    private static final String TAG = "ShareActivity";
    private static final int ACTIVITY_NUM = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "oCreate: started");

        setupBottomNavView();

    }

    private void setupBottomNavView() {

        Log.d(TAG, "setupNavView: Setting Up BottomNavView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottoNav);
        BottomNavViewHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavViewHelper.enableNavigation(ShareActivity.this, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_NUM);
        item.setChecked(true);
    }
}
