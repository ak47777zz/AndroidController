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
        String url = "m.autohome.com.cn/shuoke/517569.html";
        AndroidUtils.goToPage(driver, url);
        String data = sdf.format(new Date());
        //7.说客最终页顶部
        AndroidUtils.saveScreenShot(driver, "e:/image/7", data, isUC);
        AndroidUtils.sleep();
    }
}
