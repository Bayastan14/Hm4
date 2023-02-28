package com.joma.notes;

import java.util.Date;

public class NoteModel {
    public NoteModel(String image, String title, String desc, Date date) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.date = date;
    }

    private String image;
    private String title;

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDate() {
        return date;
    }

    private String desc;
    private Date date;

}
