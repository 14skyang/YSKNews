package com.ysk.jikenews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysk.jikenews.R;
import com.ysk.jikenews.activity.NewsInfoActivity;
import com.ysk.jikenews.model.NewsBean;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {//自定义NewsAdapter来将RecyclerView和数据关联起来：

    private List<NewsBean.Result.Data> mNewsList;//把NewsBean类中的内部类Data创建成一个表
    private Context context;

    //构造函数
    public NewsAdapter(Context context){
        this.context = context;
    }

    //设置显示值，并进行adapter的刷新
    public void  setData(List<NewsBean.Result.Data> mNewsList) {
        this.mNewsList = mNewsList;
        notifyDataSetChanged();
    }

    //定义载体
    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private ImageView newsImage;
        private TextView newsTitle;
        private TextView newsSrc;
        private TextView newsTime;
        public ViewHolder(View view) {//自定义类 ViewHolder 来减少 findViewById() 的使用
            super(view);
            linearLayout = view.findViewById(R.id.linear_layout);//调用新闻显示模板
            newsImage = view.findViewById(R.id.iv_news_list_image);
            newsTitle = view.findViewById(R.id.tv_news_list_title);
            newsSrc = view.findViewById(R.id.tv_news_list_real_type);
            newsTime = view.findViewById(R.id.tv_news_list_time);
        }
    }

    @Override
    //将载体进行？？？
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    //对各个item的控件进行赋值
    public void onBindViewHolder(ViewHolder holder, int position) {//组装获取的新闻数据到界面上
        final NewsBean.Result.Data news = mNewsList.get(position);//创建NewsBean类的内部类Data类的常量实例对象news
        String image = news.getThumbnail_pic_s().toString();
//        Log.i(">>>adapter>>>>>image", mNewsList.get(0).getThumbnail_pic_s());
        Glide.with(holder.itemView.getContext())
                .load(image)
                .into(holder.newsImage);//使用Glide框架引入新闻图片，至少三个参数：with(context)，load(url),into(imageView)
        holder.newsTitle.setText(news.getTitle());//通过newsbean的得到数据
        holder.newsSrc.setText(news.getAuthor_name());
        holder.newsTime.setText(news.getDate());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {//在Adapter中传值(url)给newsInfoActivity的webView
            @Override
            public void onClick(View v) {//点击监听
                Intent intent = new Intent(v.getContext(),NewsInfoActivity.class);//点击新闻后跳转新闻详细页即一个webView
                intent.putExtra("url",news.getUrl());//键名和键值
                v.getContext().startActivity(intent);//Intent背负着信使的荣誉称号进行传值
            }
        });
    }

    @Override
    //决定recycleitemView显示几个
    public int getItemCount() {
        return mNewsList!=null && mNewsList.size()>0 ? mNewsList.size():0;
    }


}
