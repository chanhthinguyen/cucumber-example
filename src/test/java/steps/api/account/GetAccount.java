package steps.api;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;


public class GetAccount {

    RequestSpecification _RES_SPEC;

    @And("^PAI is generated successfully with status \"([^\"]*)\"$")
    public void paiIsGeneratedSuccessfullyWithStatus(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions


    }

    @And("^Get Account Info return MOP \"([^\"]*)\"$")
    public void getAccountInfoReturnMOP(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions




    }

    @And("^Get Account Info with PDI \"([^\"]*)\" return MOP \"([^\"]*)\"$")
    public void getAccountInfoWithPDIReturnMOP(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        JsonPath jsonPathEvaluator;


        // Write code here that turns the phrase above into concrete actions

        RestAssured.baseURI = "https://gcp-dmp-netflixpi-nonprod.el.r.appspot.com";

        ResponseBody responseBody = RestAssured.given()
                .header("x-netflix-partnerdeviceidentifier",arg0)
                .when()
                .get("/netflix/v1/accounts");

        Response response = (Response) responseBody;

        jsonPathEvaluator = response.jsonPath();

        Boolean mopValue = jsonPathEvaluator.getBoolean("Capabilities[1].value");

        Assert.assertEquals(arg1,mopValue.toString());
    }


}