package org.searchwarrior.dto;

import java.util.List;

public class ScrappedCard {
    public String title;
    public String imgUrl;
    public String description;
    public List<String> tags;

    public ScrappedCard() {
    }

    public ScrappedCard(String title,
            String imgUrl,
            String description
    // List<String> tags
    ) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.description = description;
        // this.tags = tags;
    }
}
