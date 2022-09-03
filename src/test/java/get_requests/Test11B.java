package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utils.AuthenticationB;

import static io.restassured.RestAssured.given;

public class Test11B extends AuthenticationB {
    //Authentication Class'ın içindeki generate token metodu kullanılacak.
    String endPoint = "http://www.gmibank.com/api/tp-customers";

    @Test
    public void Test11B(){
        Response response = given()
                .header("Authorization","Beraer " + generateToken())
                .when()
                .get(endPoint).then().extract().response();
        response.prettyPrint();

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);


    }
}
