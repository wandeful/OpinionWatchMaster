package com.xnyesf.opinion.util;

import java.util.UUID;

/**
 * @author CaoLiangBin
 * @date 2024年12月05日 22:12
 */
public class UuidGenerator {
    /**
     * 生成UUID
     * @return uuid
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
