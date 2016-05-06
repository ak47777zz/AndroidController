package com.autohome.start;

import com.autohome.androidcontroller.AndroidAuto;
import com.autohome.utils.ImageUtil;
import com.autohome.utils.PropertiesUtil;
import com.autohome.utils.WarningUtil;
import com.autohome.model.Cut;

import java.io.IOException;
import java.text.ParseException;

/**
 * 运行
 */
public class Run {

    private Cut[] cuts = PropertiesUtil.getCutModels();

    private int sleepTime;

    public Run() throws IOException {
        this.sleepTime = PropertiesUtil.getInt("sleepTime");
    }


    private void start() throws Exception {
        AndroidAuto android = new AndroidAuto();
        while (true) {
            android.start();
            //18个位置，每个位置2种浏览器，所以比较36次
            for (Cut cut : cuts) {
                boolean b = compare(cut);
                WarningUtil.warning(cut, b);
            }
            Thread.sleep(sleepTime * 1000);
        }
    }

    /**
     * 相同为true，不相同为false
     *
     * @param
     * @return
     * @throws IOException
     */
    private boolean compare(Cut cut) throws IOException, ParseException {
        return ImageUtil.compare(cut);
    }

    public static void main(String[] args) throws Exception {
        new Run().start();
    }

}
