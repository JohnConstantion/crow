package org.john.crow.common.enums;

/**
 * 是否 枚举
 * @author johnconstantine
 */
public enum YesOrNo {
    /**否*/
    NO(0, "否"),
    /** 是*/
    YES(1, "是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
