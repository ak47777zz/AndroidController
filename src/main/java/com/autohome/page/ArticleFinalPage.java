package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 文章最终页
 */
public class ArticleFinalPage extends Page {
    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        //6.文章最终页顶部
        String url = "m.autohome.com.cn/news/201605/888374.html";
        AndroidUtils.goToPage(driver,url);
        //driver.tap(1, 540, 1400, 100);
        AndroidUtils.sleep();
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/6", data, isUC);
        AndroidUtils.sleep();
        //AndroidUtils.stepBack(driver,1,isUC);
        //AndroidUtils.sleep();
    }
}
