package com.lzhijin.blog.entity;

import java.io.Serializable;

/**
 * <p>
 * 标签类型表
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-26
 */
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    private String id;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 标签描述
     */
    private String describe;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Label{" +
            "id=" + id +
            ", labelName=" + labelName +
            ", describe=" + describe +
        "}";
    }
}
