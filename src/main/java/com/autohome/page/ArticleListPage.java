package com.autohome.page;

import com.autohome.androidcontroller.Utils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * Created by Administrator on 2016/4/25.
 */
public class ArticleListPage extends Page {



    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        Utils.goToMHomePage(driver,isUC);
        //点击文章
        driver.tap(1, 162, 860, 1);
        Thread.sleep(5000);
        //6.文章列表顶部
        String data = sdf.format(new Date());
        Utils.saveScreenShot(driver, "e:/image/6", data, isUC);
        Thread.sleep(5 * 1000);
        Utils.backToHomePage(driver, isUC);
    }
}
