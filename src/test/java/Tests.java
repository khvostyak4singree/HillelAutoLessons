/**
 * Created by hillel on 30.06.17.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MyCode.Code;

public class Tests {

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }

    @Test(dataProvider = "TestData")
    public static void Positive(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) Code.isNumberBetween(testString), expectedResult,"Bad input " + testString);
    }

//    @Parameters({"input"})
//    @Test
//    public static void Negative(String testString){
//        System.out.println(testString);
//        Assert.assertFalse(Code.isNumberBetween(testString), "Bad input " + testString);    }
}
