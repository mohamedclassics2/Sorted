package stepdefs;

import gherkin.deps.com.google.gson.internal.LazilyParsedNumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RainfallAPISteps {

    String url = "https://environment.data.gov.uk/flood-monitoring/doc/rainfall";
    String endpoint;
    Response response;
    JSONObject obj;
    JSONArray arr;
    private Object limit;
    private LazilyParsedNumber expectedCount;

    @Given("I set the endpoint to {string}")
    public void i_set_the_endpoint_to(String string) {
        response = given().accept(ContentType.JSON)
                .when()
                .get(url + endpoint);
    }

    @When("I request the rainfall measurements with a limit of {int}")
    public void i_request_the_rainfall_measurements_with_a_limit_of(Integer int1) {
        response = given().queryParam("limit", limit)
                .when().get(endpoint);
    }

    @Then("the response should contain {int} measurements")
    public void the_response_should_contain_measurements(Integer int1) {
        response.then().statusCode(200);
        assertEquals(expectedCount.intValue(), response.jsonPath().getList("measurements").size());
    }
}