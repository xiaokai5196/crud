package com.dict.emp.common;

import java.util.UUID;

public class UUIDUtil {

    public static String generatorUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
