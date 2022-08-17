package parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLesson {
    @DataProvider(name ="SingleValue")
    public Object[][] StoreSingleValue(){
       return new Object[][]{
               {"Rifat"},
               {"Farid"},
               {"Ashraf"}
       };

    }

    @DataProvider(name="MultipleValues")
    public Object[][] storeMultipleValues(){
        return new Object[][]{
                {"Rifat","Florida", 33018},
                {"Farid","NewYork", 33018},
                {"Rifat","Georgia", 33018}
        };
    }

    @DataProvider(name = "RealAprRate")
    public Object[][] storeRealAprRates(){
        return new Object[][]{
                {"200000","15000","3","3.130%"}
        };
    }

    @Test(dataProvider = "SingleValue")
    public void readSingleValue(String name){
        System.out.println("[Single column value] Name is " + name);
    }



    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String name, String state, int zipCode){
        System.out.println("Name is " + name + " Lives in " + state + " zip is " + zipCode );
    }




}
