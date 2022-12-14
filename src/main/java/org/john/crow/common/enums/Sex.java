package org.john.crow.common.enums;

public enum Sex {
    /**
     * 女
     */
    WOMAN(0, "女"),
    /**
     * 男
     */
    MAN(1, "男"),
    /**
     * 保密
     */
    SECRET(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
