package com.animo.common.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);
        return uuid;
    }

    public static void main(String[] args) {
        UUIDUtils.getUUID();
    }

}
