package com.example.aprilianti.aprilianti_1202150276_m3;

/**
 * Created by Aprilianti on 2/24/2018.
 */

public class Water {
    String title, description, detail;
    int image;

    public Water(String title, String description, String detail, int image) {
        this.title = title;
        this.description = description;
        this.detail = detail;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDetail() {
        return detail;
    }

    public int getImage() {
        return image;
    }
}
