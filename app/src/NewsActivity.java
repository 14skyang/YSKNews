package com.ysk.jikenews.activity;

import android.os.Bundle;

import com.ysk.jikenews.BaseActivity;
import com.ysk.jikenews.R;


public class NewsActivity extends BaseActivity {

   // private RecyclerView news_recyclerView;

  //  private List<Result> resultList = new ArrayList<>();
    /*一个List里放入的是Result对象，List是一个集合接口 ，ArrayList是实现了List接口的一个类
    ArrayList继承并实现了List。所以List不能被构造，但可以向上面那样为List创建一个引用，而ArrayList就可以被构造。*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //initData();
    }

   /* public void initData() {
        TestUtil util = new TestUtil();
        util.sendRequestWithOkHttp();
        resultList = TestUtil.resultList;
//        Log.d("first title", newsList.get(0).getTitle().toString());
        showResponse(resultList);
    }*/

   /* public void showResponse(final List<Result> newsList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //进行UI线程的操作
                news_recyclerView = findViewById(R.id.pyq_recyclerview);
                LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
                news_recyclerView.setLayoutManager(manager);
                news_recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
               // TestNewsAdapter adapter = new TestNewsAdapter(newsList);
              //  news_recyclerView.setAdapter(adapter);
                Log.d("run", "run: ");
            }
        });
    }*/





}
