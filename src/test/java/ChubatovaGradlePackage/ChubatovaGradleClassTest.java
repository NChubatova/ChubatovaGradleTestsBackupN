package ChubatovaGradlePackage;

import org.junit.Assert;
import org.junit.*;
import org.junit.Test;


public class ChubatovaGradleClassTest {



    @Test

    public void FizzBuzzNormalNumbers() {

        ChubatovaGradleClass fb = new ChubatovaGradleClass();
        if (System.currentTimeMillis()%2!=0){

            System.out.println(System.currentTimeMillis());
            System.out.println(System.currentTimeMillis()%2);
            //Assert.assertEquals("1", fb.convert(2))
            }
            else {
            System.out.println(System.currentTimeMillis());
            System.out.println(System.currentTimeMillis()%2);
            //Assert.assertEquals("2", fb.convert(2))
                Assert.fail("fail message");
        };

    };

    @Test
    public void FizzBuzzThreeNumbers() {

        ChubatovaGradleClass fb = new ChubatovaGradleClass();
        Assert.assertEquals("Fizz", fb.convert(3));
    }

    @Test
    public void FizzBuzzFiveNumbers() {

        ChubatovaGradleClass fb = new ChubatovaGradleClass();
        Assert.assertEquals("Buzz", fb.convert(5));
    }

    @Test
    public void FizzBuzzThreeAndFiveNumbers() {

        ChubatovaGradleClass fb = new ChubatovaGradleClass();
        Assert.assertEquals("Buzz", fb.convert(5));
    }


}