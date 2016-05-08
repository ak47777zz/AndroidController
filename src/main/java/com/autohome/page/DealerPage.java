package com.autohome.page;

import com.autohome.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;

import java.util.Date;

/**
 * 经销商
 */
public class DealerPage extends Page {
    @Override
    public void execute(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        String url = "http://dealer.m.autohome.com.cn/list_110100_0_1_1" +
                ".html#pvareaid=104787";
        AndroidUtils.goToPage(driver, url);
        //15.经销商首页
        String data = sdf.format(new Date());
        AndroidUtils.saveScreenShot(driver, "e:/image/15", data, isUC);
        AndroidUtils.sleep();
    }
}
