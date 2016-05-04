package com.autohome.start;

import com.autohome.androidcontroller.AndroidAuto;
import com.autohome.model.Cut;
import com.autohome.utils.ImageUtil;
import com.autohome.utils.PropertiesUtil;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 生成广告位的标准图片
 */
public class GenerateStandardImage {

    public void start() throws Exception {
        //1.截屏
        new AndroidAuto().start();
        //2.切图，保存为标准图片
        Cut[] cuts = PropertiesUtil.getCutModels();
        for (Cut cut : cuts) {
            BufferedImage img = ImageUtil.cutNew(cut);
            ImageUtil.writeImage(cut.getPath() + File.separator + cut.getId()
                    + "_" + cut.getBrowser() + ".png", img);
        }
    }

    public static void main(String[] args) throws Exception {
        new GenerateStandardImage().start();
    }
}
