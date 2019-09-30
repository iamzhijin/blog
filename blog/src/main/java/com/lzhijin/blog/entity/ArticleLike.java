package com.lzhijin.blog.entity;

import java.io.Serializable;

/**
 * <p>
 * 文章点赞收藏表
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-30
 */
public class ArticleLike implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章点赞ID
     */
    private String id;

    /**
     * 文章ID
     */
    private String articleId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户行为 1点赞 2收藏
     */
    private Integer behavior;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Integer getBehavior() {
        return behavior;
    }

    public void setBehavior(Integer behavior) {
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "ArticleLike{" +
            "id=" + id +
            ", articleId=" + articleId +
            ", userId=" + userId +
            ", behavior=" + behavior +
        "}";
    }
}
