package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.util.regex.Pattern.matches;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;

import org.jboss.resteasy.reactive.server.spi.RuntimeConfiguration.Body;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(containsString("Hello"));
    }
    @Test
    public void testNullnames(){
        given()
        .when().get("/hello")
        .then()
        .statusCode(200)
        .body(not(containsString("null")));
    }


}