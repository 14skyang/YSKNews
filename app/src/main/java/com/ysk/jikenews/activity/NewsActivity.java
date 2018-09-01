package com.ysk.jikenews.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ysk.jikenews.BaseActivity;
import com.ysk.jikenews.R;
import com.ysk.jikenews.adapter.TestNewsAdapter;
import com.ysk.jikenews.model.Result;
import com.ysk.jikenews.utils.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends BaseActivity {

    private RecyclerView news_recyclerView;

    private List<Result> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initData();
    }

    public void initData() {
        TestUtil util = new TestUtil();
        util.sendRequestWithOkHttp();
        resultList = TestUtil.resultList;
//        Log.d("first title", newsList.get(0).getTitle().toString());
        showResponse(resultList);
    }

    public void showResponse(final List<Result> newsList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //进行UI线程的操作
                news_recyclerView = findViewById(R.id.pyq_recyclerview);
                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                news_recyclerView.setLayoutManager(manager);
                news_recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
                TestNewsAdapter adapter = new TestNewsAdapter(newsList);
                news_recyclerView.setAdapter(adapter);
                Log.d("run", "run: ");
            }
        });
    }





}
