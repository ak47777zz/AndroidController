package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 说客最终页
 */
public class ShuoKeFinalPage extends Page {
    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        //7.说客最终页顶部
        //点击说客
        driver.tap(1, 753, 736, 300);
        AndroidUtils.sleep();
        //点击具体文章
        driver.tap(1, 540, 940, 300);
        AndroidUtils.sleep();
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/7", data, isUC);
        AndroidUtils.sleep();
        AndroidUtils.backToHomePage(driver, isUC);
    }
}
