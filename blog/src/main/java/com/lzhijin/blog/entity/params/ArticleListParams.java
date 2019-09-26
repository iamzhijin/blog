package com.lzhijin.blog.entity.params;

public class ArticleListParams extends PageParams{

    /** 标签类型ID */
    private String labelId;

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
}
