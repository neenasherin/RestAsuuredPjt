package files;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sum() {
        int sum = 0;
        JsonPath js = new JsonPath(payload.course());
        System.out.println(js.getInt("courses.size()"));
        int size = js.getInt("courses.size()");
        for (int i = 0; i < size; i++) {
            sum = sum + ((js.getInt("courses[" + i + "].price")) * (js.getInt("courses[" + i + "].copies")));
        }
        Assert.assertEquals(sum, js.getInt("dashboard.purchaseAmount"));
    }
}

