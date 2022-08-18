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

public class SimpleGetTest {

    private static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);

    @Test
    public void getAllUsers(){

        LOGGER.info("..........API Test: Get All Users...............");

        //Base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        // Get the RequestSpecification of the request that I want to send to the server
        RequestSpecification httpRequest = RestAssured.given();

        //Make a request to the server by specifying the method type
        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.getBody().asString());
        //LOGGER.debug(response.getBody().prettyPrint());

        // Assert that the correct status is returned
        Assert.assertEquals(response.getStatusCode(),200);

        // Get the JsonPath object instance from the response
        JsonPath jsonPath = response.jsonPath();
        List<String> list = jsonPath.get("data.email");
        System.out.println(list); // print all the email

        // Validate that a specific user email does exist in the response body
        //String emailId = "george.blue@reqres.in";
        String expectedEmail = "george.bluth@reqres.in";
        boolean emailExist = list.contains(expectedEmail);
        Assert.assertTrue(emailExist,expectedEmail+ " does not exist");

        LOGGER.info(".........End Test: Get All Users.......");
    }
}
