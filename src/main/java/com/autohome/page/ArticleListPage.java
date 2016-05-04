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
        AndroidUtils.goToMHomePage(driver,isUC);
        //点击文章
        driver.tap(1, 105, 650, 100);
        AndroidUtils.sleep();
        //5.文章列表顶部
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/5", data, isUC);
        AndroidUtils.sleep();
    }
}
