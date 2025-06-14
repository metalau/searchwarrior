package com.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class ScraperResourceTest {

    @Test
    public void testScrapeEndpoint() {
        given()
                .queryParam("url", "https://bangbros.com/videos")
                .when()
                .get("/scrape")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

}