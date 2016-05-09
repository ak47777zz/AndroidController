package com.autohome.utils;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/22.
 */
public class AndroidUtils {

    /**
     * 截屏并保存至指定路径
     *
     * @param driver
     * @param path
     * @param fileName
     * @return
     */
    public static boolean saveScreenShot(AndroidDriver driver, String path,
                                         String fileName, boolean isUC)
            throws InterruptedException {
        deleteOldImage(path, isUC);
        fileName = fileName + (isUC ? "-uc" : "-qq");
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
     * 删除旧的截屏
     *
     * @param path
     * @param isUC
     */
    private static void deleteOldImage(String path, boolean isUC) throws
            InterruptedException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        File[] array = file.listFiles();
        String absolutePath = "";
        String browser = "qq";
        if (isUC) {
            browser = "uc";
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                String str = array[i].getName();
                if (str.contains("-") && str.contains(browser)) {
                    absolutePath = absolutePath + path + File
                            .separator + str;
                    while (true) {
                        if (new File(absolutePath).delete()) {
                            break;
                        }
                    }
                    AndroidUtils.sleep();
                    absolutePath = "";
                }
            }
        }
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
            driver.swipe(width / 2, (int) (height * 0.8), width / 2, (int)
                    (height * 0.1), 1000);
            AndroidUtils.sleep();
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
        AndroidUtils.sleep();
        if (isUC) {
            driver.tap(1, width / 2, 370, 200);
        } else {
            driver.tap(1, width / 2, 140, 200);
        }
        AndroidUtils.sleep();
        AndroidUtils.cmdExecute("adb shell input text m.autohome.com.cn");
        AndroidUtils.sleep();
        if (isUC) {
            driver.tap(1, 1000, 140, 200);
        } else {
            driver.tap(1, 1000, 140, 200);
        }
        AndroidUtils.sleep();
    }

    /**
     * 进入指定url的页面
     *
     * @param url
     */
    public static void goToPage(AndroidDriver driver, String url) throws
            InterruptedException {
        driver.tap(1, 540, 140, 50);
        sleep();
        cmdExecute("adb shell input text " + url);
        sleep();
        driver.tap(1, 1000, 140, 100);
        sleep();
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
            driver.tap(1, 756, 1704, 100);
        }
        sleep();
    }

    /**
     * 休眠 单位秒
     *
     * @param
     */
    public static void sleep() throws InterruptedException {
        Thread.sleep(PropertiesUtil.getInt("stepTime") * 1000);
    }

    /**
     * 浏览器后退一步
     *
     * @param driver
     * @param times  后退次数
     * @param isUC   是否是UC
     */
    public static void stepBack(AndroidDriver driver, int times, boolean
            isUC) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            driver.tap(1, 100, 1700, 100);
            sleep();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        deleteOldImage("e:/image/10",true);
    }


}
