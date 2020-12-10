package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class mytest {

    @Test
    public void foo() {
        if (System.currentTimeMillis()%3==0){

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

}