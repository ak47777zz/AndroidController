package com.autohome.androidcontroller;

import com.autohome.page.HomePage;
import com.autohome.page.Page;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidAuto {
    private AndroidDriver driver;

    //配置页面
    public Page[] pages = new Page[]{new HomePage()};

    public void loadUCDriver() throws Exception {
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoLaunch", false);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.2");
        capabilities.setCapability("deviceName", "Android Emulator");
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.UCMobile");
        capabilities.setCapability("appActivity", "com.uc.browser" +
                ".InnerUCMobile");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        System.out.println("获取driver成功");
    }


    public void loadQQDriver() throws MalformedURLException {
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoLaunch", false);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.0.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.tencent.mtt");
        capabilities.setCapability("appActivity", "com.tencent.mtt" +
                ".MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        System.out.println("获取driver成功");
    }


    public void start() throws Exception {
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                loadUCDriver();
            } else {
                loadQQDriver();
            }
            driver.launchApp();
            Utils.sleep(1);
            try {
                for (Page page : pages) {
                    page.execute(driver, i == 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("driver:离开");
                driver.quit();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        AndroidAuto t = new AndroidAuto();
        t.start();

    }


}