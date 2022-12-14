package utils;


//bunu ben yaptım


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationB {
    public static void main(String[] args) {
        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }
    public static String generateToken() {
        String username = "Batch44Api";
        String password = "Batch44+";

        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        String endpoint = "https://www.gmibank.com/api/authenticate";

        Response response = given().contentType(ContentType.JSON).body(map).when().post(endpoint);
        JsonPath token = response.jsonPath();
        return token.getString("id_token");


    }
}
