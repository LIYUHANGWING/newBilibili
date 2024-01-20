package com.example.biliE.bean;

public class Comment {
    private String id;

    private String username;

    private String comment;

    private String time;

    private String color;

    private String isuse;

    public Comment() {
    }

    public Comment(String id, String username, String comment, String time, String color, String isuse) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.time = time;
        this.color = color;
        this.isuse = isuse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", time='" + time + '\'' +
                ", color='" + color + '\'' +
                ", isuse=" + isuse +
                '}';
    }
}
