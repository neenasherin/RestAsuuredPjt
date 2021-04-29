package files;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class AuthBasic {
    @Test
    public void authBasicgit()
    {
        RestAssured.baseURI="https://api.github.com/user";

       // given().auth().preemptive().basic("neenasherin","a98193a4b5ee0a9480345106ba47e5baa352f1b8").when().get().then().log().all().assertThat().statusCode(200);
//given().when().get("https://api.github.com/users/neenasherin/repos").then().log().all().assertThat().statusCode(200);
     String js=   given().header("Content-Type","application/json").
                body(payload.newGit()).
                when().get("https://api.github.com/users/neenasherin/repos").then().extract().response().asString();

     /*   given().auth().preemptive()                                                                                     .basic("neenasherin","a98193a4b5ee0a9480345106ba47e5baa352f1b8").
                header("Content-Type","application/json").
                body(payload.newGit()).
                when().post("https://api.github.com/neenasherin/repos").then().log().all().assertThat().statusCode(200);
*/
        JsonPath js1=new JsonPath(js);
      //  System.out.println(js);
        System.out.println(js1.getString("name"));
    }

}
