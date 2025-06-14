package org.searchwarrior.dto;

public class CardDTO {
    public String title;
    // public String imgUrl;
    // public String description;
    public String link;

    public CardDTO() {
    }

    // public CardDTO(String title, String imgUrl, String description) {
    public CardDTO(String title, String link) {
        this.title = title;
        this.link = link;
        // this.imgUrl = imgUrl;
        // this.description = description;

    }

    public void setTitle(String title) {
        // TODO Auto-generated method stub
        this.title = title;
    }

    public void setLink(String link) {
        // TODO Auto-generated method stub
        this.link = link;
    }

}
