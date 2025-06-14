package org.searchwarrior.dto;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ScrappedCardTest {

    @Test
    public void testScrapeEndpoint() {
        RestAssured.given()
                .queryParam("query", "bangbros")
                .when()
                .get("/scrape")
                .then()
                .statusCode(200)
                .body("$", not(empty()))
                .body("[0].title", notNullValue())
                .body("[0].imgUrl", startsWith("http"))
                .body("[0].description", notNullValue());
    }
}
