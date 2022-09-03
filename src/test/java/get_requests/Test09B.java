package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Test09B extends DummyRestApiBaseUrl {

    //bunu ben yaptım
    @Test
    public void test09(){
        spec.pathParams("first","employee","second","12");
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("data.employee_name",equalTo("Quinn Flynn"),
                        "data.employee_salary",equalTo(342000),"data.employee_age",equalTo(22));
        JsonPath json = response.jsonPath();
        System.out.println(json.getString("data.employee_name"));
        System.out.println(json.getInt("data.employee_age"));
        System.out.println(json.getInt("data.employee_salary"));

        assertEquals("Quinn Flynn",json.getString("data.employee_name"));
        assertEquals(342000,json.getInt("data.employee_salary"));
        assertEquals(22,json.getInt("data.employee_age"));

    }

}
