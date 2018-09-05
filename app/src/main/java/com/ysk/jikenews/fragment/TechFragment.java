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

public class TechFragment extends Fragment implements DataCallback {
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_tech, container, false);
        recyclerView = view.findViewById(R.id.tech_recycler_view);
        FragmentNetUtils utils = new FragmentNetUtils(recyclerView,view.getContext(),getActivity(),this);
        if (!utils.isNetworkAvailable(view.getContext())) {
            ToastUtil.showToast(view.getContext(),"请检查网络");
        }
        utils.asyncHttpRequest("keji");
        return view;
    }

    @Override
    public void getData(List<NewsBean.Result.Data> mNewsList) {

    }
}

