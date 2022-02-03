package my;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest3 {

    @Test
    public void test31a() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
            Assert.fail("fail mk");

        //};

    };
    @Test
    public void test32a() {
        try 
            {
                Thread.sleep(30);
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
    public void test33a() {
        if (System.currentTimeMillis()%1==1){
        }
        else {
            Assert.fail("fail messajge2");
        };

    };

}
