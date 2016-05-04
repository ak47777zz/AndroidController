package com.autohome.utils;

import org.apache.commons.codec.digest.DigestUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 以MD5方式判断图像是否相等
 */
public class MD5Util {

    public static boolean compareInMD5(BufferedImage standard, BufferedImage
            sub) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(sub, "png", out);
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        ImageIO.write(standard, "png", out1);
        String s1 = DigestUtils.md5Hex(out.toByteArray());
        String s2 = DigestUtils.md5Hex(out1.toByteArray());
        return s1.equals(s2);
    }

}  