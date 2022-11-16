package src.tests.testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGHooksTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\tbeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\tbeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\tbeforeMethod");
    }

    @Test
    public void testA2() {
        System.out.println("\t\t\t\ttestA2");
    }

    @Test
    public void testA1() {
        System.out.println("\t\t\t\ttestA1");
        String actualResult = "sth";
        String expectedResult = "sth_";

        Assert.assertEquals(actualResult, expectedResult, "[ERR] Login username placeholder text incorrect");
        Assert.assertFalse(true, "......");
        Assert.assertTrue(false, ".......");
        Assert.fail("[ERR] There is no category items to test");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expectedResult);
        softAssert.assertAll();
        System.out.println("The test is done");

    }
}
