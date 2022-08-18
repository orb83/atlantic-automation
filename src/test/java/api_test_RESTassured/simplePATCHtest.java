package api_test_RESTassured;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simplePATCHtest {
    private static final Logger LOGGER = LogManager.getLogger(simplePATCHtest.class);

    @Test
    public void updateUserField(){
        LOGGER.info("----API Test: Update user's single field------");
        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Faker faker = new Faker();
//        String fullName = faker.name().fullName();
//        LOGGER.debug("New User full name: "+fullName);

        String userRole = faker.job().title();
        LOGGER.debug("User Job: "+userRole);

        JSONObject requestbody = new JSONObject();
       // requestbody.put("name",fullName);
        requestbody.put("job",userRole);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestbody.toJSONString());

        String id = "2";
        Response response = httpRequest.request(Method.PATCH,id);
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),200);

        JsonPath jsonPath = response.jsonPath();
        String actualName= jsonPath.getString("job");

        Assert.assertEquals(actualName,userRole);

        LOGGER.info("----End API Test: Update user's single field------");

    }
}
