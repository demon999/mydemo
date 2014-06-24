package com.snow.pdf;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Administrator on 14-6-18.
 */
public class PdfToZip {

    private static String srcPath = "C:\\images\\pboc";

    private static String destPath = "C:\\images\\pboc";

    private static final int BUFFER = 2048;

    public static void main(String[] args) {

        testZip();

//        try {
//            test11();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void test11() throws Exception {

        FileOutputStream fos = new FileOutputStream(srcPath+"\\320105198008301210.zip");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ZipOutputStream zos = new ZipOutputStream(bos);//压缩包

        File f = new File(destPath+"\\320105198008301210.pdf");
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(fis);

        ZipEntry ze = new ZipEntry(f.getName());//这是压缩包名里的文件名
        zos.putNextEntry(ze);//写入新的 ZIP 文件条目并将流定位到条目数据的开始处

        byte[] buf = new byte[1024];
        int len;
        while((len=bis.read(buf))!=-1)
        {
            zos.write(buf,0,len);
            zos.flush();
        }
        bis.close();
        zos.close();
    }

    public static void testZip() {
        try {
            File f = new File(srcPath);
            File files[] = f.listFiles();

            FileOutputStream dest = new FileOutputStream(destPath+"\\myfiles.zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            BufferedInputStream origin = null;
            for (int i = 0; i < files.length; i++) {
                FileInputStream fi = new FileInputStream(files[i]);
                origin = new BufferedInputStream(fi);
                System.out.println(files[i].getName());
                ZipEntry entry = new ZipEntry(files[i].getName());
                out.putNextEntry(entry);

                int count = 0;
                byte data[] = new byte[BUFFER];
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                    out.flush();
                }
                origin.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
