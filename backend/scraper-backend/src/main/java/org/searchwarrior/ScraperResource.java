package org.searchwarrior;

import java.util.Arrays;
import java.util.List;

import org.searchwarrior.dto.CardDTO;
import org.searchwarrior.dto.ScrappedCard;
import org.searchwarrior.service.ScraperService;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/scrape")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScraperResource {

    @Inject
    ScraperService scraperService;

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public List<ScrappedCard> scrape(@QueryParam("query") String query) {
    // return Arrays.asList(new ScrappedCard("Sample Video",
    // "http://example.com/image.jpg", "A cool video"
    // // List.of("sample", "test")
    // ));
    // }

    @GET
    public List<CardDTO> scrape(@QueryParam("url") String url) {
        if (url == null || url.isBlank()) {
            url = "https://bangbros.com/videos";
        }
        return scraperService.scrapedCards(url);

    }

}
