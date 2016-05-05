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
        AndroidUtils.stepBack(driver, 2, isUC);
        //13.找车首页
        driver.tap(1, 320, 650, 300);
        AndroidUtils.sleep();
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/13", data, isUC);
        AndroidUtils.stepBack(driver, 1, isUC);
    }
}
