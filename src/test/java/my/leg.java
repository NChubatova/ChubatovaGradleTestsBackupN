package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class jeg {

    @Test
    public void test61c() {
                 try 
            {
                //Thread.sleep(1);
            Thread.sleep(15);
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
    public void test62c() {
        try 
            {
                //Thread.sleep(90000);
            Thread.sleep(150);
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
    public void test63c() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(150);
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
