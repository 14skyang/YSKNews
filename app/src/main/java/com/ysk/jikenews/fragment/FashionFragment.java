package com.ysk.jikenews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysk.jikenews.R;
import com.ysk.jikenews.activity.DataCallback;
import com.ysk.jikenews.model.NewsBean;
import com.ysk.jikenews.utils.FragmentNetUtils;
import com.ysk.jikenews.utils.ToastUtil;

import java.util.List;

public class FashionFragment extends Fragment implements DataCallback{
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View onCreateView()创建该fragment对应的视图
        View view = inflater.inflate(R.layout.fragment_fashion, container, false);
        //LayoutInflater类的inflate方法适用于所有需要进行布局填充的场景
        recyclerView = view.findViewById(R.id.fashion_recycler_view);
        FragmentNetUtils utils = new FragmentNetUtils(recyclerView,view.getContext(),getActivity(),this);
        if (!FragmentNetUtils.isNetworkAvailable(view.getContext())) {
            ToastUtil.showToast(view.getContext(),"请检查网络");
        }
        utils.asyncHttpRequest("shishang");
        return view;
    }

    @Override
    public void getData(List<NewsBean.Result.Data> mNewsList) {

    }
}

