package com.autohome.utils;

import com.autohome.model.Cut;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by sunao on 2016/4/15.
 */
public class ImageUtil {

    public static BufferedImage[] standards = null;

    /**
     * 将标准截图全部读进来缓存起来
     */
    static {
        Cut[] cuts = PropertiesUtil.getCutModels();
        int size = PropertiesUtil.getInt("size");
        standards = new BufferedImage[size];
        for (int i = 1; i <= size; i++) {
            Cut cut = cuts[i - 1];
            String path = cut.getPath();
            try {
                standards[i - 1] = readImage(path + File.separator + i +
                        "" + "_" + cut.getBrowser() +
                        ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 切割最新的截图并返回.
     *
     * @param
     * @param
     * @throws IOException
     */
    public static BufferedImage cutNew(Cut cut) throws IOException,
            ParseException {
        //这个img应该是最新的截屏
        BufferedImage img = newImage(cut);
        BufferedImage sub = img.getSubimage(cut.getStartX(), cut.getStartY(),
                cut.getEndX(), cut.getEndY());
        return sub;

        //String format = "png";
        //ImageIO.write(sub, format, file);//将图片保存为jpeg格式的文件file。也可以保存为jpg格式
    }

    /**
     * 获取最新的截屏图片
     *
     * @return
     */
    public static BufferedImage newImage(Cut cut) throws ParseException,
            IOException {
        File file = new File(cut.getPath());
        File[] array = file.listFiles();
        String absolutePath = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                String str = array[i].getName();
                //str = str.substring(0, str.lastIndexOf("."));   //str是文件名
                if (str.contains("-") && str.contains(cut.getBrowser())) {
                    absolutePath = absolutePath + cut.getPath() + File
                            .separator + str;
                }
            }
        }
        return readImage(absolutePath);
    }

    /**
     * 比较图片是否相等，相同返回true
     *
     * @param
     * @param
     * @return
     */
    public static boolean compare(Cut cut) throws IOException,
            ParseException {
        BufferedImage sub = cutNew(cut);
        //获取标准图片
        BufferedImage standard = standards[cut.getId() - 1];
        return MD5Util.compareInMD5(standard, sub);
    }

    /**
     * 读取一个图片
     *
     * @param path 图片路径
     * @return
     */
    public static BufferedImage readImage(String path) throws IOException {
        FileInputStream in = new FileInputStream(new File
                (path));
        BufferedImage img = ImageIO.read(in);
        in.close();
        return img;
    }

    /**
     * 写入一个图片
     *
     * @param path 图片路径
     * @return
     */
    public static boolean writeImage(String path, BufferedImage image) throws
            IOException {
        return ImageIO.write(image, "png", new File(path));
    }

}
