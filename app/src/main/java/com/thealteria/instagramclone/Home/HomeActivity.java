package com.thealteria.instagramclone.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.thealteria.instagramclone.R;
import com.thealteria.instagramclone.Utils.BottomNavViewHelper;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "BottomNavHel";
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupBottomNavView();
        setupViewPager();
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment()); //index 0
        adapter.addFragment(new HomeFragment()); // index 1
        adapter.addFragment(new MessagesFragment()); // index 2

        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setText("Instagram");
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_arrow);
    }

    private void setupBottomNavView() {

        Log.d(TAG, "setupNavView: Setting Up BottomNavView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottoNav);
        BottomNavViewHelper.setupBottomNavView(bottomNavigationViewEx);
        BottomNavViewHelper.enableNavigation(HomeActivity.this, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_NUM);
        item.setChecked(true);
    }
}
