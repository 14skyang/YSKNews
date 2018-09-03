package com.ysk.jikenews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ysk.jikenews.fragment.DomesticFragment;
import com.ysk.jikenews.fragment.EntertainFragment;
import com.ysk.jikenews.fragment.FashionFragment;
import com.ysk.jikenews.fragment.FinacialFragment;
import com.ysk.jikenews.fragment.InterFragment;
import com.ysk.jikenews.fragment.MilitaryFragment;
import com.ysk.jikenews.fragment.SocialFragment;
import com.ysk.jikenews.fragment.SportsFragment;
import com.ysk.jikenews.fragment.TechFragment;
import com.ysk.jikenews.fragment.ToutiaoFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles = {"头条","科技","国内","国际","体育","娱乐","财经","时尚","军事","社会",};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ToutiaoFragment();
        } else if (position == 1) {
            return new TechFragment();
        } else if (position == 2) {
            return new DomesticFragment();
        } else if (position == 3) {
            return new InterFragment();
        } else if (position == 4) {
            return new SportsFragment();
        } else if (position == 5) {
            return new EntertainFragment();
        } else if (position == 6) {
            return new FinacialFragment();
        } else if (position == 7) {
            return new FashionFragment();
        } else if (position == 8) {
            return new MilitaryFragment();
        } else if (position == 9) {
            return new SocialFragment();
        }

        return new SocialFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    } //返回标题长度

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }//返回标题位置
}

