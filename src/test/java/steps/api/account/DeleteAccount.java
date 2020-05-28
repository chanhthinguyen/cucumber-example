package steps.api;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

public class DeleteAccount {

    public static Common common = new Common();
    @And("^Clean data test of \"([^\"]*)\" account$")
    public void cleanDataTestOfAccount(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        String jwt = common.getJWTToken(arg0);
        RestAssured.baseURI = "https://dmpapi2.trueid-alpha.net";

        ResponseBody responseBody = RestAssured.given()
                .header("Authorization",jwt)
                .header("Content-Type","application/json")
                .header("X-Authorization","5aaf63b82bb5f2517d87a80100e3064946cd4d909e4b04de22bd114a")
                .when()
                .delete("/netflix-customertest/v1/accounts");

        Response response = (Response) responseBody;

        Assert.assertEquals(200, response.getStatusCode());


    }
}