package api_test_RESTassured;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simplePOSTtest {
    private static final Logger LOGGER = LogManager.getLogger(simplePOSTtest.class);

    @Test
    public void createNewUser(){

        LOGGER.info("----API Test: Create new user------");

         //endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest = RestAssured.given();

        // Create object of Faker class
        Faker faker = new Faker();
        String fullName = faker.name().fullName();   // want to create full name of user
        LOGGER.debug("New User full name: "+fullName);   // want to see full name of user

        String userRole = faker.job().title();   // want to create job title of user
        LOGGER.debug("User Job: "+userRole);

        JSONObject requestbody = new JSONObject();  // Create object of JsonObject class
        requestbody.put("name",fullName);  // Capture value into request body
        requestbody.put("job",userRole);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestbody.toJSONString());

        Response response = httpRequest.request(Method.POST);
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),201);
    }
}
