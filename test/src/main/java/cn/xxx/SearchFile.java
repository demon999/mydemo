package cn.xxx;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/28/2015
 * @description
 */
public class SearchFile {

    public static void main(String[] args) {
//        String path = "E:\\test";
//        String dstPath = "E:\\dst";
        if(args == null || args.length < 2 || args[0] == null || args[1] == null) {
            System.out.println("请输入正确的源路径和目的路径：");
        }
        String path = args[0];
        String dstPath = args[1];
        new SearchFile().searchFile(path,dstPath);
    }

    public void searchFile(String path,String dstPath) {
        File dir = new File(path);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return match(name);
            }
        });
        for (int i = 0; i < files.length; i++) {
            fileChannelCopy(files[i], new File(dstPath + "/" + files[i].getName()));
        }
    }

    private boolean match(String name) {
        if(!name.endsWith("bill.json")) {
            return false;
        }
        String[] infos = allInfo.split("\\n");
        for (int i = 0; i < infos.length; i++) {
            if(name.contains(infos[i].replace("\t","_"))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用文件通道的方式复制文件
     * @param s 源文件
     * @param t 复制到的新文件
     */
    public void fileChannelCopy(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String allInfo = "";

}
