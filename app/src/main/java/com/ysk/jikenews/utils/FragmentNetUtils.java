package com.ysk.jikenews.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.ysk.jikenews.activity.DataCallback;
import com.ysk.jikenews.adapter.NewsAdapter;
import com.ysk.jikenews.model.NewsBean;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentNetUtils {

    private static final String TAG = ">>>>>>FragmentNetUtils";//方便后面打印信息

    private RecyclerView recyclerView;

    private Context context;

    private Activity activity;

    private DataCallback callback;

    public void setCallback(DataCallback callback) {
        this.callback = callback;
    }

    public FragmentNetUtils(RecyclerView recyclerView, Context context, Activity activity,DataCallback callback) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.activity = activity;
        this.callback  = callback;
    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @return true 表示网络可用
     */
    public static boolean isNetworkAvailable(Context context1) {//安卓内置检测网络
        ConnectivityManager connectivity = (ConnectivityManager) context1
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;//true是布尔型数据
                }
            }
        }
        return false;
    }

    public void asyncHttpRequest(String type){ //利用okhttp3库的网络请求
        Log.i(TAG, "加载到asyncHttpRequest()");
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://v.juhe.cn/toutiao/index?type="+type+"&key=57fc7628decb7944e5ba5b92b8370eca")
                //.url("http://v.juhe.cn/toutiao/index?type="+type+"&key=ab98c33f42434cc684bb9512bee5249a")
                .build();
        okhttp3.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtil.showToast(context,"新闻加载失败");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // Log.d(TAG, "请求成功");
                // Log.d(">>>onResponse>>>当前线程", Thread.currentThread().getName());
                final String responseData = response.body().string();
                 Log.d(TAG, responseData);//打印接收到的json数据
                parseData(responseData);
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ToastUtil.showToast(activity,"成功获取数据");
//                    }
//                });
            }
        });
    }

    public void parseData(String responseData) {//通过谷歌官方的解析库Gson来解析成我们要的格式，这里解析成了一个List
        //  Log.i(TAG, "加载到parseData()");
        Gson gson = new Gson();
        NewsBean newsBean = gson.fromJson(responseData, NewsBean.class);//解析json数据
        NewsBean.Result result = newsBean.result;
        final List<NewsBean.Result.Data> datas = result.data;
        // Log.d(">>>>>>>解析的标题：", datas.get(0).getTitle().toString());
        showResponse(datas);
    }//已经获取到我们想要的全部数据了，接下来就是放进界面的过程，即放入RecyclerView，需要一个自定义NewsAdapter来将RecyclerView和数据关联起来


    public void showResponse(final List<NewsBean.Result.Data> datas) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Log.d("parseData>>>当前线程", Thread.currentThread().getName());
                // Log.i(TAG, "加载到showResponse: datasize="+datas.size());
                Log.e("callback",callback+"");
                Log.e("数据1",datas.size()+"=123");
                callback.getData(datas);

            }
        });

    }

}
