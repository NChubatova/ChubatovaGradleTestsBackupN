package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest {

    @Test
    public void foo1() {
        if (System.currentTimeMillis()%3==1){
        }
        else {
            Assert.fail("fail message2");

        };

    };
    @Test
    public void foo2() {
        if (System.currentTimeMillis()%3==1){
        }
        else {
            try 
            {
                Thread.sleep(3000000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        };

    };
    @Test
    public void foo3() {
        if (System.currentTimeMillis()%3==1){
        }
        else {
            Assert.fail("fail message2");
        };

    };

}
