package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest3 {

    @Test
    public void test31c() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(15000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
            Assert.fail("fail mkhg");
System.out.print("GfG1s");
        //};

    };
    @Test
    public void test32c() {
        try 
            {
                //Thread.sleep(90000);
            Thread.sleep(15000);
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
    public void test33c() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(15000);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge2");
            System.out.print("GfG1");
        };

    };

}
