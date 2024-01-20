package com.example.biliE.controller;


import com.example.biliE.Dao.CommentDao;
import com.example.biliE.bean.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentDao dmCometDao;

    @RequestMapping("/send")
    public String send(@RequestBody Comment comment){
        dmCometDao.sendCommentToMysql(comment.getId(), comment.getUsername(),
                comment.getComment(), comment.getTime(), comment.getColor(), comment.getIsuse());
        return "okk";
    }

    @GetMapping("/comment")
    public List<Comment> getDM(@RequestParam(value = "id") String id) {
        return dmCometDao.selectComment(id);
    }
}
