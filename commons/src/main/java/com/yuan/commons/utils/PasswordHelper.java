package com.yuan.commons.utils;

import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author laiyuan
 * 加密工具
 */
public class PasswordHelper {

    /**
     * jdk sha2
     */
    public static String jdkSHA2(String str1,String str2) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] mdRes = md.digest(str1.concat(str2).getBytes());

//            String shaBase64 = Base64.getEncoder().encodeToString(mdRes);
//            System.out.println("\r\njdk sha-512 base64编码显示：" + shaBase64);

            return Hex.toHexString(mdRes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
