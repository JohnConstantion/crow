package org.john.crow.pojo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品
 *
 * @author johnconstantine
 */
@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类类型
     */
    private Integer type;

    /**
     * 父id
     */
    private Integer fatherId;

    /**
     * 图标
     */
    private String logo;

    /**
     * 口号
     */
    private String slogan;

    /**
     * 分类图
     */
    private String catImage;

    /**
     * 背景颜色
     */
    private String bgColor;
}
