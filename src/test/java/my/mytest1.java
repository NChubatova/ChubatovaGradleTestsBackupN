package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest1 {

    @Test
    public void test11cPR() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
            Assert.fail("fail mk");
System.out.print("GfG1d");
        //};

    };
    @Test
    public void test12cPR() {
        try 
            {
                //Thread.sleep(180000);
            Thread.sleep(90);
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
    public void test13cPR() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge2");
            System.out.print("GfG1");
        };

    };

}
