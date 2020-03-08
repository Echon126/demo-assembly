package com.example.service.config;

public enum RedisChannelEnums {

    /**redis频道名称定义 需要与发布者一致*/
    LIVE_INFO_CHANGE("LIVE_INFO_CHANGE", LiveChangeSub.class, "直播信息改变"),

    ;
    /** 枚举定义+描述 */
    private String code;
    private Class<? extends BaseSub> className;
    private String description;

    RedisChannelEnums(String code, Class<? extends BaseSub> className, String description) {
        this.code = code;
        this.className=className;
        this.description = description;
    }


    /** 根据code获取对应的枚举对象 */
    public static RedisChannelEnums getEnum(String code) {
        RedisChannelEnums[] values = RedisChannelEnums.values();
        if (null != code && values.length > 0) {
            for (RedisChannelEnums value : values) {
                if (value.code == code) {
                    return value;
                }
            }
        }
        return null;
    }

    /** 该code在枚举列表code属性是否存在 */
    public static boolean containsCode(String code) {
        RedisChannelEnums anEnum = getEnum(code);
        return anEnum != null;
    }

    /** 判断code与枚举中的code是否相同 */
    public static boolean equals(String code, RedisChannelEnums calendarSourceEnum) {
        return calendarSourceEnum.code == code;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Class<? extends BaseSub> getClassName() {
        return className;
    }
}