package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest2 {

    @Test
    public void test21cPR() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
            Assert.fail("fail mk");
System.out.print("GfG1");
        //};

    };
    @Test
    public void test22cPR() {
        try 
            {
                //Thread.sleep(90000);
            Thread.sleep(9);
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
    public void test23cPR() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge2");
            System.out.print("GfG1");
        };

    };

}
