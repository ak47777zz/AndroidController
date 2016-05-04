package com.autohome.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Administrator on 2016/4/26.
 */
public class StandardImageUtil {

    public static BufferedImage[] cutImageAsStandard(int i, String[] s)
            throws IOException,
            ParseException {
        //BufferedImage[] images = newImage(s[4]);
        BufferedImage[] images = null;
        BufferedImage sub1 = images[0].getSubimage(Integer.parseInt(s[0]),
                Integer
                .parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt
                (s[3]));
        BufferedImage sub2 = images[1].getSubimage(Integer.parseInt(s[0]),
                Integer
                .parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt
                (s[3]));
        return new BufferedImage[]{sub1, sub2};


    }

}
