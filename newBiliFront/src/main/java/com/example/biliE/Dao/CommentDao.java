package com.example.biliE.Dao;

import com.example.biliE.bean.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    public void sendCommentToMysql(@Param("id") String id, @Param("username") String username, @Param("comment") String comment,
                                    @Param("time") String time, @Param("color") String color, @Param("isuse") String isuse);

    public List<Comment> selectComment(@Param("id") String id);
}
