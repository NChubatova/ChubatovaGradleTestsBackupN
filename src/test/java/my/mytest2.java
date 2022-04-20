package my;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.*;

import org.junit.jupiter.api.Tag;

public class mytest2 {

    @Tag("fast")
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

    @Tag("fast")
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
