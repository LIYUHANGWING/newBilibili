package com.example.biliE.Dao;

import com.example.biliE.bean.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDao {
    public List<Video> getVideoList();
}
