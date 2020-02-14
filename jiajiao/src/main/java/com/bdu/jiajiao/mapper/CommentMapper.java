package com.bdu.jiajiao.mapper;

import com.bdu.jiajiao.pojo.Comment;

import java.util.List;

/**
 * @author 123
 * @version 1.0
 * @date 2020 2020/1/3 17:41
 */
public interface CommentMapper {

    List<Comment> queryCommentByParentId(int parentId);

    int addComment(Comment comment);

    int countComment(int id);
}
