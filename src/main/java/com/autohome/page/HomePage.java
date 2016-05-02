package com.autohome.page;

import com.autohome.androidcontroller.Utils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 首页
 */
public class HomePage extends Page {


    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        Utils.goToMHomePage(driver,isUC);
        String date = sdf.format(new Date());
        //1.首页顶部
        Utils.saveScreenShot(driver, "e:/image/1", date, isUC);
        Utils.sleep();
        //2.首页右上角app下载
        Utils.saveScreenShot(driver, "e:/image/2", date, isUC);
        Utils.sleep();
        //4.页面中部资讯列表icon
        Utils.swipeToUp(driver, 6);
        Utils.saveScreenShot(driver, "e:/image/4", date, isUC);
        //3.首页页面底部icon
        Utils.swipeToUp(driver, 9);
        Utils.saveScreenShot(driver, "e:/image/3", date, isUC);
        Utils.sleep();
        //返回浏览器桌面
        Utils.backToHomePage(driver, isUC);
    }


}
