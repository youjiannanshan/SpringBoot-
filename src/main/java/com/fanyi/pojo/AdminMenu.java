package com.fanyi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @JsonIgnoreProperties({"handler", "hibernateLazyInitializer"}):
 *      使用 jpa 来做实体类的持久化时，jpa 默认会使用 hibernate, 在 jpa 工作过程中，就会创造代理类来继承 这个数据对象 ，
 *      并添加 handler 和 hibernateLazyInitializer 这两个无须 json 化的属性，
 *      所以这里需要用 JsonIgnoreProperties 把这两个属性忽略掉
 *
 * @GeneratedValue(strategy = GenerationType.IDENTITY):
 *      IDENTITY：主键由数据库自动生成（主要是自动增长型）
 *
 * 数据库中不存在对应字段的属性，需要用 @Transient 注记标注出来
 */
@Data
@Entity
@Table(name = "admin_menu")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Menu access path.
     */
    private String path;

    /**
     * Menu name.
     */
    private String name;

    /**
     * Menu name in Chinese.
     */
    private String nameZh;

    /**
     * Menu icon class(use element-ui icons).
     */
    private String iconCls;

    /**
     * Front-end component name corresponding to menu.
     */
    private String component;

    /**
     * Parent menu.
     */
    private int parentId;

    /**
     * Transient property for storing children menus.
     */
    @Transient
    private List<AdminMenu> children;
}
