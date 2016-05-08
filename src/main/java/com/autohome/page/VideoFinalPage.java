package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 视频最终页
 */
public class VideoFinalPage extends Page {
    public void execute(AndroidDriver driver,boolean isUC) throws InterruptedException {
        String url = "http://v.m.autohome.com.cn/v-79986.html#pvareaid=2040104";
        AndroidUtils.goToPage(driver, url);
        String data = sdf.format(new Date());
        //8.视频最终页顶部
        AndroidUtils.saveScreenShot(driver, "e:/image/8", data, isUC);
        AndroidUtils.sleep();
        //9.视频最终页下方文字链
        AndroidUtils.saveScreenShot(driver, "e:/image/9", data, isUC);
        AndroidUtils.sleep();
    }
}
