package com.ysk.jikenews.controller;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController extends AppCompatActivity { //活动控制器用于baseActivity

    private static List<Activity> activityList = new ArrayList<>();
    //ArrayList是动态数组，继承自 AbstractList，实现了 List 接口。底层基于数组实现容量大小动态变化。允许 null 的存在。

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

   /* public static void finishAll() {
        activityList.removeAll(activityList);
        for (Activity activity:activityList) {
            activity.finish();
        }
        activityList.clear();
    }*/
}

