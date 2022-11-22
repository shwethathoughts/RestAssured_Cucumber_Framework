package stepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URI;
public class StepDef {

	 private Scenario scenario;
	    private Response response;
	    private final String BASE_URL = "http://localhost:3000";

	    @Before
	    public void before(Scenario scenarioVal) {
	        this.scenario = scenarioVal;
	    }

	    @Given("Get Call to {string}")
	    public void get_call_to_url(String url) throws Exception {
	    	
	    	scenario.log(" ************** Validation of getNaceDetails ************************");
	        RestAssured.baseURI = BASE_URL;
	        RequestSpecification req = RestAssured.given();
	        response = req.when().get(new URI(url));
	    }

	    @Then("Response Code {string} is validated")
	    public void response_is_validated(String responseMessage) {
	        int responseCode = response.then().extract().statusCode();
	        Assert.assertEquals(responseMessage, responseCode+"");
	    }

	        @Then("the Response Body is validated")
	        public void the_response_body_is_validated() {
	            // Write code here that turns the phrase above into concrete actions
	        	
	        	// First get the JsonPath object instance from the Response interface
	        	JsonPath jsonPathEvaluator = response.jsonPath();
	        	String id = jsonPathEvaluator.get("id");
	        	String level = jsonPathEvaluator.get("level");
	        	String code = jsonPathEvaluator.get("code");
	        	String parent = jsonPathEvaluator.get("parent");
	        	String description = jsonPathEvaluator.get("description");
	        	String thisItemInclude = jsonPathEvaluator.get("thisItemInclude");
	        	String thisItemAlsoIncludes = jsonPathEvaluator.get("thisItemAlsoIncludes");
	        	String rulings = jsonPathEvaluator.get("rulings");
	        	String thisItemExcludes = jsonPathEvaluator.get("thisItemExcludes");
	        	String reference = jsonPathEvaluator.get("reference");
	        
	        	// Validate the response
	        	Assert.assertEquals(id, "398481");
	        	Assert.assertEquals(level, "1");
	        	Assert.assertEquals(code, "A");
	        	Assert.assertEquals(parent, "");
	        	Assert.assertEquals(description, "AGRICULTURE, FORESTRY AND FISHING");
	        	Assert.assertEquals(thisItemInclude, "This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats.");
	        	Assert.assertEquals(thisItemAlsoIncludes, "");
	        	Assert.assertEquals(rulings, "");
	        	Assert.assertEquals(thisItemExcludes, "");
	        	Assert.assertEquals(reference, "A");
	        	
	       
	        }
}


	    



