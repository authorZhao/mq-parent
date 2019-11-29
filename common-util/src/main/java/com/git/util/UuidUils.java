package com.git.util;

import java.util.UUID;

public class UuidUils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
