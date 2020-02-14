package com.bdu.jiajiao.pojo;

import java.util.Date;

/**
 * @author 123
 * @create 2020/1/3
 * @since 1.0.0
 */
public class Comment {

    private int id;
    private int parentId;
    private int commentatorId;//评论人ID
    private String commentator;//评论人姓名
    private Date creatTime;
    private String content;
    private String item;//科目
    private String overview;//综合评价

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getCommentatorId() {
        return commentatorId;
    }

    public void setCommentatorId(int commentatorId) {
        this.commentatorId = commentatorId;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", commentatorId=" + commentatorId +
                ", commentator='" + commentator + '\'' +
                ", creatTime=" + creatTime +
                ", content='" + content + '\'' +
                ", item='" + item + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
