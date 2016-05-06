package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 视频最终页
 */
public class VideoFinalPage extends Page {
    public void execute(AndroidDriver driver,boolean isUC) throws InterruptedException {
        driver.tap(1,100,730,100);
        AndroidUtils.sleep();
        driver.tap(1,540,1000,100);
        AndroidUtils.sleep();
        String data = sdf.format(new Date());
        //8.视频最终页顶部
        AndroidUtils.saveScreenShot(driver, "e:/image/8", data, isUC);
        AndroidUtils.sleep();
        //9.视频最终页下方文字链
        AndroidUtils.saveScreenShot(driver, "e:/image/9", data, isUC);
        AndroidUtils.sleep();
        AndroidUtils.stepBack(driver, 2, isUC);

    }
}
