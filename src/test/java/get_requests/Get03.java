package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get03 extends JsonPlaceHolderBaseUrl {

 /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void  get01(){

        // 1. Step Set the URL
        spec.pathParams("first", "todos","second",23);

        //2. Step Set the expected data

        //3. Step: Send the Request and Get Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //4. Step: Do Assertion
        //1st Way:
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId", equalTo(2));

        //2nd Way:
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId", equalTo(2));
        /*
        Note 1: When you execute assertion, Java stops execution after the first failure.
                It means assertion after the failure were not executed.
                But the assertion before failure were passed, because assertions before the failure were executed.
        Note 2: If you type your code as execution will stop in the first failure, this is called "Hard Assertion"
        Note 3: If you type your code as execution will not stop in any failure, this is called "Soft Assertion"
        Note 4: If you use multiple "body()" method it will work like "Hard Assertion", if you use just a single "body()"
                method with multiple assertions in it, it will work like "Soft Assertion"
        */




    }
}