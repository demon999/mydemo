package com.snow.util;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Richard on 14-9-24.
 */
public final class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static final int FILENAME_LENGTH = 12;
    private static final String FILENAME_PATTERN = "%s/%s.jpg";


    /**
     * 生成文件名
     *
     * @return
     */
    public static String shaFileName() {
        String origin = RandomStringUtils.randomAlphanumeric(FILENAME_LENGTH)+System.currentTimeMillis();
        return CryptoUtil.sha(origin);
    }

    public static void saveFile(final String fileName, final byte[] source) {
        try {
            String filePrefix = fileName.substring(0, fileName.lastIndexOf("/"));
            File creditDir = new File(filePrefix);
            if (!creditDir.isDirectory() || !creditDir.exists()) {
                creditDir.mkdirs();
            }
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileName));
            stream.write(source);
            stream.close();
        } catch (IOException e) {
            logger.error("saveFile", e);
        }
    }

    /**
     * 保存字符串到文件
     *
     * @param filePath 绝度路径
     * @param content  字符串内容
     */
    public static void saveFile(final String filePath, final String content) {
        String filePrefix = filePath.substring(0, filePath.lastIndexOf("/"));
        File creditDir = new File(filePrefix);
        if (!creditDir.isDirectory() || !creditDir.exists()) {
            creditDir.mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            fos.write(content.getBytes("GBK"));
        } catch (IOException ex) {
            logger.error("save file " + filePath);
        } finally {
            try {
                fos.flush();
                fos.close();
            } catch (IOException ex) {
                logger.error("save file " + filePath);
            }
        }
    }

    public static String readFile(String path,String encoding) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            long contentLength = file.length();
            ByteArrayOutputStream outstream = new ByteArrayOutputStream(contentLength > 0 ? (int) contentLength : 1024);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();
            return outstream.toString(encoding);
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException when read " + path, e);
        } catch (IOException e) {
            logger.error("found error when read " + path, e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    public static boolean removeFile(String path) {
        return new File(path).delete();
    }

    public static void main(String[] args) {
//        System.out.println(readFileByGBK("E:\\memedai\\credit\\arhz_20141101_201410111000200_arloan.json"));
    }

}