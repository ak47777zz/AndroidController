package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 车系车型综述
 */
public class CheXiCheXingPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        driver.tap(1,320,650,300);
        AndroidUtils.sleep();
        driver.tap(1,105,1370,300);
        AndroidUtils.sleep();
        driver.tap(1,730,600,300);
        //11.车型车系顶部
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/11", data, isUC);
    }
}
