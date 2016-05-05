package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 快报最终页
 */
public class KuaiBaoFinalPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        driver.tap(1,320,730,300);
        AndroidUtils.sleep();
        driver.tap(1,540,1000,300);
        //10.快报最终页顶部
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/10", data, isUC);
        AndroidUtils.stepBack(driver,2,isUC);
    }
}
