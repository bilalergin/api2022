package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utils.AuthenticationB;
import utils.AuthenticationB2;

public class MedunnaBaseUrlB extends AuthenticationB {
    protected RequestSpecification spec;
    @Before
    protected void setUp(){

        spec =new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();
    }
}
