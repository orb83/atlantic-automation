package api_test_RESTassured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GETtestWithPathVariable {
    private static final Logger LOGGER = LogManager.getLogger(GETtestWithPathVariable.class);

    @Test
    public void getSingleUser(){

        LOGGER.info("......API Test: Get Single User with Path Variable.......");

        //Base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest = RestAssured.given();

        //Make a request to the server by specifying the method type
       // Response response = httpRequest.queryParam("id","2").request(Method.GET); // pass query: {{base_url}}/api/users/:id=2
           //or
        String id="3";
        Response response = httpRequest.request(Method.GET,"3");
        LOGGER.debug(response.getBody().asString());
        //LOGGER.debug(response.getBody().prettyPrint());

        // Assert that the correct status is returned
        Assert.assertEquals(response.getStatusCode(),200);

        // Get the JsonPath object instance from the response
        JsonPath jsonPath = response.jsonPath();

        // Validate that a specific user email does exist in the response body
        String actualEmailId = jsonPath.getString("data.email");
        String expectedEmail = "emma.wong@reqres.in";

        Assert.assertEquals(actualEmailId,expectedEmail);

        LOGGER.info("......End Test: Get All Users with Query Parameter.....");
    }
}
