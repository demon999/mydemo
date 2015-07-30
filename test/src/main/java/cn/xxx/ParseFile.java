package cn.xxx;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 07/30/2015
 * @description
 */
public class ParseFile {
    public static void main(String[] args) {
        String path = "E:\\ylzh";
        parse(path);
    }

    public static void parse(String path) {
        File[] files = new File(path).listFiles();
        Pattern pattern = Pattern.compile("\"uuid\":\"([A-Za-z0-9-]*)\"");
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            try {
                String content = FileUtils.readFileToString(file,"UTF8");
                Matcher matcher = pattern.matcher(content);
                if(matcher.find()) {
                    StringBuilder sb = new StringBuilder("update WTS.D_UNIPAY_CARDACCOUNT set UID = '");
                    sb.append(matcher.group(1));
                    sb.append("',FLAG = 0 where UID is null and APPL_NO = '");
                    sb.append(file.getName().substring(14,30)+"' ");
                    sb.append("and CARDNO = '");
                    sb.append(file.getName().substring(31,file.getName().length()-10));
                    sb.append("';");
                    System.out.println(sb);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
