package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest {

    @Test
    public void foo12() {
        if (System.currentTimeMillis()%3==1){
        }
        else {
            Assert.fail("fail mkk");

        };

    };
    @Test
    public void foo22() {
        try 
            {
                Thread.sleep(3);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%3==1){
        }
        else {
          //
        };

    };
    @Test
    public void foo32() {
        if (System.currentTimeMillis()%3==1){
        }
        else {
            Assert.fail("fail messajge2");
        };

    };

}
