package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 降价
 */
public class PriceOffPage extends Page {
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        String url = "http://buy.m.autohome.com" +
                ".cn/0/0/0/110000/110100/0-1-1-1" +
                ".html?pvareaid=104788\"\\&\"SourceType=0";
        AndroidUtils.goToPage(driver, url);
        //14.降价首页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/14", data, isUC);
        AndroidUtils.sleep();
    }
}
