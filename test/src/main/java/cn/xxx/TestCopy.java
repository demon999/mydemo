package cn.xxx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/15/2015
 * @description
 */
public class TestCopy {
    public static void main(String[] args) {
        if(args == null || args.length < 2 || args[0] == null || args[1] == null) {
            System.out.println("请输入正确的源路径和目的路径：");
        }
        String srcPath = args[0];
        String destPath = args[1];
        new TestCopy().copyFile(srcPath,destPath);
    }

    public void copyFile(String srcPath,String destPath) {
        String[] filePaths = FILE_PATH.split("\\n");
        for (int i = 0; i < filePaths.length; i++) {
            String filePath = srcPath+"/"+filePaths[i];
            File file = new File(filePath);
            if(!file.exists()) {
                continue;
            }
            System.out.println("copying >>>>> "+filePath);
            fileChannelCopy(file,new File(destPath+"/"+file.getName()));
        }
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

    private final static String FILE_PATH = "";
}
