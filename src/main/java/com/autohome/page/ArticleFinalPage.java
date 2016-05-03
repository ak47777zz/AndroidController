package com.autohome.page;

import com.autohome.androidcontroller.Utils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 文章最终页
 */
public class ArticleFinalPage extends Page {
    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        //5.文章最终页顶部
        driver.tap(1, 540, 1400, 100);
        String data = sdf.format(new Date());
        Utils.saveScreenShot(driver, "e:/image/6", data, isUC);
        Utils.sleep();
        Utils.backToHomePage(driver, isUC);
    }
}
