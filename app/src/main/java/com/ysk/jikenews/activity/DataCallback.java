package com.ysk.jikenews.activity;

import com.ysk.jikenews.model.NewsBean;

import java.util.List;
//接口的定义是必要的
public interface DataCallback {
    void getData(List<NewsBean.Result.Data> mNewsList);
}
