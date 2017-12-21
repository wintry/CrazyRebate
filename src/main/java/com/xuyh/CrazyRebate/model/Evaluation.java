package com.xuyh.CrazyRebate.model;

public class Evaluation {

    private int id;
    private int shareId;
    private int userId;
    private int score;
    private String content;
    private String img;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShareId() {
        return shareId;
    }

    public void setShareId(int shareId) {
        this.shareId = shareId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
