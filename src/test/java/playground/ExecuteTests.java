package playground;

import org.testng.annotations.Test;
import parameters.DataProviderLesson;

public class ExecuteTests {
    @Test(dataProvider = "MultipleValues",dataProviderClass = DataProviderLesson.class)
    public void run(String name, String state, int zipCode){
        System.out.println("Name is " + name + " Lives in " + state + " zip is " + zipCode );
    }
}
