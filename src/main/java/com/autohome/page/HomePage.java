package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 首页
 */
public class HomePage extends Page {


    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        AndroidUtils.goToMHomePage(driver,isUC);
        String date = sdf.format(new Date());
        //1.首页顶部
        AndroidUtils.saveScreenShot(driver, "e:/image/1", date, isUC);
        AndroidUtils.sleep();
        //2.首页右上角app下载
        AndroidUtils.saveScreenShot(driver, "e:/image/2", date, isUC);
        AndroidUtils.sleep();
        //4.页面中部资讯列表icon
        AndroidUtils.swipeToUp(driver, 7);
        AndroidUtils.saveScreenShot(driver, "e:/image/4", date, isUC);
        //3.首页页面底部icon
        AndroidUtils.swipeToUp(driver, 11);
        AndroidUtils.saveScreenShot(driver, "e:/image/3", date, isUC);
        AndroidUtils.sleep();
        //返回浏览器桌面
        AndroidUtils.backToHomePage(driver, isUC);
    }


}
