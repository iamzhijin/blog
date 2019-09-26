package com.lzhijin.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 博文表
 * </p>
 *
 * @author lzhijin
 * @since 2019-09-23
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博文ID
     */
    private String id;

    /**
     * 发表用户ID
     */
    private String userId;

    /**
     * 博文标题
     */
    private String title;

    /**
     * 博文内容
     */
    private String content;

    /**
     * 浏览量
     */
    private Long views;

    /**
     * 评论总数
     */
    private Long commentCount;

    /**
     * 发表时间
     */
    private LocalDateTime publishDate;

    /**
     * 点赞数
     */
    private Long likeCount;

    /**
     * 是否发布 0-否 1-是
     */
    private Integer isPublish;

    /** 是否删除 0-否 1-是 */
    private Integer deletable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
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
    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }
    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getDeletable() {
        return deletable;
    }

    public void setDeletable(Integer deletable) {
        this.deletable = deletable;
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", userId=" + userId +
            ", title=" + title +
            ", content=" + content +
            ", views=" + views +
            ", commentCount=" + commentCount +
            ", publishDate=" + publishDate +
            ", likeCount=" + likeCount +
        "}";
    }
}
