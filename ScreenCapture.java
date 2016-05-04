//package com.autohome.androidcontroller;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Date;
//
///**
// * Created by Administrator on 2016/4/21.
// */
//public class ScreenCapture {
//
//    /**
//     * 可能是获取设备名字的字符串
//     *
//     * @return
//     */
//    public static String[] getDevices() {
//        String command = "adb devices";
//        System.out.println(command);
//        ArrayList<String> devices = new ArrayList<String>();
//
//        try {
//            Process process = Runtime.getRuntime().exec(command);
//            BufferedReader bufferedReader = new BufferedReader(new
//                    InputStreamReader(process.getInputStream()));
//
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                if (line.endsWith("device")) {
//                    String device = line.substring(0, line.length() -
//                            "device".length()).trim();
//                    devices.add(device);
//                }
//
//                line = bufferedReader.readLine();
//            }
//            process.destroy();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String[] s = new String[devices.size()];
//        for (int i = 0; i < devices.size(); i++) {
//            s[i] = devices.get(i);
//        }
//        return s;
//    }
//
//    /**
//     * 完整的设备名
//     * @param device
//     * @return
//     */
//    public static String getModel(String device) {
//        String command = "adb -s " + device + " shell getprop";
//        System.out.println(command);
//        String model = null;
//
//        try {
//            Process process = Runtime.getRuntime().exec(command);
//            BufferedReader bufferedReader = new BufferedReader(new
//                    InputStreamReader(process.getInputStream()));
//
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                if (line.contains("[ro.product.model]:")) {
//                    model = line.substring(("[ro.product.model]:").length())
//                            .trim();
//                    model = model.substring(1, model.length() - 1);
//                    break;
//                }
//                line = bufferedReader.readLine();
//            }
//            process.destroy();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return model;
//    }
//
//    public static void snapshot(String device, String toPath, String toFile) {
//        String temp = "scrsnp.png";
//        long t0 = new Date().getTime();
//        String command1 = "adb -s " + device + " shell screencap -p /sdcard/"
//                + temp;
//        System.out.println(command1);
//        cmdExecute(command1);
//        long t1 = new Date().getTime();
//        System.out.println(t1 - t0);
//        String command2 = "adb -s " + device + " pull /sdcard/" + temp + " "
//                + toPath + "/" + toFile;
//        System.out.println(command2);
//        cmdExecute(command2);
//        long t2 = new Date().getTime();
//        System.out.println(t2 - t1);
//        String command3 = "adb -s " + device + " shell rm /sdcard/" + temp;
//        System.out.println(command3);
//        cmdExecute(command3);
//        long t3 = new Date().getTime();
//        System.out.println(t3 - t2);
//    }
//
//    public static void cmdExecute(String command) {
//        try {
//            Process process = Runtime.getRuntime().exec(command);
//            process.waitFor();
//            process.destroy();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public static void main(String[] args) throws Exception {
//        String[] ds = ScreenCapture.getDevices();
//        if (ds.length > 0) {
//            String model = ScreenCapture.getModel(ds[0]);
//            System.out.println(model);
//            long t0 = new Date().getTime();
//            ScreenCapture.snapshot(ds[0], ".", "a.png");
//            long t1 = new Date().getTime();
//            System.out.println(t1 - t0);
//        }
//    }
//}
