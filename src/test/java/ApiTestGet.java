import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTestGet {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .queryParam("foo1", "bar1") // передаем параметр foo1
                .queryParam("foo2", "bar2") // передаем параметр foo2
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        response.then().statusCode(200);

        response.then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.21)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", equalTo(null))
                .body("headers.postman-token", equalTo(null))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.cookie", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
}