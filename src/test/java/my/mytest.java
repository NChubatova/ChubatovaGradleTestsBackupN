package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.Thread;

public class mytest {

    @Test
    public void foo1() {
        if (1==1){
            try 
            {
                Thread.sleep(40000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }

        }
        else {
            System.out.println(System.currentTimeMillis());
            try 
            {
                Thread.sleep(40000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
            Assert.fail("fail message");
        };

    };
    @Test
    public void foo2() {
        if (System.currentTimeMillis()%2==1){
            System.out.println(System.currentTimeMillis());
        }
        else {
            System.out.println(System.currentTimeMillis());
            Assert.fail("fail message");
        };

    };
    @Test
    public void foo3() {
        if (System.currentTimeMillis()%1==0){
        }
        else {
            Assert.fail("fail message");
        };

    };

}
