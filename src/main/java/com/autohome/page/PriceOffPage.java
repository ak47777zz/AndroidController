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
        driver.tap(1, 750, 740, 100);
        AndroidUtils.sleep();
        //14.降价首页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/14", data, isUC);
        AndroidUtils.stepBack(driver, 1, isUC);
    }
}
