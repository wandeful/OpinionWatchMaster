package com.xnyesf.opinion.util.log;

import org.slf4j.Logger;

/**
 * @author CaoLiangBin
 * @date 2024年12月09日 22:50
 * @description 日志工具类
 */
public class LogUtil {

    public static void info(Logger logger, String message){
        logger.info(message);
    }

    public static void warn(Logger logger, String message){
        logger.warn(message);
    }

    public static void error(Logger logger, String message, Throwable throwable){
        logger.error(message, throwable);
    }

    public static void debug(Logger logger, String message){
        logger.debug(message);
    }

    public static void info(Logger logger, String format, Object... args){
        logger.info(format, args);
    }

    public static void warn(Logger logger, String format, Object... args){
        logger.warn(format, args);
    }

    public static void error(Logger logger, Throwable throwable ,String format, Object... args){
        logger.error(String.format(format, args), throwable);
    }


    public static void error(Logger logger, String format, Object... args) {
        logger.error(String.format(format, args));
    }

    public static void debug(Logger logger, String format, Object... args){
        logger.debug(format, args);
    }

}
