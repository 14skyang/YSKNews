package com.ysk.jikenews.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ysk.jikenews.BaseActivity;
import com.ysk.jikenews.R;
import com.ysk.jikenews.adapter.MyFragmentPagerAdapter;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;

//    private SwipeRefreshLayout swipeRefresh;    //下拉刷新


    private TabLayout tabLayout;

    private ViewPager viewPager;
   /* Viewpager使用起来就是通过创建adapter给它填充多个view，左右滑动时，切换不同的view。
    Google官方是建议我们使用Fragment来填充ViewPager的，这样 可以更加方便的生成每个Page，
    以及管理每个Page的生命周期*/
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
   // TabLayout配合着ViewPager和Fragment的使用，TabLayout可以打造一个滑动标签页，非常方便

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
        ActionBar actionBar = getSupportActionBar();//getSupportActionBar()一定要在setSupportActionBar(Toolbar toolbar)之后调用
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//隐藏actionbar
        }

    }

   /* private boolean isAppInstalled(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean installed;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }*/
    /*private void refreshNews() {
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
    }*/

}

