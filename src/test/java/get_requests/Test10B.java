package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Test10B {
    String endPoint = "https://www.medunna.com/api/appointments";
    String bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiZXJnaW4iLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY2MDY4MzA3OH0.7k-I4e6XsWFLGFuwjIZMr4TR9rWLBTUCJOtUJJnIciv3jUenuOqEO7Os-4r7L3m-XAQAuSVIn5WnSMSisAC2XQ";

    //bunu ben yaptım



    @Test
    public void test(){
        Response response= given().header("Authorization","Bearer "+ bearerToken).when()
                .get(endPoint).then().extract().response();

        response.prettyPrint();
    }



}
