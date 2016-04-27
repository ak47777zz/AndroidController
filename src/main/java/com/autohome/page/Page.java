package com.autohome.page;

import io.appium.java_client.android.AndroidDriver;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/4/25.
 */
public abstract class Page {

    SimpleDateFormat sdf = new SimpleDateFormat
            ("yyyy-MM-dd-HH-mm-ss");

    /**
     * 截图并保存在指定位置
     * @param driver
     */
    public abstract void execute(AndroidDriver driver,boolean isUC) throws
            InterruptedException;
}
