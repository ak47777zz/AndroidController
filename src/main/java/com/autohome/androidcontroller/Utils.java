package com.autohome.androidcontroller;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/22.
 */
public class Utils {

    /**
     * 截屏并保存至指定路径
     *
     * @param driver
     * @param path
     * @param fileName
     * @return
     */
    public static boolean saveScreenShot(AndroidDriver driver, String path,
                                         String fileName, boolean isUC) {
        fileName = fileName+(isUC?"-uc":"-qq");
        File screen = driver.getScreenshotAs(OutputType.FILE);
        File screenFile = new File(path + "/" + fileName + ".png");
        try {
            FileUtils.copyFile(screen, screenFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 在cmd中提交指令
     *
     * @param command
     */
    public static void cmdExecute(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 屏幕向上滑动一屏
     *
     * @param driver
     * @param times  滑动次数
     * @throws InterruptedException
     */
    public static void swipeToUp(AndroidDriver driver, int times) throws
            InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < times; i++) {
            driver.swipe(width / 2, (int) (height * 0.9), width / 2, (int)
                    (height * 0.1), 1000);
            Utils.sleep(1);
        }
        // wait for page loading
    }

    /**
     * 在浏览器首页进入m.autohome.com.cn
     *
     * @param driver
     * @throws InterruptedException
     */
    public static void goToMHomePage(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        int width = driver.manage().window().getSize().width;
        Utils.sleep(1);
        driver.tap(1, width / 2, 370, 100);
        Utils.sleep(1);
        Utils.cmdExecute("adb shell input text m.autohome.com.cn");
        Utils.sleep(1);
        driver.tap(1, 973, 144, 100);
        Utils.sleep(1);
        //if (isUC) {
        //    Utils.cmdExecute("adb shell input keyevent 66");
        //
        //} else {
        //
        //}
    }

    /**
     * 截完图后，回到浏览器桌面
     *
     * @param driver
     */
    public static void backToHomePage(AndroidDriver driver, boolean isUC) throws
            InterruptedException {
        if (isUC) {
            driver.tap(1, 973, 1708, 100);
        } else {
            driver.tap(1, 756, 1704, 1);
        }
        Thread.sleep(1);
    }

    /**
     * 休眠 单位秒
     * @param second
     */
    public static void sleep(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }


}
