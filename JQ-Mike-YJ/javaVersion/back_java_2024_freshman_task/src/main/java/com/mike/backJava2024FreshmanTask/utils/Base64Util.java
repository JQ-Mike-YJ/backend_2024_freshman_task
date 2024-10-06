package com.mike.backJava2024FreshmanTask.utils;

import com.mike.backJava2024FreshmanTask.common.error.BusinessException;
import com.mike.backJava2024FreshmanTask.common.error.QuestionAnswerBusinessError;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;

/**
 * Base64 加解密 工具类
 */
public class Base64Util {

    /**
     * 工具类构造方法私有化
     */
    private Base64Util() {
    }

    /**
     * Base64
     *
     * @param str 字符串
     */
    public static void base64(String str) {
        byte[] bytes = str.getBytes();

        //Base64 加密
        String encoded = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Base 64 加密后：" + encoded);

        //Base64 解密
        byte[] decoded = Base64.getDecoder().decode(encoded);

        String decodeStr = new String(decoded);
        System.out.println("Base 64 解密后：" + decodeStr);

        System.out.println();
    }

    /**
     * BASE64解密
     */
    public static String decrypt(String key) throws BusinessException {
        try {
            return new String((new BASE64Decoder()).decodeBuffer(key));
        } catch (IOException e) {
            throw new BusinessException(QuestionAnswerBusinessError.UNKNOWN_ERROR, "密码解密失败");
        }
    }

    /**
     * BASE64加密
     */
    public static String encrypt(String key) {
        String encodeBuffer = (new BASE64Encoder()).encodeBuffer(key.getBytes());
        return encodeBuffer.replaceAll("[\r\n]", "");
    }
}