package com.xxx;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by Richard on 14-11-19.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.process(args[0],args[1]);
    }

    public void process(String srcPath,String destPath) {
        String[] infos = info.split("\n");
        for (int i = 0; i < infos.length; i++) {
            String item = infos[i];
            String[] details = item.split("\t");
            fileChannelCopy(new File(srcPath+"/"+details[1]),new File(destPath+"/"+details[0]+"_正.jpg"));
            fileChannelCopy(new File(srcPath+"/"+details[2]),new File(destPath+"/"+details[0]+"_反.jpg"));
        }
    }

    public void fileChannelCopy(File s, File t) {
        if(!s.exists()) {
            return;
        }
        System.out.println(s.getAbsolutePath()+"------>"+t.getAbsolutePath());
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

    public void copy(File s,File t) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(s));
            os = new BufferedOutputStream(new FileOutputStream(t));
            byte[] buf = new byte[4096];
            int i;
            while ((i=is.read(buf)) > -1) {
                os.write(buf,0,i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String info = "410327198810087670\t1IFLIH2sV2Ju.jpg\t22IfA3VbL30O.jpg\n";

}
