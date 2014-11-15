package com.snow.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Richard on 14-9-9.
 */
public class CryptoUtil {
    private static Logger logger = LoggerFactory.getLogger(CryptoUtil.class);
    private final static String MD5 = "MD5";
    private final static String SHA1 = "SHA-1";
    private final static String SHA = "SHA";
    private final static String DES = "DES";
    private final static String KEY = "~!@#$%^&*";

    /**
     * MD5加密
     * @param value
     * @return
     */
    public static String md5(String value) {
        String result = null;
        try {
            byte[] valueByte = value.getBytes();
            MessageDigest md = MessageDigest.getInstance(MD5);
            md.update(valueByte);
            result = toHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("CryptoUtil", e);
        }
        return result;
    }

    private static String toHex(byte[] buffer) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
        }
        return sb.toString();
    }

    /**
     * SHA1加密
     * @param decript
     * @return
     */
    public static String sha1(String decript) {
        try {
            MessageDigest digest = MessageDigest .getInstance(SHA1);
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error("CryptoUtil", e);
        }
        return "";
    }

    public static String sha(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance(SHA);
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error("CryptoUtil", e);
        }
        return "";
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptDes(String data) {
        String result = "";
        try {
            byte[] bt = encrypt(data.getBytes(), KEY.getBytes());
            result = new BASE64Encoder().encode(bt);
        } catch (Exception e) {
            logger.error("CryptoUtil", e);
        }
        return result;
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptDes(String data) {
        if (data == null) {
            throw new NullPointerException();
        }
        String result = "";
        try{
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] buf = decoder.decodeBuffer(data);
            byte[] bt = decrypt(buf,KEY.getBytes());
            result = new String(bt);
        } catch (Exception e) {
            logger.error("CryptoUtil", e);
        }
        return result;
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }


    /**
     * Description 根据键值进行解密
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    /**
     * BASE64解密
     * @param str
     * @return
     * @throws Exception
     */
    public static String decryptBASE64(String str) throws IOException {
        return new String((new BASE64Decoder()).decodeBuffer(str));
    }

    public static byte[] decryptBASE64ToByte(String str) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(str);
    }

    /**
     * BASE64加密
     * @param str
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(String str) {
        return (new BASE64Encoder()).encodeBuffer(str.getBytes());
    }

}
