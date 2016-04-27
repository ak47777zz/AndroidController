package com.autohome.page;

import com.autohome.androidcontroller.Utils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * Created by Administrator on 2016/4/25.
 */
public class HomePage extends Page {


    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        Utils.goToMHomePage(driver,isUC);
        String date = sdf.format(new Date());
        //1.首页顶部
        Utils.saveScreenShot(driver, "e:/image/1", date, isUC);
        Thread.sleep(5 * 1000);
        //2.首页右上角app下载
        Utils.saveScreenShot(driver, "e:/image/2", date, isUC);
        Thread.sleep(3 * 1000);
        //5.页面中部资讯列表icon
        Utils.swipeToUp(driver, 5);
        date = sdf.format(new Date());
        Utils.saveScreenShot(driver, "e:/image/5", date, isUC);
        //4.首页页面底部icon
        Utils.swipeToUp(driver, 8);
        date = sdf.format(new Date());
        Utils.saveScreenShot(driver, "e:/image/4", date, isUC);
        Thread.sleep(5 * 1000);
        //返回浏览器桌面
        Utils.backToHomePage(driver, isUC);
    }


}
