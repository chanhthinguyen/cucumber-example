package steps.api.account;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.matchers.JUnitMatchers.containsString;

public class GetAccount {

    RequestSpecification _RES_SPEC;

    @And("^PAI is generated successfully with status \"([^\"]*)\"$")
    public void paiIsGeneratedSuccessfullyWithStatus(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        _RES_SPEC = given().baseUri("https://dmpapi2.trueid-alpha.net");
        String jwt = "eyJraWQiOiJjNGNhNDIzOGEwYjkyMzgyMGRjYzUwOWE2Zjc1ODQ5YiIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiI3NjA1MTUwOCIsImRldmljZV9pZCI6IlVOS05PV04iLCJ0cnVlaWQiOnsibW9iaWxlIjoiMDk0MjE5OTY3NiIsImVtYWlsIjoidGVjaC5xYS50cnVlaWQudGVzdDAxQHRydWVkaWdpdGFsLmNvbSJ9LCJwdyI6IjEiLCJwcm9maWxlIjp7ImJpcnRoZGF5IjoiIiwiZ2VuZGVyIjoiMCIsInRydWVpZCI6eyJtb2JpbGUiOiIwOTQyMTk5Njc2IiwiZW1haWwiOiJ0ZWNoLnFhLnRydWVpZC50ZXN0MDFAdHJ1ZWRpZ2l0YWwuY29tIn0sImxhc3RfbmFtZSI6IiIsImxvZ2luX2J5X2FjY291bnQiOiIwOTQyMTk5Njc2IiwiY29udGFjdF9pbmZvIjp7ImFkZHJlc3MiOm51bGwsImNvbnRhY3RfbW9iaWxlIjoiMDk0MjE5OTY3NiIsImNvbnRhY3RfZW1haWwiOiJ0ZWNoLnFhLnRydWVpZC50ZXN0MDFAdHJ1ZWRpZ2l0YWwuY29tIn0sInZlcmlmaWVkX2VtYWlsIjowLCJhdmF0YXIiOiJodHRwczpcL1wvYXZhdGFyLmRtcGNkbi5jb21cL3AzMjB4MzIwXC8xNTA4XC83NjA1MTUwOC5wbmc_Y2hrPTAuMzk1MDMyMjIxNTk2NTgzMjQiLCJkaXNwbGF5X25hbWUiOiJOZXRmbGl4IDk2NzYiLCJ1aWQiOjc2MDUxNTA4LCJhY2NvdW50X2VtYWlsIjoidGVjaC5xYS50cnVlaWQudGVzdDAxQHRydWVkaWdpdGFsLmNvbSIsInJlZ19kYXRlIjoiMTU4Mjg3NjE3NSIsInJlZnMiOnsiYXNjZW5kIjp7InRydWVtb25leSI6eyJ0bW5faWQiOm51bGwsInVwZGF0ZWRfYXQiOm51bGwsImNyZWF0ZWRfYXQiOm51bGwsInN0YXR1cyI6bnVsbH19LCJ0cnVlY29ycCI6eyJ0cnVlaWQiOnsidGhhaWlkX3NlbGZfc3RhdHVzIjoiMCIsInRoYWlpZF9saW5rIjoiMzEwMjAwMjc5MzE3OCIsInRoYWlpZF9saW5rX3ZlcmlmaWVkX21ldGhvZCI6ImJpbGxpbmdfc3lzdGVtIiwidGhhaWlkX3NlbGZfdmVyaWZpZWRfbWV0aG9kIjoiIiwidGhhaWlkX3NlbGYiOiIiLCJ0aGFpaWRfbGlua19zdGF0dXMiOiIxIn19fSwiYWNjb3VudF9tb2JpbGUiOm51bGwsImZpcnN0X25hbWUiOiIifSwiaXNzIjoiaHR0cHM6XC9cL3Nkay1hdXRoLnRydWVpZC5uZXQiLCJhcGltX2FuIjoiVFRWc3QiLCJyZXFfaWQiOiIxNTg5NDQ0OTY4LTU4Ljk3LjEyMy4xMjYtZGRhNGFjZGUtMjk0Zi00MTExLTlkNmMtODViZWM0ZGRmMTI1IiwiYXVkIjoiMzcxIiwic2NvcGUiOiJwdWJsaWNfcHJvZmlsZSxlbWFpbCxyZWZlcmVuY2VzIiwidmVyaWZpZWRfZW1haWxfYWNjb3VudCI6IjAiLCJleHAiOjE1OTIwMzY5NjgsImlhdCI6MTU4OTQ0NDk2OCwidHJ1c3RlZF9vd25lciI6IjAiLCJ0emUiOnsidGltZXpvbmUiOiJBc2lhXC9CYW5na29rIiwidmFsdWUiOiI3IiwiZ210IjoiKzA3MDAifSwiYWNjb3VudCI6IjA5NDIxOTk2NzYiLCJhcGltX3BvIjoiNWFlYWU5M2MxNWFmZTA0NWNhMmUxMGMwIn0.QP9LvjN9XBxW2ykRV5EpF_LCctz3Zhtes9kCG2GjLwzY5ZzhJWOrq9JJYvF8OigPCovAz2vZa-VIDD9EnJXkGiHluxsFxbRwhPFdx9kU1FNDnCgUaLvMrfqKH_SISCC_tLHY8VRzj-3kmCseXOgaav8TVe6EeZoDktpTnyLEVHKfZHjB5HFfc4c5VMvcZsyOymrnRx1pDekX6uZ4ifYMBfeL9ceXG4fjP3zZncEGLfkjIN5miPZRPKHHeQxL8UT9zYdXvghdJAiDuTSXGUBc5cPlG8PTqB8l1LHWbifJp9C-RZUKeLe771Pkw0XvWjsk6M0NXllp1tMd_SXxIrPuIg";

        String pdi = "2nR5rKYELAs2B9XpWBrpI6KaB01";

        JSONObject body_Json = new JSONObject();
        body_Json.put("pdi",pdi);

        Map<String,String> headers = new HashMap<String, String>();
        headers.put("Authorization",jwt);
        headers.put("Content-Type","application/json");
        headers.put("X-Authorization","5aaf63b82bb5f2517d87a80100e3064946cd4d909e4b04de22bd114a");
        _RES_SPEC.headers(headers).when().get("/netflix-customertest/v1/accounts");

        _RES_SPEC.then().expect().body(containsString(arg0));

        _RES_SPEC.then().expect().body(containsString("7e500132-47f3-4b24-afe7-a18fc3e8bbe3"));
    }
}