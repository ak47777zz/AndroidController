package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 文章列表
 */
public class ArticleListPage extends Page {


    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        if (isUC) {
            driver.tap(1, 540, 370, 200);
        } else {
            driver.tap(1, 540, 140, 200);
        }
        String url = "m.autohome.com.cn/channel";
        AndroidUtils.goToPage(driver,url);
        //5.文章列表顶部
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/5", data, isUC);
        AndroidUtils.sleep();
    }
}
