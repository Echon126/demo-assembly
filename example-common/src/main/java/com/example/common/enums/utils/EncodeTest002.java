package com.example.common.enums.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

public class EncodeTest002 {

    public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
        // 编码
        byte data[] = "A".getBytes("UTF-8");
        char[] encodeData = Hex.encodeHex(data);
        String encodeStr = Hex.encodeHexString(data);
        System.out.println(new String(encodeData));
        System.out.println(encodeStr);
        // 解码
        byte[] decodeData = Hex.decodeHex(encodeData);
        System.out.println(new String(decodeData, "UTF-8"));
    }
}
