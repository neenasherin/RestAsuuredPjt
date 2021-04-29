package files;

import io.restassured.path.json.JsonPath;

public class CourseDetails {
    public static void main(String[] args) {

        JsonPath js=new JsonPath(payload.course());
        System.out.println(js.getInt("courses.size()"));
        int size=js.getInt("courses.size()");
        System.out.println(js.getInt("dashboard.purchaseAmount"));
        System.out.println(js.getString("courses[2].title"));
       for(int i=0;i<size;i++)
       {
          // System.out.println(js.getString("courses["+i+"].title"));
          // System.out.println(js.getString("courses["+i+"].price"));
           if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")){
               System.out.println(js.getString("courses["+i+"].copies"));

               break;
           }
          //  sum=sum+((js.getInt("courses["+i+"].price"))*(js.getInt("courses["+i+"].copies")));

       }

    }
}
