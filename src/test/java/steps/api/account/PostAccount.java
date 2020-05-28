package steps.api;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

public class PostAccount {

    ResponseBody responseBody;

    Response response;

    JsonPath jsonPathEvaluator;

    String jwt;

    Common common = new Common();

    @Given("^Netflix Middleware API is up and running$")
    public void netflix_Middleware_API_is_up_and_running() throws Throwable {

        RestAssured.baseURI = "https://dmpapi2.trueid-alpha.net";
    }

    @Then("^POST account API return with status code as (\\d+)$")
    public void post_account_API_return_with_status_code_as(int arg1) throws Throwable {
        Assert.assertEquals(201,response.getStatusCode());
    }

    @And("^Verify body have id as \"([^\"]*)\"$")
    public void verifyBodyHaveIdAs(String arg0) throws Throwable {
        String id = jsonPathEvaluator.get("id");
        Assert.assertEquals(arg0,id);

    }

    @And("^Verify body have token as \"([^\"]*)\"$")
    public void verifyBodyHaveTokenAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String token = jsonPathEvaluator.get("token");
        Assert.assertEquals(arg0,token);
    }

    @And("^Verify body have pdi as \"([^\"]*)\"$")
    public void verifyBodyHavePdiAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String pdi = jsonPathEvaluator.get("pdi");
        Assert.assertEquals(arg0,pdi);
    }

    @And("^Verify body have created as \"([^\"]*)\"$")
    public void verifyBodyHaveCreatedAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String created = jsonPathEvaluator.get("created");
        Assert.assertEquals(arg0,created);
    }

    @And("^Verify body have updated as \"([^\"]*)\"$")
    public void verifyBodyHaveUpdatedAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String updated = jsonPathEvaluator.get("updated");
        Assert.assertEquals(arg0,updated);
    }

    @And("^Get JWT token of \"([^\"]*)\" account from OTT$")
    public void getJWTTokenOfAccountFromOTT(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        jwt = common.getJWTToken(arg0);
    }

    @When("^User submit POST account with PDI \"([^\"]*)\"$")
    public void userSubmitPOSTAccountWithPDI(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String payload = "{" + '"' + "pdi" + '"' + ":" + '"' + arg0 + '"' + "}";
        RestAssured.baseURI = "https://dmpapi2.trueid-alpha.net";

        responseBody = RestAssured.given()
                .header("Authorization",jwt)
                .header("Content-Type","application/json")
                .header("X-Authorization","5aaf63b82bb5f2517d87a80100e3064946cd4d909e4b04de22bd114a")
                .body(payload)
                .when()
                .post("/netflix-customertest/v1/accounts");

        response = (Response) responseBody;

        jsonPathEvaluator = response.jsonPath();
    }
}