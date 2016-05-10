package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 帖子最终页
 */
public class InvitationFinalPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        String url = "club.m.autohome.com" +
                ".cn/bbs/thread-c-770-51630536-1.html";
        AndroidUtils.goToPage(driver, url);
        //18.帖子最终页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/18", data, isUC);
        AndroidUtils.backToHomePage(driver,isUC);
    }
}
