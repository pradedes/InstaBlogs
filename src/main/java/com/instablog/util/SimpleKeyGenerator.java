package com.instablog.util;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

public class SimpleKeyGenerator implements KeyGenerator {

    @Override
    public Key generateKey() {
        String keyString = "simplekey_abcdefgh";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}