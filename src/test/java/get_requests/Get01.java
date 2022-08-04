package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1) Postman is used for manual API testing.
    2) We use Rest-Assured Library for API Automation Testing.
    3) To type automation script follow the given steps:
        a) Understand the requirement
        b) Type test cases
            To type test cases we use 'Gherkin Language'
            The keywords are x) Given: It is for pre-requisites
                             y) When: It is for actions
                             z) Then: It is for outputs
                             t) And: It is used for multiple given, when or then
        c) Start to type the Automation Script
            i) Set the URL
            ii) Set the expected data(Post-Put-Patch)
            iii) Type code to send request
            iv) Do assertion
     */

       /*
        Given
            https://restful-booker.herokuapp.com/booking/101
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01(){

        // i) Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";

        // ii) Set the expected data(Post-Put-Patch)

        //iii) Type code to send request
        Response response = given().when().get(url);
        //response.prettyPrint();

        //iv) Do assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //How to print 'Status Code' on the console
        System.out.println("Status Code: "+response.getStatusCode());

        //How to print 'Content Type' on the console
        System.out.println("Content Type: "+response.getContentType());

        //How to print 'Status Line' on the console
        System.out.println("Status Line: "+response.getStatusLine());

        //How to print 'Header' on the console
        System.out.println(response.getHeader("Connection"));

        //How to print 'Headers' on the console
        System.out.println(response.getHeaders());

        //How to print 'Time' on console.
        System.out.println(response.getTime());

    }
}
