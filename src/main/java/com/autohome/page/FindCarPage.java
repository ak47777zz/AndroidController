package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 找车首页、列表页
 */
public class FindCarPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        //13.找车首页
        String url = "http://car.m.autohome.com.cn/#pvareaid=100235";
        AndroidUtils.goToPage(driver, url);
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/13", data, isUC);
        AndroidUtils.sleep();
    }
}
