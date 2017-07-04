/**
 * Created by hillel on 30.06.17.
 */

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyCode.Validator;

public class Tests {

    Validator myValidator;

    @DataProvider(name = "TestData")
    public Object[][] createData(){
        return new Object[][] {
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }

    @BeforeTest
    void setUp(){
        System.out.println("Created Object");
         myValidator = new Validator();
    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void Positive(String testString, Boolean expectedResult){
        System.out.println(testString);
        Assert.assertEquals( (Boolean) myValidator.numbers(testString), expectedResult,"Bad input " + testString);
    }

    @AfterMethod
    void afterM(ITestResult testResult){
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }

//    @Parameters({"input"})
//    @Test
//    public static void Negative(String testString){
//        System.out.println(testString);
//        Assert.assertFalse(Validator.isNumberBetween(testString), "Bad input " + testString);    }
}
