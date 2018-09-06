package com.ysk.jikenews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysk.jikenews.R;
import com.ysk.jikenews.activity.DataCallback;
import com.ysk.jikenews.adapter.NewsAdapter;
import com.ysk.jikenews.model.NewsBean;
import com.ysk.jikenews.utils.FragmentNetUtils;
import com.ysk.jikenews.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class FashionFragment extends Fragment implements DataCallback{
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private List tempData = new ArrayList();//定义原来新闻的数据列表
    private  FragmentNetUtils utils;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View onCreateView()创建该fragment对应的视图
        View view = inflater.inflate(R.layout.fragment_fashion, container, false);
        //LayoutInflater类的inflate方法适用于所有需要进行布局填充的场景
        recyclerView = view.findViewById(R.id.fashion_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        adapter = new NewsAdapter(getActivity());//碎片中 recyclerView用活动的适配器
        recyclerView.setAdapter(adapter);
        utils = new FragmentNetUtils(recyclerView, view.getContext(), getActivity(), this);
        //utils.setCallback(this);
        if (!FragmentNetUtils.isNetworkAvailable(view.getContext())) {
            ToastUtil.showToast(view.getContext(), "请检查网络");
        }
        utils.asyncHttpRequest("shishang");

        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh8);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshNews();//新闻刷新
            }
        });
        return view;
    }

    private void refreshNews() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        utils.asyncHttpRequest("shishang");

                    }
                });

            }

        }).start();
    }


    @Override
    public void getData(List<NewsBean.Result.Data> mNewsList) {
        Log.e("数据2", mNewsList.size() + "个数");
        Log.e("adapter2", adapter + "");
        if (null != tempData && tempData.size() > 0) {
            tempData.clear();//第一次请求数据之前，数据为空，请求数据之后，数据不为空，再次请求数据时，把原来数据清空
        }
        this.tempData = mNewsList;
        adapter.setData(tempData);
        swipeRefresh.setRefreshing(false);
    }


}

