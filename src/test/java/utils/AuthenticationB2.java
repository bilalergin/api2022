package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationB2 {
    public static String generateToken() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("username", "bergin");
        data.put("password", "ABCDEF");
        data.put("rememberMe", true);

        spec.pathParams("ilk", "api", "iki", "authenticate");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(data).when().post("/{ilk}/{iki}");


        JsonPath json = response.jsonPath();
        System.out.println("token : " + json.getString("id_token"));

        return json.getString("id_token");

    }
}
