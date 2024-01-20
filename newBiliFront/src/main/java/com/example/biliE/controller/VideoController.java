package com.example.biliE.controller;

import com.example.biliE.Dao.VideoDao;
import com.example.biliE.bean.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    private VideoDao videoDao;

    @GetMapping("videolist")
    private List<Video> getVideoList(){
        return videoDao.getVideoList();
    }
}
