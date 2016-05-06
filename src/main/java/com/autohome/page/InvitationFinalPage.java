package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 帖子最终页
 */
public class InvitationFinalPage extends Page{
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws InterruptedException {
        AndroidUtils.swipeToUp(driver,1);
        driver.tap(1,540,450,100);
        AndroidUtils.sleep();
        //18.帖子最终页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/18", data, isUC);
        AndroidUtils.backToHomePage(driver,isUC);
    }
}
