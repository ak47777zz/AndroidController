package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 论坛首页
 */
public class BBSHomePage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        driver.tap(1,115,1452,300);
        AndroidUtils.sleep();
        //16.论坛首页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/16", data, isUC);
    }
}
