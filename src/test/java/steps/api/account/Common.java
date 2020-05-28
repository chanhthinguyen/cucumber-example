package steps.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Common {

    public String getJWTToken(String userType){

        String jwt;

        String payload;

        if (userType.equalsIgnoreCase("postpaid")){

            payload = "{\n" +
                    "\t\"device_id\":\"\",\n" +
                    "\t\"device_model\":\"STI6030_TRUE_TV_A01\",\n" +
                    "\t\"grant_type\":\"password\",\n" +
                    "\t\"ip_address\":\"124.122.128.116\",\n" +
                    "\t\"latlong\":\"13.6850312,100.6110911\",\n" +
                    "\t\"password\":\"TmV0ZmxpeC45Njc2\",\n" +
                    "\t\"product\":\"ott\",\n" +
                    "\t\"scope\":\"public_profile,email,references\",\n" +
                    "\t\"username\":\"0942199676\"\n" +
                    "}";
        }
        else{

            payload = "{\n" +
                    "\t\"device_id\":\"\",\n" +
                    "\t\"device_model\":\"STI6030_TRUE_TV_A01\",\n" +
                    "\t\"grant_type\":\"password\",\n" +
                    "\t\"ip_address\":\"124.122.128.116\",\n" +
                    "\t\"latlong\":\"13.6850312,100.6110911\",\n" +
                    "\t\"password\":\"UGF5bWVudDIjIw==\",\n" +
                    "\t\"product\":\"ott\",\n" +
                    "\t\"scope\":\"public_profile,email,references\",\n" +
                    "\t\"username\":\"0829808132\"\n" +
                    "}";

        }


        RestAssured.baseURI = "https://dmpapi2.trueid.net/aaa-iwedia/v4/oauth2/token";
        ResponseBody responseBody =
                RestAssured.given()
                        .header(
                                "Authorization", "Bearer 5aaf9ade15afe0324400baccbb003e59dcae403bb9743cf544075a32")
                        .header("Content-Type", "application/json")
                        .body(payload)
                        .when()
                        .post();

        JsonPath jsonPathEvaluator = responseBody.jsonPath();

        jwt = jsonPathEvaluator.get("access_token");

        return jwt;
    }

    public JsonPath getSubscriber(String userType){

        JsonPath jsonPathEvaluator;

        String jwt = getJWTToken(userType);


        // Write code here that turns the phrase above into concrete actions

        RestAssured.baseURI = "https://dmpapi2.trueid-alpha.net";

        ResponseBody responseBody = RestAssured.given()
                .header("Authorization",jwt)
                .header("Content-Type","application/json")
                .header("X-Authorization","5aaf63b82bb5f2517d87a80100e3064946cd4d909e4b04de22bd114a")
                .when()
                .get("/netflix-customertest/v1/subscribers");

        Response response = (Response) responseBody;

        jsonPathEvaluator = response.jsonPath();

        return jsonPathEvaluator;


    }
}