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
        driver.tap(1,970,640,300);
        AndroidUtils.sleep();
        //17.论坛列表
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/17", data, isUC);

    }
}
