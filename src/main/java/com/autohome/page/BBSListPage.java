package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 论坛列表
 */
public class BBSListPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        String url = "http://club.m.autohome.com.cn/bbs/forum-c-3788-1" +
                ".html#pvareaid=101764";
        AndroidUtils.goToPage(driver, url);
        //17.论坛列表
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/17", data, isUC);
        AndroidUtils.sleep();

    }
}
