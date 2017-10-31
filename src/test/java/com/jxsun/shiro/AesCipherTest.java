package com.jxsun.shiro;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

/**
 * 对称AES加密
 */
public class AesCipherTest {

    @Test
    public void test(){
        AesCipherService service = new AesCipherService();
        service.setKeySize(128);

        Key key = service.generateNewKey();
        String text = "helloworld";

        String encrptText = service.encrypt(text.getBytes(),key.getEncoded()).toHex();

        String decrptText = new String(service.decrypt(Hex.decode(encrptText),key.getEncoded()).getBytes());

        Assert.assertEquals(text,decrptText);
    }
}
