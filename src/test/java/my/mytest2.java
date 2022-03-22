package my;
//haha
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.lang.*;

public class mytest2 {

    @Test
    public void test21c() {
        //if (System.currentTimeMillis()%3==1){
        //}
        //else {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(1500);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
            //Assert.fail("fail mk");
System.out.print("GfG1");
        //};

    };
    @Test
    public void test22c() {
        try 
            {
                //Thread.sleep(90000);
            Thread.sleep(1500);
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
    public void test23c() {
                 try 
            {
                //Thread.sleep(90000);
            Thread.sleep(1500);
            } 
            catch(InterruptedException e)
            {
            // this part is executed when an exception (in this example InterruptedException) occurs
            }
        if (System.currentTimeMillis()%1==1){
        }
        else {
            
            //Assert.fail("fail messajge2");
            System.out.print("GfG1");
        };

    };

}
