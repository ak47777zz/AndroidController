package com.autohome.image;

import com.autohome.model.Cut;

/**
 * Created by Administrator on 2016/4/27.
 */
public class WarningUtil {

    private static boolean[] shield;

    static {
        shield = new boolean[PropertiesUtil.getInt("size")];
    }

    /**
     * 判断是否修改Excel并报警
     *
     * @param
     */
    public static void warning(Cut cut, boolean isSame) {

        boolean isShield = shield[cut.getId() - 1];

        if (isShield) {
            //已经是被屏蔽状态
            if (isSame) {
                //上次被屏蔽，现在屏蔽被修复
                shield[cut.getId() - 1] = false;
                //excel();
            } else {
                //上次被屏蔽，这次还被屏蔽
                ;
            }
        } else {
            //未屏蔽状态
            if (isSame) {
                //上次未屏蔽，这次被屏蔽
                //发短信
            } else {
                //上次未屏蔽，这次未屏蔽
                ;
            }
        }
    }
}
