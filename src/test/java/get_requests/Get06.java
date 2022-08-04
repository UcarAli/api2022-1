package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkuAppBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
        }
     */
    @Test
    public void get01(){
        //1. Step: Set the Url
        spec.pathParams("first","booking","second", 555);
        //2. Step: Set the exppected data

        //3. Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion

        //1. Way:
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Sally"),
                      "lastname", equalTo("Brown"),
                        "totalprice",equalTo(111),
                       "depositpaid",equalTo(true),
                       "bookingdates.checkin",equalTo("2013-02-23"),
                        "bookingdates.checkout",equalTo("2014-10-23"),
                        "additionalneeds",equalTo("Breakfast"));

        //2. Way:(Saturday)









    }


}
