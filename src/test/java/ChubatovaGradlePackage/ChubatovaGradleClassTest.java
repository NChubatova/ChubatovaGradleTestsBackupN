package ChubatovaGradlePackage;

import org.junit.Assert;
import org.junit.Test;

public class ChubatovaGradleClassTest {



    @Test

    public void FizzBuzzNormalNumbers() {

        ChubatovaGradleClass fb = new ChubatovaGradleClass();
        Assert.assertEquals("1", fb.convert(2));
    }

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