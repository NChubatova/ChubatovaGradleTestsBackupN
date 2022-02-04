package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest2 {

    @Test
    public void test21a() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
            Assert.fail("fail mk");
//System.out.print("GfG1");
        //};

    };
    @Test
    public void test22a() {
        try 
            {
                Thread.sleep(60);
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
    public void test23a() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge2");
            //System.out.print("GfG1");
        };

    };

}
