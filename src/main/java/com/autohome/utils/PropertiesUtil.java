package com.autohome.utils;

import com.autohome.model.Cut;
import com.autohome.page.Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by sunao on 2016/4/19.
 */
public class PropertiesUtil {

    private static Properties properties = load();

    /**
     * 载入properties文件
     *
     * @return
     */
    public static Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static int getInt(String arg) {
        return Integer.parseInt(properties.getProperty(arg));
    }

    /**
     * 把properties文件封装成HashMap返回.
     *
     * @return
     * @throws IOException
     */
    public static HashMap<Integer, String[]> getHash() throws IOException {
        HashMap<Integer, String[]> hashMap = new HashMap<Integer, String[]>();
        int size = getInt("size");
        for (int i = 1; i <= size; i++) {
            hashMap.put(i, properties.getProperty(String.valueOf(i)).split("," +
                    ""));
        }
        return hashMap;
    }

    public static Properties getProperties() {
        return properties;
    }

    /**
     * 把properties文件封装成cut实体类数组返回
     *
     * @return
     */
    public static Cut[] getCutModels() {
        int size = getInt("size");
        Cut[] cuts = new Cut[size];
        int i = 1;
        int j = 0;
        while (size > 0) {
            if (properties.getProperty(String.valueOf(i)) == null) {
                i++;
                continue;
            }
            Cut cut = new Cut();
            String[] s = properties.getProperty(String.valueOf(i)).split(",");
            cut.setId(i);
            cut.setStartX(Integer.parseInt(s[0]));
            cut.setStartY(Integer.parseInt(s[1]));
            cut.setEndX(Integer.parseInt(s[2]));
            cut.setEndY(Integer.parseInt(s[3]));
            cut.setPath(s[4]);
            cut.setBrowser(s[5]);
            cuts[j] = cut;
            i++;
            j++;
            size--;
        }
        return cuts;
    }

    /**
     * 获取page实例
     *
     * @return
     */
    public static Page[] getPages() throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        int i = 1;
        ArrayList<String> className = new ArrayList<String>();
        while (true) {
            String page = properties.getProperty("page_" + i);
            if (page != null) {
                className.add(page);
                i++;
                continue;
            }
            break;
        }
        Page[] pages = new Page[i - 1];
        for (int j = 0; j < i - 1; j++) {
            pages[j] = (Page) Class.forName(className.get(j)).newInstance();
        }
        return pages;
    }


}
