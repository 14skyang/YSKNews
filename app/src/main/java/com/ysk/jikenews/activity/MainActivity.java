package com.ysk.jikenews.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysk.jikenews.BaseActivity;
import com.ysk.jikenews.R;
import com.ysk.jikenews.adapter.MyFragmentPagerAdapter;
import com.ysk.jikenews.utils.ToastUtil;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;

//    private SwipeRefreshLayout swipeRefresh;    //下拉刷新

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private MyFragmentPagerAdapter pagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private TabLayout.Tab five;
    private TabLayout.Tab six;
    private TabLayout.Tab seven;
    private TabLayout.Tab eight;
    private TabLayout.Tab nine;
    private TabLayout.Tab ten;

    private ImageView header_bg;

    private TextView username_txt;

    private TextView email_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initViews();

    }
    private void initViews() {

        //使用适配器将viewPager和fragment绑定在一起
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //将tabLayout和viewPager绑定在一起
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        //指定Tab的位置
        one = tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(2);
        four = tabLayout.getTabAt(3);
        five = tabLayout.getTabAt(4);
        six = tabLayout.getTabAt(5);
        seven = tabLayout.getTabAt(6);
        eight = tabLayout.getTabAt(7);
        nine = tabLayout.getTabAt(8);
        ten = tabLayout.getTabAt(9);
        //设置Tab的图标
//        one.setIcon(R.mipmap.ic_launcher);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

    }
    private boolean isAppInstalled(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
    private void refreshNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); //由于刷新非常快，马上就结束了需要将线程沉睡两秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                swipeRefresh.setRefreshing(false);
            }
        });
    }

}

