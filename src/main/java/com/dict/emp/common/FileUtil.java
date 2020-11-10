package com.dict.emp.common;

import java.text.DecimalFormat;

public class FileUtil {

    public static final String TYPE_B = "B";
    public static final String TYPE_K = "K";
    public static final String TYPE_M = "M";
    public static final String TYPE_G = "G";

    /**
     * 转换文件大小
     * @param fileSize 原文件大小
     * @return
     */
    public static String formatFileSize(long fileSize) {
        DecimalFormat df = new DecimalFormat("#.00");
        String formatFileSize = "";
        if (fileSize < 1024) {
            formatFileSize = df.format((double) fileSize) + TYPE_B;
        } else if (fileSize < 1048576) {
            formatFileSize = df.format((double) fileSize / 1024) + TYPE_K;
        } else if (fileSize < 1073741824) {
            formatFileSize = df.format((double) fileSize / 1048576) + TYPE_M;
        } else {
            formatFileSize = df.format((double) fileSize / 1073741824) + TYPE_G;
        }
        return formatFileSize;
    }

    /**
     * 转换文件大小
     *
     * @param fileSize 原文件大小
     * @param type     类型
     * @return
     */
    public static String formatFileSize(long fileSize, String type) {
        DecimalFormat df = new DecimalFormat("#.00");
        String formatFileSize = "";
        switch (type) {
            case TYPE_B:
                formatFileSize = fileSize + TYPE_B;
                break;
            case TYPE_K:
                formatFileSize = df.format((double) fileSize / 1024) + TYPE_K;
                break;
            case TYPE_M:
                formatFileSize = df.format((double) fileSize / 1048576) + TYPE_M;
                break;
            case TYPE_G:
                formatFileSize = df.format((double) fileSize / 1073741824) + TYPE_G;
                break;
            default:
                break;
        }
        return formatFileSize;
    }

}
