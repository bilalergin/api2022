package get_requests;

import base_urls.MedunnaBaseUrlB;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestB13 extends MedunnaBaseUrlB {
    @Test
    public void test13(){
        spec.pathParams("bir","appointments");
        Response response = given().spec(spec).
                            header("Authorization",
                           "Beraer " + generateToken()).when().get("/{bir}");
        response.prettyPrint();


    }
}
