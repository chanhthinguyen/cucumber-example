package steps.api;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

public class GetSubscriber {

    public static ResponseBody responseBody;

    public static Response response;

    public static JsonPath jsonPathEvaluator;

    public static Common common = new Common();

    @And("^Subscriber has \"([^\"]*)\" status with amount (\\d+) and package_plan \"([^\"]*)\"$")
    public void subscriberHasStatusWithAmountAndPackage_plan(String arg0, int arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String status = jsonPathEvaluator.getString("status");
        Float amount = (jsonPathEvaluator.getFloat("amount"))/100;
        String package_plan = jsonPathEvaluator.getString("package_plan");

        //Assert.assertEquals(arg0,status); -- Waiting for Netflix return value from Netflix Simulator
        Assert.assertEquals(arg1,amount,0);
        Assert.assertEquals(arg2,package_plan);
    }

    @And("^Subscriber is generated for \"([^\"]*)\" account$")
    public void subscriberIsGeneratedForAccount(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        jsonPathEvaluator= common.getSubscriber(arg0);
    }

    @And("^Waiting for subscriber is created$")
    public void waitingForSubscriberIsCreated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(120000);
    }
}