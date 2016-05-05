package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 经销商
 */
public class DealerPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        driver.tap(1,540,740,300);
        AndroidUtils.sleep();
        //15.经销商首页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/15", data, isUC);
        AndroidUtils.stepBack(driver, 1, isUC);
    }
}
