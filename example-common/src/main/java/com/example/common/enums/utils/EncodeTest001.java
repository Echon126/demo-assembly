package com.example.common.enums.utils;

import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;

public class EncodeTest001 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 编码
        byte data[] = "A".getBytes("UTF-8");
        byte[] encodeData = Hex.encode(data);
        String encodeStr = Hex.toHexString(data);
        System.out.println(new String(encodeData, "UTF-8"));
        System.out.println(encodeStr);
        // 解码
        byte[] decodeData = Hex.decode(encodeData);
        byte[] decodeData2 = Hex.decode(encodeStr);
        System.out.println(new String(decodeData, "UTF-8"));
        System.out.println(new String(decodeData2, "UTF-8"));
    }


}
