package com.rimi.Hospitals.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 密码加密
 *
 * @author shangzf
 * @date 2019/9/18 10:19
 */
public class PwdUtils {

    /**
     * 盐
     */
    private static final String SALT = "87kreo9g8us898erwh$$$3726&*@(*#DSAJ";

    public static String getPwd(String source) {
        // 使用MD5 hash算法
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] digest1 = digest.digest((source + SALT).getBytes());
            // 把加密后的字节转换成字符串
            return Base64.getEncoder().encodeToString(digest1);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
