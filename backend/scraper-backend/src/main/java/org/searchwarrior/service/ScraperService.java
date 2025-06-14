package org.searchwarrior.service;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.searchwarrior.dto.CardDTO;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ScraperService {

    String Failed_To_Scrape = "Failed to scrape due {}";

    public List<CardDTO> scrapedCards(String url) {

        List<CardDTO> cards = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select("a.one-list-rnlgjs");

            for (Element el : elements) {
                String title = el.attr("title").trim();
                String link = el.absUrl("href");

                if (!title.isEmpty() && !link.isEmpty()) {
                    CardDTO card = new CardDTO();
                    card.setTitle(title);
                    card.setLink(link);

                    cards.add(card);

                }

                // cards.add(new CardDTO(title, imageUrl, description));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.info(e.getMessage());
        }
        return cards;
    }
}
