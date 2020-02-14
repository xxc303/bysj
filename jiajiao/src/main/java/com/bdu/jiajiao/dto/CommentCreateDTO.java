package com.bdu.jiajiao.dto;

import javax.swing.text.StringContent;

/**
 * @author 123
 * @create 2020/1/7
 * @since 1.0.0
 */
public class CommentCreateDTO {

    private int parentId;
    private String item;
    private String Content;
    private String overview;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "CommentCreateDTO{" +
                "parentId=" + parentId +
                ", item='" + item + '\'' +
                ", Content='" + Content + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
