package com.lzhijin.blog.entity.params;

public class ArticleParams {

    /** 文章标题 */
    private String title;

    /** 文章内容 */
    private String content;

    /** 是否发布 0-否 1-是 */
    private Integer isPublish;

    /** 标签Id */
    private String labelId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
}
