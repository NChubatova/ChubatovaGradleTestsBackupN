package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest1 {

    @Test
    public void test11a() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail mk4");

        };

    };
    @Test
    public void test12a() {
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
    public void test13a() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge2");
        };

    };

}
