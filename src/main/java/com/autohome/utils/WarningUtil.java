package com.autohome.utils;

import com.autohome.model.Cut;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/27.
 */
public class WarningUtil {

    //记录是否被屏蔽
    private static boolean[] shield;
    //记录被屏蔽次数，超过3次报警
    private static int[] times;

    static {
        shield = new boolean[PropertiesUtil.getInt("size")];
        times = new int[PropertiesUtil.getInt("size")];
    }

    /**
     * 判断是否屏蔽并报警
     *
     * @param
     */
    public static void warning(Cut cut, boolean isSame) throws IOException {

        boolean isShield = shield[cut.getId() - 1];

        if (isShield) {
            //已经是被屏蔽状态
            if (isSame) {
                //上次被屏蔽，现在屏蔽被修复
                shield[cut.getId() - 1] = false;
                if (times[cut.getId() - 1] > 3) {
                    writeMessage(cut.getBrowser() + "浏览器位置" + (cut.getId() + 1) /
                            2 + "被修复");

                }
                times[cut.getId() - 1] = 0;
                System.out.println(cut.getBrowser() + "浏览器位置" + (cut.getId()
                        + 1) / 2 + "被修复");
            } else {
                //上次被屏蔽，这次还被屏蔽
                times[cut.getId() - 1] = times[cut.getId() - 1] + 1;
                if (times[cut.getId() - 1] > 3) {
                    writeMessage(cut.getBrowser() + "浏览器位置" + (cut.getId() + 1) /
                            2 + "被屏蔽");
                    System.out.println(cut.getBrowser() + "浏览器位置" + (cut.getId()
                            + 1) / 2 + "被真屏蔽");
                }
                System.out.println(cut.getBrowser() + "浏览器位置" + (cut.getId()
                        + 1) / 2 + "被屏蔽,次数为"+times[cut.getId() - 1]);
            }
        } else {
            //未屏蔽状态
            if (isSame) {
                //上次未屏蔽，这次未屏蔽
                ;
            } else {
                //上次未屏蔽，这次被屏蔽
                shield[cut.getId() - 1] = true;
                times[cut.getId() - 1] = times[cut.getId() - 1] + 1;
                System.out.println(cut.getBrowser() + "浏览器位置" + (cut.getId()
                        + 1) / 2 + "被屏蔽,次数为"+times[cut.getId() - 1]);
            }
        }
    }

    /**
     * 文件内写入消息
     *
     * @param s
     */
    private static void writeMessage(String s) throws IOException {
        FileUtils.write(new File("e:/image/warning.txt"), s + "\r\n",
                "UTF-8", true);
    }


}
