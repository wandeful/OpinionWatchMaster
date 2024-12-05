package com.xnyesf.opinion.enums;

/**
 * @author CaoLiangBin
 * @date 2024年12月04日 23:03
 */
public enum DataSourceEnum {
    /**
     * 新浪微博
     */
    SINA("sina"),

    /**
     * 政府门户
     */
    GOVERNMENT_PORTAL("governmentPortal"),

    /**
     * 郴州新闻
     */
    CHEN_ZHOU_NEWS("chenzhouNews"),

    UNKNOWN("unknown"),
    ;



    private String source;

    DataSourceEnum(String source) {
        this.source = source;
    }

    /**
     * 获取枚举来源
     * @return 数据来源
     */
    public String getSource(){
        return this.source;
    }

    /**
     * 获取source对应的枚举类
     * @param source
     * @return 枚举类
     */
    public static DataSourceEnum getBySource(String source){
        for(DataSourceEnum ds : DataSourceEnum.values()){
            if(ds.getSource().equals(source)){
                return ds;
            }
        }
        return UNKNOWN;
    }
}
