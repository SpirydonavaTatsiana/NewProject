import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTestPostRaw {

    @Test
    public void testPostRawRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .extract()
                .response();

        response.then().statusCode(200);

        response.then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", startsWith("text/plain"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", equalTo(null))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}