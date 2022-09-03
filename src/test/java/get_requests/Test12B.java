package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utils.AuthenticationB;
import utils.AuthenticationB2;

import static io.restassured.RestAssured.given;

public class Test12B extends AuthenticationB2 {
    //Authentication Class'ın içindeki generate token metodu kullanılacak.
    String endPoint = "https://www.medunna.com/api/appointments";

    @Test
    public void Test11B(){
        Response response = given()
                .headers("Authorization","Beraer " + generateToken(),
                        "Content-Type",ContentType.JSON,"Accept",ContentType.JSON)
                .when().get(utilities.ConfigReader.getProperty("appointments_endpoint"));


        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);


    }
}
