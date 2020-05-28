package steps.api;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetPurchase {

  public static Common common = new Common();

  public static JsonPath jsonPathEvaluator;

    @And("^Purchase is generated for \"([^\"]*)\" account$")
    public void purchaseIsGeneratedForAccount(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        JsonPath subscriber_infor = common.getSubscriber(arg0);

        String subscriber_id = subscriber_infor.getString("id");

        String jwt = common.getJWTToken(arg0);

        // Write code here that turns the phrase above into concrete actions

        RestAssured.baseURI = "https://dmpapi2.trueid-alpha.net";

        ResponseBody responseBody =
                RestAssured.given()
                        .header("Authorization", jwt)
                        .header("Content-Type", "application/json")
                        .header("X-Authorization", "5aaf63b82bb5f2517d87a80100e3064946cd4d909e4b04de22bd114a")
                        .when()
                        .get("/netflix-customertest/v1/subscribers/" + subscriber_id + "/purchases");

        Response response = (Response) responseBody;

        jsonPathEvaluator = response.jsonPath();
    }

    @And("^Purchase should be successful$")
    public void purchaseShouldBeSuccessful() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
