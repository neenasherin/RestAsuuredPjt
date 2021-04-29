package files;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.apache.http.auth.Credentials;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.Principal;

public class Book {

   // @Test(dataProvider = "addData")
    public void addBookPost(String isbn,int aisle) {
        RestAssured.baseURI = "http://216.10.245.166";

        String resp = given().

                header("Content-Type", "application/json").

                body(payload.book(isbn,aisle)).

                when().

                post("/Library/Addbook.php").

                then().assertThat().statusCode(200).

                extract().response().asString();

        JsonPath js = ReUsableMethods.rawToJson(resp);
        System.out.println(js.getString("ID"));
    }
    @Test(dataProvider = "deleteData")
    public void deletebook(String del)
    {
        RestAssured.baseURI = "http://216.10.245.166";

        String resp = given().

                header("Content-Type", "application/json").

queryParam("ID="+del).
                when().log().all().

                delete("/Library/Getbook.php").

                then().assertThat().log().all().statusCode(404).

                extract().response().asString();


    }
    @DataProvider
    public Object[][] addData(){
        Object data[][]=new Object[][] {{"ert",227},{"erpt",427},{"pit",657}};
        return data;


    }
    @DataProvider
    public Object[][] deleteData(){
        Object data[][]=new Object[][] {{"ert227"},{"erpt427"},{"pit657"}};
        return data;


    }
}
