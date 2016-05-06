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
        driver.tap(1,105,1175,100);
        AndroidUtils.sleep();
        driver.tap(1,540,820,100);
        AndroidUtils.sleep();
        //11.车型车系顶部
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/11", data, isUC);
        //12.车型车系 页面中下部文字链??
        AndroidUtils.sleep();
        AndroidUtils.saveScreenShot(driver, "e:/image/12", data, isUC);
        AndroidUtils.stepBack(driver, 2, isUC);
    }
}
